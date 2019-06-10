package service;

import java.util.ArrayList;

import model.Favorite;

public interface FavoriteService {
	int addFavorite(Favorite favorite);

	ArrayList<Favorite> selectByUserID(int id);

	int deleteByID(int id);

	Favorite selectByID(int id);

	boolean existFavorite(Favorite favorite);
	
	int deleteByUserID(int id);

	int deleteBy2ID(Favorite favorite);

	int favoriteNumber(int id);

	int pagefavoriteNumber(int id);

}
