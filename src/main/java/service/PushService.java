package service;

import java.util.ArrayList;

import model.Page;
import model.Push;

public interface PushService {
	int addPush(Push push);

	ArrayList<Push> search(String keyword);

	Push selectByID(int ID);

	ArrayList<Push> allPush();

	ArrayList<Page> selectByType(String type);

	int deleteByID(int ID);

	boolean existPID(int PID);

	int updateTypeByID(Push push);
}
