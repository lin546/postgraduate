package web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import model.Admin;
import service.impl.AdminServiceImpl;
import util.ListPage;

@Controller
public class AdminController {
	@Autowired
	AdminServiceImpl adminService;
	
	@RequestMapping("/adminlogin")
	public ModelAndView logIn(HttpServletRequest request, HttpSession session) {
		// 处理参数
		ModelAndView mov;
		String password = request.getParameter("password");
		String account = request.getParameter("account");
		// 验证用户名密码
		int loginVerify = adminService.logIn(account, password);

		// 登录成功
		if (loginVerify == 2) {
			Admin admin = adminService.getAdminByAccount(account);
			Integer adminId = admin.getID();
			// 用户信息写入session
			session.setAttribute("adminId", adminId);
			session.setAttribute("adminaccount", account);
			mov = new ModelAndView("admin");
			return mov;
		}
		// 密码错误
		else if (loginVerify == 1) {
			mov = new ModelAndView("adminlogin");
			mov.addObject("TEXT", "密码错误");
			return mov;
		}
		// 用户名不存在
		else {
			mov = new ModelAndView("adminlogin");
			mov.addObject("TEXT", "用户不存在");
			return mov;
		}
	}
	
	@RequestMapping("/adminlogout")
	public ModelAndView logOut(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
		request.getSession().removeAttribute("adminId");// 清空session信息
		request.getSession().removeAttribute("adminaccount");
		request.getSession().invalidate();// 清除 session 中的所有信息
		// 退出登录的时候清空cookie信息,cookie需要通过HttpServletRequest，HttpServletResponse获取
		Cookie[] cookie = request.getCookies();
		for (Cookie c : cookie) {
			if ("autoLogin".equals(c.getName())) {
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
		return new ModelAndView("redirect:/adminloginpage");
	}

	@RequestMapping("/addadmin")
	public ModelAndView addAdmin(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		int result;
		ModelAndView mov;
		String password = request.getParameter("password");
		String password_again = request.getParameter("password_again");
		if (!password.equals(password_again)) {
			result = 0;
			mov = new ModelAndView("addadmin");
			mov.addObject("TEXT", "两次密码输入不一致");
			return mov;
		}
		String account = request.getParameter("account");
		String power = request.getParameter("power");
		Admin admin = new Admin();
		admin.setAccount(account);
		admin.setPassword(password);
		admin.setPower(power);
		result = adminService.addAdmin(admin);
		if (result == 2) {
			return new ModelAndView("redirect:/adminmanagerpage");
		} else {
			mov = new ModelAndView("addadmin");
			mov.addObject("TEXT", "管理员已存在");
			return mov;
		}
	}

	@RequestMapping("/adminmanagerpage")
	public ModelAndView adminManagerPage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(); 
		
		String power = adminService.getAdminByID((int) session.getAttribute("adminId")).getPower();
		
		ModelAndView mov;
		if(power.equals("最高管理员")){
		int start = 0;
		int count = 10;
		try {
			start = Integer.parseInt(request.getParameter("start"));
			if (start < 0) {
				start = 0;
			}
		} catch (Exception e) {
		}

		ListPage LP = new ListPage(start, count);
		PageHelper.offsetPage(LP.getStart(), LP.getCount());
		ArrayList<Admin> admins = adminService.allAdmin();
		int total = (int) new PageInfo<>(admins).getTotal();
		LP.setTotal(total);
		LP.caculateLast(total);
		if (start > total) {
			start = start - count;
			LP = new ListPage(start, count);
			PageHelper.offsetPage(LP.getStart(), LP.getCount());
			admins = adminService.allAdmin();
			total = (int) new PageInfo<>(admins).getTotal();
			LP.setTotal(total);
			LP.caculateLast(total);
		}
			mov = new ModelAndView("adminmanager");
			mov.addObject("admins", admins);
			mov.addObject("LP", LP);
		}else{
			mov = new ModelAndView("warn");
		}
		return mov;
	}
	
	@RequestMapping("/deleteadmin")
	public ModelAndView deletAdmin(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("ID"));
		adminService.deleteByID(id);
		return new ModelAndView("redirect:/adminmanagerpage");
	}
	@RequestMapping("/updataadminpage")
	public ModelAndView updataadminPage(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("ID"));
		Admin admin = adminService.getAdminByID(id);
		ModelAndView mov = new ModelAndView("updataadmin");
		mov.addObject("admin", admin);
		return mov;
	}

	@RequestMapping("/updataadmin")
	public ModelAndView updataAdmin(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mov;
		int ID= Integer.parseInt(request.getParameter("ID").trim());
		String password = request.getParameter("password");
		String password_again = request.getParameter("password_again");
		if (!password.equals(password_again)) {
			mov = new ModelAndView("updataadmin");
			mov.addObject("TEXT", "两次密码输入不一致");
			return mov;
		}
		String account = request.getParameter("account");
		String power = request.getParameter("power");
		Admin admin = new Admin();
		admin.setID(ID);
		admin.setAccount(account);
		admin.setPassword(password);
		admin.setPower(power);
		adminService.updataAdmin(admin);
		return new ModelAndView("redirect:/adminmanagerpage");

	}
	
	@RequestMapping("/searchadmin")
	public ModelAndView searchAdmin(HttpServletRequest request, HttpServletResponse response) {
		int start = 0;
		int count = 10;
		try {
			start = Integer.parseInt(request.getParameter("start"));
			if (start < 0) {
				start = 0;
			}
		} catch (Exception e) {
		}
		String keyword = request.getParameter("keyword");
		ListPage LP = new ListPage(start, count);
		PageHelper.offsetPage(LP.getStart(), LP.getCount());
		ArrayList<Admin> admins = adminService.search("%"+keyword+"%");
		int total = (int) new PageInfo<>(admins).getTotal();
		LP.setTotal(total);
		LP.caculateLast(total);
		if (start > total) {
			start = start - count;
			LP = new ListPage(start, count);
			PageHelper.offsetPage(LP.getStart(), LP.getCount());
			admins = adminService.search("%"+keyword+"%");
			total = (int) new PageInfo<>(admins).getTotal();
			LP.setTotal(total);
			LP.caculateLast(total);
		}
		ModelAndView mov = new ModelAndView("adminmanager");
		mov.addObject("admins", admins);
		mov.addObject("keyword", keyword);
		mov.addObject("LP", LP);
		return mov;
	}
	@RequestMapping("/warn")
	public ModelAndView warn(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("warn");
	}
	
}
