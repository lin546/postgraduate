package service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.FavoriteMapper;
import model.Favorite;
import service.FavoriteService;
@Service
public class FavoriteServiceImpl implements FavoriteService {
	@Autowired
	FavoriteMapper favoriteDao;

	@Override
	public int addFavorite(Favorite favorite) {
		return favoriteDao.addFavorite(favorite);
	}

	@Override
	public ArrayList<Favorite> selectByUserID(int id) {
		return favoriteDao.selectByUserID(id);
	}

	@Override
	public int deleteByID(int id) {
		return favoriteDao.deleteByID(id);
	}
	@Override
	public Favorite selectByID(int id) {
		return favoriteDao.selectByID(id);		
	}

	@Override
	public boolean existFavorite(Favorite favorite) {
		return favoriteDao.existFavorite(favorite)>0;
	}
	@Override
	public int deleteBy2ID(Favorite favorite) {
		return favoriteDao.deleteBy2ID(favorite);
		
	}

	@Override
	public int favoriteNumber(int id) {
		return favoriteDao.favoriteNumber(id);
	}

	@Override
	public int pagefavoriteNumber(int id) {
		return favoriteDao.pagefavoriteNumber(id);
	}

	@Override
	public int deleteByUserID(int id) {
		return favoriteDao.deleteByUserID(id);
	}
	
}
