package service;

import java.util.ArrayList;

import model.Admin;

public interface AdminService {
	int logIn(String account, String password);

	int addAdmin(Admin admin);

	boolean existAccount(String account);

	Admin getAdminByAccount(String account);

	Admin getAdminByID(int ID);

	boolean updataAdmin(Admin admin);

	int deleteByID(int id);

	ArrayList<Admin> allAdmin();

	ArrayList<Admin> search(String keyword);
}
