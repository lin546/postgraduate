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

import model.Favorite;
import model.Page;
import service.impl.AdminServiceImpl;
import service.impl.FavoriteServiceImpl;
import service.impl.PageServiceImpl;
import service.impl.PushServiceImpl;
import service.impl.ReviewsServiceImpl;
import service.impl.UserServiceImpl;
import util.ListPage;

@Controller
public class MainController {
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
	@Autowired
	PushServiceImpl pushService;

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mov =  new ModelAndView("index");
		ArrayList<Page> TJMS = pushService.selectByType("推荐免试");
		mov.addObject("TJMS",TJMS);

		ArrayList<Page> KYJZ = pushService.selectByType("考研简章");
		mov.addObject("KYJZ",KYJZ);
		
		ArrayList<Page> KYZZ = pushService.selectByType("考研政策");
		mov.addObject("KYZZ",KYZZ);
		
		ArrayList<Page> GJZZ = pushService.selectByType("国家政策");
		mov.addObject("GJZZ",GJZZ);
		
		ArrayList<Page> XWZX = pushService.selectByType("新闻资讯");
		mov.addObject("XWZX",XWZX);
		
		ArrayList<Page> KYZL = pushService.selectByType("考研资料");
		mov.addObject("KYZL",KYZL);

		ArrayList<Page> BKZN = pushService.selectByType("备考指南");
		mov.addObject("BKZN",BKZN);

		ArrayList<Page> KYRC = pushService.selectByType("考研日程");
		mov.addObject("KYRC",KYRC);

		ArrayList<Page> KYRD = pushService.selectByType("考研热点");
		mov.addObject("KYRD",KYRD);

		ArrayList<Page> KYDD = pushService.selectByType("考研动态");
		mov.addObject("KYDD",KYDD);

		ArrayList<Page> KYGJ= pushService.selectByType("考研工具");
		mov.addObject("KYGJ",KYGJ);

		ArrayList<Page> XXXZ= pushService.selectByType("学校选择");
		mov.addObject("XXXZ",XXXZ);
		return mov;
	}

	@RequestMapping("/signinpage")
	public ModelAndView signinpage() {
		return new ModelAndView("signin");
	}

	@RequestMapping("/signuppage")
	public ModelAndView signuppage() {
		return new ModelAndView("signup");
	}

	@RequestMapping("/adminloginpage")
	public ModelAndView adminLogInPage() {
		return new ModelAndView("adminlogin");
	}

	@RequestMapping("/addadminpage")
	public ModelAndView addAdminPage() {
		return new ModelAndView("addadmin");
	}

	@RequestMapping("/adduserage")
	public ModelAndView addUserPage() {
		return new ModelAndView("addadmin");
	}

	@RequestMapping("/search")
	public ModelAndView searchPage(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		int start = 0;
		int count = 10;
		try {
			start = Integer.parseInt(request.getParameter("start"));
			if (start < 0) {
				start = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		ListPage LP = new ListPage(start, count);
		PageHelper.offsetPage(LP.getStart(), LP.getCount());
		ArrayList<Page> pages = pageService.search("%" + keyword + "%");
		System.out.println(pages.size());
		int total = (int) new PageInfo<>(pages).getTotal();
		LP.setTotal(total);
		LP.caculateLast(total);
		if (start > total) {
			start = start - count;
			LP = new ListPage(start, count);
			PageHelper.offsetPage(LP.getStart(), LP.getCount());
			pages = pageService.search("%" + keyword + "%");
			total = (int) new PageInfo<>(pages).getTotal();
			LP.setTotal(total);
			LP.caculateLast(total);
		}
		ModelAndView mov = new ModelAndView("resultset");
		mov.addObject("pages", pages);
		mov.addObject("keyword", keyword);
		mov.addObject("LP", LP);
		return mov;
	}

	@RequestMapping("/resultpage")
	public ModelAndView resultpage(HttpServletRequest request, HttpServletResponse response) {
		int ID = Integer.parseInt(request.getParameter("ID"));
		HttpSession session = request.getSession();
		int userId = 0;
		int isfavorite = 0;
		if (session.getAttribute("userId") != null) {
			userId = (int) session.getAttribute("userId");
			Favorite favorite = new Favorite();
			favorite.setPID(ID);
			favorite.setUID(userId);
			if (favoriteService.existFavorite(favorite)) {
				isfavorite=1;
			}
		}
		Page page = pageService.selectByID(ID);
		page.addView();
		pageService.updatePageView(page);
		ModelAndView mov = new ModelAndView("result");
		mov.addObject("isfavorite",isfavorite);
		mov.addObject("page", page);
		return mov;
	}
}
