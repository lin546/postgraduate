package web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import model.Page;
import model.Push;
import service.impl.AdminServiceImpl;
import service.impl.PageServiceImpl;
import service.impl.PushServiceImpl;
import util.ListPage;

@Controller
public class PushController {
	@Autowired
	PushServiceImpl pushService;
	@Autowired
	PageServiceImpl pageService;
	@Autowired
	AdminServiceImpl adminService;

	@RequestMapping("/indexpushpage")
	public ModelAndView webdataPage(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String power = adminService.getAdminByID((int) session.getAttribute("adminId")).getPower();
		ModelAndView mov;
		if (power.equals("最高管理员") || power.equals("推送管理员")) {
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
			ArrayList<Push> pushs = pushService.allPush();

			int total = (int) new PageInfo<>(pushs).getTotal();
			LP.setTotal(total);
			LP.caculateLast(total);
			if (start > total) {
				start = start - count;
				LP = new ListPage(start, count);
				PageHelper.offsetPage(LP.getStart(), LP.getCount());
				pushs = pushService.allPush();
				total = (int) new PageInfo<>(pushs).getTotal();
				LP.setTotal(total);
				LP.caculateLast(total);
			}
			mov = new ModelAndView("indexpush");
			mov.addObject("pushs", pushs);
			mov.addObject("LP", LP);
		} else {
			mov = new ModelAndView("warn");
		}
		return mov;
	}

	@RequestMapping("/deletepush")
	public ModelAndView deletPush(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("ID"));
		pushService.deleteByID(id);
		return new ModelAndView("redirect:/indexpushpage");
	}

	@RequestMapping("/addpushpage")
	public ModelAndView addPushPage(HttpServletRequest request, HttpServletResponse response) {
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
		ArrayList<Page> pages = pageService.allPage();
		int total = (int) new PageInfo<>(pages).getTotal();
		LP.setTotal(total);
		LP.caculateLast(total);
		if (start > total) {
			start = start - count;
			LP = new ListPage(start, count);
			PageHelper.offsetPage(LP.getStart(), LP.getCount());
			pages = pageService.allPage();
			total = (int) new PageInfo<>(pages).getTotal();
			LP.setTotal(total);
			LP.caculateLast(total);
		}
		ModelAndView mov = new ModelAndView("addpush");
		mov.addObject("pages", pages);
		mov.addObject("LP", LP);
		return mov;
	}

	@RequestMapping("/addpush")
	public ModelAndView addPush(HttpServletRequest request, HttpServletResponse response) {
		int PID = Integer.parseInt(request.getParameter("PID"));
		Page page = pageService.selectByID(PID);
		ModelAndView mov = new ModelAndView("addpush2");
		mov.addObject("push", page);
		return mov;
	}

	@RequestMapping("/addpushwithtype")
	public ModelAndView addpushwithtype(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		int ID = Integer.parseInt(request.getParameter("ID"));
		String type = request.getParameter("type");
		Push push = new Push();
		push.setPID(ID);
		push.setType(type);
		push.setPage(pageService.selectByID(ID));
		pushService.addPush(push);
		return new ModelAndView("redirect:/addpushpage");
	}

	@RequestMapping("updatatype")
	public ModelAndView updatatype(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		int ID = Integer.parseInt(request.getParameter("ID"));
		Push push = pushService.selectByID(ID);

		ModelAndView mov = new ModelAndView("updatapush");
		mov.addObject("push", push);
		return mov;
	}

	@RequestMapping("updatapushwithtype")
	public ModelAndView updatapushwithtype(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		int ID = Integer.parseInt(request.getParameter("ID"));
		Push push = pushService.selectByID(ID);
		String type = request.getParameter("type");
		push.setType(type);
		pushService.updateTypeByID(push);
		return new ModelAndView("redirect:/indexpushpage");
	}

	@RequestMapping("/searchpush")
	public ModelAndView searchPush(HttpServletRequest request, HttpServletResponse response) {
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
		ArrayList<Push> pages = pushService.search("%" + keyword + "%");
		int total = (int) new PageInfo<>(pages).getTotal();
		LP.setTotal(total);
		LP.caculateLast(total);
		if (start > total) {
			start = start - count;
			LP = new ListPage(start, count);
			PageHelper.offsetPage(LP.getStart(), LP.getCount());
			pages = pushService.search("%" + keyword + "%");
			total = (int) new PageInfo<>(pages).getTotal();
			LP.setTotal(total);
			LP.caculateLast(total);
		}
		ModelAndView mov = new ModelAndView("indexpush");
		mov.addObject("keyword",keyword);
		mov.addObject("pushs", pages);
		mov.addObject("LP", LP);
		return mov;
	}
	
	@RequestMapping("/searchunpush")
	public ModelAndView searchunPage(HttpServletRequest request, HttpServletResponse response) {
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
		ArrayList<Page> pages = pageService.search("%" + keyword + "%");
		int total = (int) new PageInfo<>(pages).getTotal();
		LP.setTotal(total);
		LP.caculateLast(total);
		if (start > total) {
			start = start - count;
			LP = new ListPage(start, count);
			PageHelper.offsetPage(LP.getStart(), LP.getCount());
			pages = pageService.allPage();
			total = (int) new PageInfo<>(pages).getTotal();
			LP.setTotal(total);
			LP.caculateLast(total);
		}
		ModelAndView mov = new ModelAndView("addpush");
		mov.addObject("pages", pages);
		mov.addObject("keyword", keyword);
		mov.addObject("LP", LP);
		return mov;
	}

}
