/**
 * 
 */
package service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PushMapper;
import model.Page;
import model.Push;
import service.PushService;

/**
 * @author 44977
 *
 */
@Service
public class PushServiceImpl implements PushService {
	@Autowired
	PushMapper pushDao;
	/* (non-Javadoc)
	 * @see service.PushService#addPush(model.Push)
	 */
	@Override
	public int addPush(Push push) {
		// TODO Auto-generated method stub
		return pushDao.addPush(push);
	}

	/* (non-Javadoc)
	 * @see service.PushService#search(java.lang.String)
	 */
	@Override
	public ArrayList<Push> search(String keyword) {
		// TODO Auto-generated method stub
		return pushDao.search(keyword);
	}

	/* (non-Javadoc)
	 * @see service.PushService#selectByID(int)
	 */
	@Override
	public Push selectByID(int ID) {
		// TODO Auto-generated method stub
		return pushDao.selectByID(ID);
	}

	/* (non-Javadoc)
	 * @see service.PushService#selectByType(java.lang.String)
	 */
	@Override
	public ArrayList<Page> selectByType(String type) {
		ArrayList<Push> pushs = pushDao.selectByType(type);
		ArrayList<Page> pages = new ArrayList<Page>();
		for (Push push : pushs) {
			pages.add(push.getPage());
		}
		
		return pages;
	}

	/* (non-Javadoc)
	 * @see service.PushService#deleteByID(int)
	 */
	@Override
	public int deleteByID(int ID) {
		// TODO Auto-generated method stub
		return pushDao.deleteByID(ID);
	}
	@Override
	public ArrayList<Push> allPush() {
		// TODO Auto-generated method stub
		return pushDao.allPush();
	}

	@Override
	public boolean existPID(int PID) {
		// TODO Auto-generated method stub
		return pushDao.existPID(PID)>0;
	}

	@Override
	public int updateTypeByID(Push push) {
		// TODO Auto-generated method stub
		return pushDao.updateTypeByID(push);
	}

}
