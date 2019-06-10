package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Page extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ID;// Id 页面ID Int
	
	private String link;// Link 页面链接 Char
	
	private String title;// Title 页面标题 Char
	
	private int star;// Star 收藏量 Int
	
	private int view;// View 浏览量 Int
	
	private String source;
	
	private String content;// Content 正文 Varchar
	
	private Date date;// Date 发布时间 Datatime
	
	private boolean selected; 
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
    public String getLocalCreateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");//设置日期格式
        String date = df.format(this.date);
        return date;
    }
    
    public void addView(){
    	this.view+=1;
    }
    
    public void addStar(){
    	this.star+=1;
    }
    
    public void costStar(){
    	this.star-=1;
    }
    
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}



	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
