package dao;

import java.util.ArrayList;

import model.Reviews;

public interface ReviewsMapper {
	
	int addReviews(Reviews reviews);

	ArrayList<Reviews> selectByPage(int id);

    int deleteByID(int ID);
    
    Reviews selectByID(int ID);
    
    ArrayList<Reviews> selectByUserID(int UID);
    
    int reviewsNumber(int UID);
    
    int deleteByUserID(int ID);
}
