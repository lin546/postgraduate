package dao;

import java.util.ArrayList;

import model.Page;

public interface PageMapper {

	int addPage(Page page);

	Page selectByID(int id);

	Page selectByTitle(String title);

	// 查询pagename是否存在
	int existTitle(String title);

	int deleteByID(int id);

	ArrayList<Page> allPage();

	ArrayList<Page> search(String keyword);

	void updatePageView(Page page);

	void updatePageStar(Page page);

}
