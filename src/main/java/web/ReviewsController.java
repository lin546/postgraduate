package web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import model.Reviews;
import service.impl.PageServiceImpl;
import service.impl.ReviewsServiceImpl;
import util.ListPage;

@Controller
public class ReviewsController {
	@Autowired
	ReviewsServiceImpl reviewsService;
	@Autowired
	PageServiceImpl pageService;

	@RequestMapping("/reviewspage")
	public ModelAndView reviewsPage(HttpServletRequest request, HttpServletResponse response) {
		int start = 0;
		int count = 10;

		try {
			start = Integer.parseInt(request.getParameter("start"));
			if (start < 0) {
				start = 0;
			}
		} catch (Exception e) {
		}

		int PID = Integer.parseInt(request.getParameter("PID"));
		ListPage LP = new ListPage(start, count);
		PageHelper.offsetPage(LP.getStart(), LP.getCount());
		ArrayList<Reviews> reviews = reviewsService.selectByPage(PID);
		int total = (int) new PageInfo<>(reviews).getTotal();
		LP.setTotal(total);
		LP.caculateLast(total);
		if (start > total) {
			start = start - count;
			LP = new ListPage(start, count);
			PageHelper.offsetPage(LP.getStart(), LP.getCount());
			total = (int) new PageInfo<>(reviews).getTotal();
			LP.setTotal(total);
			LP.caculateLast(total);
		}
		ModelAndView mov = new ModelAndView("reviews");

		mov.addObject("reviews", reviews);
		mov.addObject("PID", PID);
		mov.addObject("LP", LP);
		return mov;
	}

	@RequestMapping("/addreviews")
	public ModelAndView addReviews(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int UID = (int) session.getAttribute("userId");
		int PID = Integer.parseInt(request.getParameter("PID"));
		String content = request.getParameter("content");
		Reviews reviews = new Reviews();
		reviews.setContent(content);
		reviews.setPID(PID);
		reviews.setUID(UID);
		reviews.setData(new Date());
		reviews.getLocalCreateTime();
		reviewsService.addReviews(reviews);
		return new ModelAndView("redirect:/reviewspage?PID=" + PID);
	}

	@RequestMapping("/deletereviews")
	public ModelAndView deleteReviews(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		int ID = Integer.parseInt(request.getParameter("ID"));
		int PID = reviewsService.selectByID(ID).getPID();
		reviewsService.deleteByID(ID);
		return new ModelAndView("redirect:/reviewspage?PID=" + PID);
	}

	@RequestMapping("/reviewslist")
	public ModelAndView reviewslist(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mov = new ModelAndView("reviewlist");
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
		int UID = (int) session.getAttribute("userId");
		ListPage LP = new ListPage(start, count);
		PageHelper.offsetPage(LP.getStart(), LP.getCount());
		ArrayList<Reviews> reviews = reviewsService.selectByUserID(UID);
		int total = (int) new PageInfo<>(reviews).getTotal();
		LP.setTotal(total);
		LP.caculateLast(total);
		if (start > total) {
			start = start - count;
			LP = new ListPage(start, count);
			PageHelper.offsetPage(LP.getStart(), LP.getCount());
			total = (int) new PageInfo<>(reviews).getTotal();
			LP.setTotal(total);
			LP.caculateLast(total);
		}
		mov.addObject("reviews", reviews);
		mov.addObject("LP", LP);
		return mov;
	}

	@RequestMapping("/deletereviewspage")
	public ModelAndView deleteReviewsPage(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		int ID = Integer.parseInt(request.getParameter("ID"));
		reviewsService.deleteByID(ID);
		return new ModelAndView("redirect:/reviewslist");
	}
}
