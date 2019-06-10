package dao;

import java.util.ArrayList;

import model.Admin;

public interface AdminMapper {
	int addAdmin(Admin admin);

	Admin selectByAccount(String account);

	Admin selectByID(int ID);

	Integer isExistAccount(String account);

	int deleteByID(int id);

	ArrayList<Admin> allAdmin();
	
	int updataAdmin(Admin admin);
	
	ArrayList<Admin> search(String keyword);
}
