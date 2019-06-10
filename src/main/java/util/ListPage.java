package util;

public class ListPage {
	int start = 0;
	int count = 8;
	int total = 0;
	int last = 0;

	public ListPage(int start, int count) {
		super();
		this.start = start;
		this.count = count;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public void caculateLast(int total) {
		// 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
		if (0 == total % count)
			last = total - count;
		// 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
		else
			last = total - total % count;
	}

}