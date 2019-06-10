package service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReviewsMapper;
import model.Reviews;
import service.ReviewsService;
@Service
public class ReviewsServiceImpl implements ReviewsService {
	@Autowired
	ReviewsMapper reviewsDao;

	@Override
	public int addReviews(Reviews reviews) {
		return reviewsDao.addReviews(reviews);
	}

	@Override
	public ArrayList<Reviews> selectByPage(int id) {
		return reviewsDao.selectByPage(id);
	}

	@Override
	public int deleteByID(int id) {
		return reviewsDao.deleteByID(id);
	}

	@Override
	public Reviews selectByID(int ID) {
		return reviewsDao.selectByID(ID);
	}

	@Override
	public ArrayList<Reviews> selectByUserID(int UID) {
		return reviewsDao.selectByUserID(UID);
	}

	@Override
	public int reviewsNumber(int UID) {
		return reviewsDao.reviewsNumber(UID);
	}

	@Override
	public int deleteByUserID(int ID) {
		return reviewsDao.deleteByUserID(ID);
	}
	
}
