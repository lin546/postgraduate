package dao;

import java.util.ArrayList;

import model.Favorite;

public interface FavoriteMapper {

	int addFavorite(Favorite favorite);

	ArrayList<Favorite> selectByUserID(int id);

	int deleteByID(int id);
	
	int deleteByUserID(int id);
	
	Favorite selectByID(int id);

	int existFavorite(int PID, int UID);

	int deleteBy2ID(Favorite favorite);

	int existFavorite(Favorite favorite);

	int favoriteNumber(int id);

	int pagefavoriteNumber(int id);

}
