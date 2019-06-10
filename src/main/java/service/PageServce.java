package service;

import java.util.ArrayList;

import model.Page;

public interface PageServce {

	int addPage(Page page);

	Page selectByID(int id);

	Page selectByTitle(String title);

	// 查询pagename是否存在
	Boolean existTitle(String title);

	int deleteByID(int id);

	ArrayList<Page> allPage();

	ArrayList<Page> search(String keyword);

	void updatePageView(Page page);

	void updatePageStar(Page page);
}
