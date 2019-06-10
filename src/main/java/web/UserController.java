package web;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import model.User;
import service.impl.AdminServiceImpl;
import service.impl.FavoriteServiceImpl;
import service.impl.PageServiceImpl;
import service.impl.ReviewsServiceImpl;
import service.impl.UserServiceImpl;
import util.ListPage;
import util.Tools;

@Controller
public class UserController {
	@Autowired
	AdminServiceImpl adminService;
	@Autowired
	UserServiceImpl userService;
	@Autowired
	FavoriteServiceImpl favoriteService;
	@Autowired
	PageServiceImpl pageService;
	@Autowired
	ReviewsServiceImpl reviewsService;

	@RequestMapping("/userlogin")
	public ModelAndView login(HttpServletRequest request, HttpSession session) {
		// 处理参数
		ModelAndView mov;
		String password = request.getParameter("password");
		String account = request.getParameter("account");
		// 验证用户名密码
		int loginVerify = userService.login(account, password);
		// 登录成功
		if (loginVerify == 2) {
			User user = userService.getUserByAccount(account);
			Integer userId = user.getID();
			// 用户信息写入session
			session.setAttribute("userId", userId);
			session.setAttribute("useraccount", account);
			session.setAttribute("userImg", user.getImage());
			session.setAttribute("usernickname", user.getNickname());
			mov = new ModelAndView("redirect:/index");
			return mov;
		}
		// 密码错误
		else if (loginVerify == 1) {
			mov = new ModelAndView("signin");
			mov.addObject("TEXT", "密码错误");
			return mov;
		} else if (loginVerify == 3) {
			mov = new ModelAndView("signin");
			mov.addObject("TEXT", "用户被封禁");
			return mov;
		}
		// 用户名不存在
		else {
			mov = new ModelAndView("signin");
			mov.addObject("TEXT", "用户不存在");
			return mov;
		}
	}

	@RequestMapping("/userlog"+"out")
	public ModelAndView logOut(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
		request.getSession().removeAttribute("userId");// 清空session信息
		request.getSession().removeAttribute("useraccount");
		request.getSession().invalidate();// 清除 session 中的所有信息
		// 退出登录的时候清空cookie信息,cookie需要通过HttpServletRequest，HttpServletResponse获取
		Cookie[] cookie = request.getCookies();
		for (Cookie c : cookie) {
			if ("autoLogin".equals(c.getName())) {
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
		return new ModelAndView("redirect:/index");
	}

	@RequestMapping("/usersignup")
	public ModelAndView usersignup(HttpServletRequest request, HttpSession session, HttpServletResponse response)
			throws UnsupportedEncodingException, ParseException {
		int result;
		ModelAndView mov;
		String account = request.getParameter("account");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String password_again = request.getParameter("password_again");
		if (password.length() == 0 || password_again.length() == 0 || account.length() == 0 || email.length() == 0 || phone.length() == 0) {
			result = 0;
			mov = new ModelAndView("signup");
			mov.addObject("TEXT", "请完整填入信息");
			return mov;
		}
		if (!password.equals(password_again)) {
			result = 0;
			mov = new ModelAndView("signup");
			mov.addObject("TEXT", "两次密码输入不一致");
			return mov;
		}

		if (!checkMobileNumber(phone)) {
			mov = new ModelAndView("signup");
			mov.addObject("TEXT", "手机号格式不正确");
			return mov;
		}
		if (!checkEmail(email)) {
			mov = new ModelAndView("signup");
			mov.addObject("TEXT", "邮箱格式不正确");
			return mov;
		}
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		user.setNickname(account);
		user.setSex("保密");
		user.setImage("static/img/picture.jpg");
		user.setBirthday(Tools.createDate("yyyy-MM-dd", "1970-00-01"));
		user.setDate(new Date());
		user.getLocalCreateTime();
		user.setStatus(0);
		result = userService.addUser(user);
		if (result == 2) {
			return new ModelAndView("redirect:/signinpage");
		} else {
			mov = new ModelAndView("signup");
			mov.addObject("TEXT", "用户已存在");
			return mov;
		}
	}

	@RequestMapping("/userinfopage")
	public ModelAndView userInfoPage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		ModelAndView mov = new ModelAndView("myinfo");
		User user = userService.getUserById(userId);
		int numF = favoriteService.favoriteNumber(user.getID());
		int numR = reviewsService.reviewsNumber(user.getID());
		mov.addObject("user", user);
		mov.addObject("numF", numF);
		mov.addObject("numR", numR);
		return mov;
	}

	@RequestMapping("/updatauserpage")
	public ModelAndView updatauserPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mov = new ModelAndView("myinfoupdata");
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		User user = userService.getUserById(userId);
		String TEXT = request.getParameter("TEXT");
		mov.addObject("TEXT", TEXT);
		mov.addObject("user", user);
		return mov;
	}

	@RequestMapping("/usermanagerpage")
	public ModelAndView userManagerPage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String power = adminService.getAdminByID((int) session.getAttribute("adminId")).getPower();
		ModelAndView mov;
		if (power.equals("最高管理员") || power.equals("用户管理员")) {
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
			ArrayList<User> users = userService.allUser();
			int total = (int) new PageInfo<>(users).getTotal();
			LP.setTotal(total);
			LP.caculateLast(total);
			if (start > total) {
				start = start - count;
				LP = new ListPage(start, count);
				PageHelper.offsetPage(LP.getStart(), LP.getCount());
				users = userService.allUser();
				total = (int) new PageInfo<>(users).getTotal();
				LP.setTotal(total);
				LP.caculateLast(total);
			}
			mov = new ModelAndView("usermanager");
			mov.addObject("users", users);
			mov.addObject("LP", LP);
		} else {
			mov = new ModelAndView("warn");
		}
		return mov;
	}

	@RequestMapping("/deleteuser")
	public ModelAndView deletUser(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("ID"));
		userService.deleteByID(id);
		reviewsService.deleteByUserID(id);
		favoriteService.deleteByUserID(id);
		return new ModelAndView("redirect:/usermanagerpage");
	}

	@RequestMapping("/updatauser")
	public ModelAndView updataUser(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, ParseException {
		ModelAndView mov;
		HttpSession session = request.getSession();
		int ID = (int) session.getAttribute("userId");
		User user = userService.getUserById(ID);
		System.out.println(user.toString());
		String oldpassword = request.getParameter("oldpassword");
		if (!oldpassword.isEmpty()) {
			if (!oldpassword.equals(user.getPassword())) {
				mov = new ModelAndView("redirect:/updatauserpage");
				mov.addObject("TEXT", "原密码错误");
				return mov;
			}
			String password = request.getParameter("newpassword");
			String password_again = request.getParameter("newpasswordagain");
			if (!password.equals(password_again)) {
				mov = new ModelAndView("redirect:/updatauserpage");
				mov.addObject("TEXT", "两次密码输入不一致");
				return mov;
			}
			user.setPassword(password);
		}
		String nickname = request.getParameter("nickname");
		if (!nickname.isEmpty()) {
			user.setNickname(nickname);
		}
		String email = request.getParameter("email");
		if (!email.isEmpty()) {
			user.setEmail(email);
			if (!checkEmail(email)) {
				mov = new ModelAndView("redirect:/updatauserpage");
				mov.addObject("TEXT", "邮箱格式不正确");
				return mov;
			}
		}
		String phone = request.getParameter("phone");
		if (!phone.isEmpty()) {
			if (!checkMobileNumber(phone)) {
				mov = new ModelAndView("redirect:/updatauserpage");
				mov.addObject("TEXT", "手机号格式不正确");
				return mov;
			}
			user.setPhone(phone);
		}

		String sex = request.getParameter("sex");
		if (!sex.isEmpty()) {
			user.setSex(sex);
		}

		String year = request.getParameter("year");
		String month = request.getParameter("month");
		int day = 0;
		if (!request.getParameter("day").isEmpty()) {
			day = Integer.parseInt(request.getParameter("day")) + 1;
		}
		if (!year.isEmpty() && !month.isEmpty()) {
			user.setBirthday(Tools.createDate("yyyy-MM-dd", year + "-" + month + "-" + day));
		}
		userService.updateUserByID(user);
		session.setAttribute("usernickname", user.getNickname());
		mov = new ModelAndView("redirect:/userinfopage");
		return mov;

	}
	@RequestMapping("/searchuser")
	public ModelAndView searchUser(HttpServletRequest request, HttpServletResponse response) {
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
		ArrayList<User> users = userService.search("%" + keyword + "%");
		int total = (int) new PageInfo<>(users).getTotal();
		LP.setTotal(total);
		LP.caculateLast(total);
		if (start > total) {
			start = start - count;
			LP = new ListPage(start, count);
			PageHelper.offsetPage(LP.getStart(), LP.getCount());
			users = userService.search("%" + keyword + "%");
			total = (int) new PageInfo<>(users).getTotal();
			LP.setTotal(total);
			LP.caculateLast(total);
		}
		ModelAndView mov = new ModelAndView("usermanager");
		mov.addObject("keyword", keyword);
		mov.addObject("users", users);
		mov.addObject("LP", LP);
		return mov;
	}

	@RequestMapping("/closeuser")
	public ModelAndView closeUser(HttpServletRequest request, HttpServletResponse response) {

		int ID = Integer.parseInt(request.getParameter("ID"));
		User user = userService.getUserById(ID);
		user.setStatus(1);
		userService.updateUserByID(user);
		return new ModelAndView("redirect:/usermanagerpage");
	}

	@RequestMapping("/forgetpwdpage")
	public ModelAndView wjmmPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("forgetpwd");

	}
	@RequestMapping("/forgetpwd")
	public ModelAndView wjmm(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mov;
		String account = request.getParameter("account");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String password_again = request.getParameter("password_again");
		if (password.length() == 0 || password_again.length() == 0 || account.length() == 0 || email.length() == 0
				|| phone.length() == 0) {
			mov = new ModelAndView("forgetpwdpage");
			mov.addObject("TEXT", "请完整填入信息");
			return mov;
		}
		if (!userService.existAccount(account)) {
			mov = new ModelAndView("forgetpwdpage");
			mov.addObject("TEXT", "用户不存在");
			return mov;
		}
		User user = userService.getUserByAccount(account);

		if (!user.getEmail().equals(email) || !user.getPhone().equals(phone)) {
			mov = new ModelAndView("forgetpwdpage");
			mov.addObject("TEXT", "邮箱或手机号错误");
			return mov;
		}
		if (!password.equals(password_again)) {
			mov = new ModelAndView("forgetpwdpage");
			mov.addObject("TEXT", "两次密码输入不一致");
			return mov;
		}
		user.setPassword(password);
		userService.updateUserByID(user);
		return new ModelAndView("redirect:/signinpage");
	}

	@RequestMapping("/openuser")
	public ModelAndView openUser(HttpServletRequest request, HttpServletResponse response) {

		int ID = Integer.parseInt(request.getParameter("ID"));
		User user = userService.getUserById(ID);
		user.setStatus(0);
		userService.updateUserByID(user);
		return new ModelAndView("redirect:/usermanagerpage");
	}

	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(email);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 验证手机号码，11位数字，1开通，第二位数必须是3456789这些数字之一 *
	 */
	static Pattern regex = Pattern.compile("^1[345789]\\d{9}$");
	public static boolean checkMobileNumber(String mobileNumber) {
		boolean flag = false;
		try {
			Matcher matcher = regex.matcher(mobileNumber);
			flag = matcher.matches();
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
}
