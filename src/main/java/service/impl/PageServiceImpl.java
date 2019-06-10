package service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PageMapper;
import model.Page;
import service.PageServce;
@Service
public class PageServiceImpl implements PageServce {
	@Autowired
	PageMapper pageDao;

	@Override
	public int addPage(Page page) {
		Boolean isexist= existTitle(page.getTitle());
		if(isexist){
			return 1;
		}else{
			pageDao.addPage(page);
			return 0;
		}
	}

	@Override
	public Page selectByID(int id) {		
		return pageDao.selectByID(id);
	}

	@Override
	public Page selectByTitle(String title) {		
		return pageDao.selectByTitle(title);
	}

	@Override
	public Boolean existTitle(String title) {
		
		return pageDao.existTitle(title)>0;
	}

	@Override
	public int deleteByID(int id) {
		return pageDao.deleteByID(id);
	}

	@Override
	public ArrayList<Page> allPage() {
		return pageDao.allPage();
	}

	@Override
	public ArrayList<Page> search(String keyword) {
		return pageDao.search(keyword);
	}

	@Override
	public void updatePageView(Page page) {
		pageDao.updatePageView(page);	
	}

	@Override
	public void updatePageStar(Page page) {
		pageDao.updatePageStar(page);	
	}


	



}
