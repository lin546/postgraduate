package model;

public class Admin extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ID;//	Id	管理员id

	private String account;//	Account	管理员账户
	
	private String password;//	Password	管理员密码
	
	private String power;//	Power	管理员权限

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
