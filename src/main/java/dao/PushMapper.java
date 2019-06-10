package dao;

import java.util.ArrayList;

import model.Push;

public interface PushMapper {
	int addPush(Push push);

	ArrayList<Push> allPush();

	ArrayList<Push> search(String keyword);

	Push selectByID(int ID);

	ArrayList<Push> selectByType(String type);

	int deleteByID(int ID);

	int existPID(int PID);

	int updateTypeByID(Push push);
}
