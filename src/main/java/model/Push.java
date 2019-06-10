package model;

public class Push extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Page page;
	int ID;
	int PID;
	String type;
	

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public int getPID() {
		return PID;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	@Override
	public String toString() {
		return null;
	}

}
