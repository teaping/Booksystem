package com.ksd.mp.GuanYi;

//ΩË‘ƒ–≈œ¢
public class jiexbook {
	private Integer readerid;
	private String bookcode;
	private String borrowdate;
	private String returndate;
	public Integer getReaderid() {
		return readerid;
	}
	public void setReaderid(Integer readerid) {
		this.readerid = readerid;
	}
	public String getBookcode() {
		return bookcode;
	}
	public void setBookcode(String bookcode) {
		this.bookcode = bookcode;
	}
	public String getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(String borrowdate) {
		this.borrowdate = borrowdate;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public jiexbook(Integer readerid, String bookcode, String borrowdate, String returndate) {
		super();
		this.readerid = readerid;
		this.bookcode = bookcode;
		this.borrowdate = borrowdate;
		this.returndate = returndate;
	}
	public jiexbook() {
		super();
	}
	@Override
	public String toString() {
		return "jiexbook [readerid=" + readerid + ", bookcode=" + bookcode + ", borrowdate=" + borrowdate
				+ ", returndate=" + returndate + "]";
	}

}
