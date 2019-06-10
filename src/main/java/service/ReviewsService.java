package service;

import java.util.ArrayList;

import model.Reviews;

public interface ReviewsService {
	int addReviews(Reviews reviews);

	ArrayList<Reviews> selectByPage(int id);

    int deleteByID(int id);
    
    Reviews selectByID(int ID);
    
    ArrayList<Reviews> selectByUserID(int UID);
    
    int reviewsNumber(int UID);
    
    int deleteByUserID(int ID);
    }
