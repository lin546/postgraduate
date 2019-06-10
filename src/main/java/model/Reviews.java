package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reviews extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	
	private Page page;
	
	private int ID;// Id 评论ID Int

	private int UID;// UserID 用户ID Int

	private int PID;// PageID 页面ID Int

	private String content;// Content 评论内容 Char

	private Date date;// Data 评论时间 Datatime

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public int getPID() {
		return PID;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getData() {
		return date;
	}

	public void setData(Date date) {
		this.date = date;
	}

	public String getLocalCreateTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");// 设置日期格式
		String date = df.format(this.date);
		return date;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
