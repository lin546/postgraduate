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
import service.impl.PageServiceImpl;
import util.ListPage;
import service.impl.FavoriteServiceImpl;

@Controller
public class FavoriteController {
	@Autowired
	FavoriteServiceImpl favoriteService;
	@Autowired
	PageServiceImpl pageService;

	@RequestMapping("/favoritepage")
	public ModelAndView favoritePage(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		int start = 0;
		int count = 10;
		try {
			start = Integer.parseInt(request.getParameter("start"));
			if (start < 0) {
				start = 0;
			}
		} catch (Exception e) {
		}

		HttpSession session = request.getSession();
		int ID = (int) session.getAttribute("userId");
		ListPage LP = new ListPage(start, count);
		PageHelper.offsetPage(LP.getStart(), LP.getCount());
		ArrayList<Favorite> favorites = favoriteService.selectByUserID(ID);
		System.out.println(favorites);
		int total = (int) new PageInfo<>(favorites).getTotal();
		LP.setTotal(total);
		LP.caculateLast(total);
		if (start > total) {
			start = start - count;
			LP = new ListPage(start, count);
			PageHelper.offsetPage(LP.getStart(), LP.getCount());
			total = (int) new PageInfo<>(favorites).getTotal();
			LP.setTotal(total);
			LP.caculateLast(total);
		}
		
		ModelAndView mov = new ModelAndView("favorite");
		mov.addObject("favorites",favorites);
		mov.addObject("UID",ID);
		mov.addObject("LP", LP);
		return mov;
	}

	@RequestMapping("/addfavorite")
	public ModelAndView addfavorite(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		int UID = (int) session.getAttribute("userId");
		int PID = Integer.parseInt(request.getParameter("PID"));
		Page page = pageService.selectByID(PID);
		page.addStar();
		pageService.updatePageStar(page);
		Favorite favorite = new Favorite();
		favorite.setPID(PID);
		favorite.setUID(UID);
		favorite.setTitle(pageService.selectByID(PID).getTitle());
		favoriteService.addFavorite(favorite);
		return new ModelAndView("redirect:/favoritepage?ID="+UID);
	}

	
	@RequestMapping("/deletefavorite")
	public ModelAndView deletefavorite(HttpServletRequest request, HttpServletResponse response) {
		int ID = Integer.parseInt(request.getParameter("ID"));
		HttpSession session = request.getSession();
		int UID = (int) session.getAttribute("userId");
		Page page = pageService.selectByID(favoriteService.selectByID(ID).getPID());
		page.costStar();
		pageService.updatePageStar(page);
		favoriteService.deleteByID(ID);
		return new ModelAndView("redirect:/favoritepage?UID="+UID);
	}
	
	@RequestMapping("/deletefavoritepage")
	public ModelAndView deletefavoritepage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int UID = (int) session.getAttribute("userId");
		int PID = Integer.parseInt(request.getParameter("PID"));
		Page page = pageService.selectByID(PID);
		page.costStar();
		pageService.updatePageStar(page);
		Favorite favorite = new Favorite();
		favorite.setPID(PID);
		favorite.setUID(UID);
		favoriteService.deleteBy2ID(favorite);
		return new ModelAndView("redirect:/resultpage?ID="+PID);
	}
	
	@RequestMapping("/addfavoritepage")
	public ModelAndView addfavoritepage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int UID = (int) session.getAttribute("userId");
		int PID = Integer.parseInt(request.getParameter("PID"));
		Page page = pageService.selectByID(PID);
		page.addStar();
		pageService.updatePageStar(page);
		Favorite favorite = new Favorite();
		favorite.setPID(PID);
		favorite.setUID(UID);
		favorite.setTitle(pageService.selectByID(PID).getTitle());
		favoriteService.addFavorite(favorite);
		return new ModelAndView("redirect:/resultpage?ID="+PID);
	}
}
