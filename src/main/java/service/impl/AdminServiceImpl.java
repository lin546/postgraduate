package service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AdminMapper;
import model.Admin;
import service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminMapper adminDao;
	@Override
	public int logIn(String account, String password) {
		Boolean isexist = existAccount(account);
		if (isexist) {
			Admin admin = getAdminByAccount(account);
			if (admin.getPassword().equals(password)) {
				return 2;
			}
			return 1;
		}
		return 0;
	}

	@Override
	public int addAdmin(Admin admin) {
		Boolean isexist= existAccount(admin.getAccount());
		if(isexist){
			return 1;
		}else{
			adminDao.addAdmin(admin);
			return 2;
		}
	}

	@Override
	public boolean updataAdmin(Admin admin) {
		return adminDao.updataAdmin(admin)>0;
	}

	@Override
	public boolean existAccount(String account) {
		return adminDao.isExistAccount(account)>0;
	}

	@Override
	public Admin getAdminByAccount(String account) {
		return adminDao.selectByAccount(account);
	}
	
	@Override
	public int deleteByID(int id){
		return adminDao.deleteByID(id);
	}

	@Override
	public Admin getAdminByID(int ID) {
		return adminDao.selectByID(ID);
	}
	@Override
	public	ArrayList<Admin> allAdmin() {
		return adminDao.allAdmin();
	}

	@Override
	public ArrayList<Admin> search(String keyword) {
		// TODO Auto-generated method stub
		return adminDao.search(keyword);
	}


}
