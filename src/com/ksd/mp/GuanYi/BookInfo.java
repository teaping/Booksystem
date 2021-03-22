package com.ksd.mp.GuanYi;

public class BookInfo {
	private String bookcode;
	private String bookname;// --图书名称   varchar
	private String bookpublish;// --出版社  varchar
	private int bookaddnumber;// --加入数量  int
	private String booksort;// --图书类别    varchar
	private String bookauthor;// --图书作者	varchar
	private String bookprice;// --图书价钱    money
	private String booktime;
	private String yhrq;
	private String readername;
	private Integer readerid;
	private String retumdate;//归还日期
	private String borrowdate;//借书日期
	public String getRetumdate() {
		return retumdate;
	}
	public String getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(String borrowdate) {
		this.borrowdate = borrowdate;
	}
	public void setRetumdate(String retumdate) {
		this.retumdate = retumdate;
	}
	public String getReadercardid() {
		return readercardid;
	}
	public void setReadercardid(String readercardid) {
		this.readercardid = readercardid;
	}
	public String getReadertel() {
		return readertel;
	}
	public void setReadertel(String readertel) {
		this.readertel = readertel;
	}
	public String getReaderremark() {
		return readerremark;
	}
	public void setReaderremark(String readerremark) {
		this.readerremark = readerremark;
	}
	public String getReaderaddress() {
		return readeraddress;
	}
	public void setReaderaddress(String readeraddress) {
		this.readeraddress = readeraddress;
	}
	private String readercardid;
	private String readertel;
	private String readerremark;
	private String readeraddress;
	public Integer getReaderid() {
		return readerid;
	}
	public void setReaderid(Integer readerid) {
		this.readerid = readerid;
	}
	public String getReadername() {
		return readername;
	}
	public void setReadername(String readername) {
		this.readername = readername;
	}
	private Integer cqts;
	public String getYhrq() {
		return yhrq;
	}
	public void setYhrq(String yhrq) {
		this.yhrq = yhrq;
	}
	public Integer getCqts() {
		return cqts;
	}
	public void setCqts(Integer cqts) {
		this.cqts = cqts;
	}
	public String getBookcode() {
		return bookcode;
	}
	public void setBookcode(String bookcode) {
		this.bookcode = bookcode;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookpublish() {
		return bookpublish;
	}
	public void setBookpublish(String bookpublish) {
		this.bookpublish = bookpublish;
	}
	public int getBookaddnumber() {
		return bookaddnumber;
	}
	public void setBookaddnumber(int bookaddnumber) {
		this.bookaddnumber = bookaddnumber;
	}
	public String getBooksort() {
		return booksort;
	}
	public void setBooksort(String booksort) {
		this.booksort = booksort;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
	public String getBookprice() {
		return bookprice;
	}
	public void setBookprice(String bookprice) {
		this.bookprice = bookprice;
	}
	public String getBooktime() {
		return booktime;
	}
	public void setBooktime(String booktime) {
		this.booktime = booktime;
	}
	@Override
	public String toString() {
		return "BookInfo [bookcode=" + bookcode + ", bookname=" + bookname + ", bookpublish=" + bookpublish
				+ ", bookaddnumber=" + bookaddnumber + ", booksort=" + booksort + ", bookauthor=" + bookauthor
				+ ", bookprice=" + bookprice + ", booktime=" + booktime + "]";
	}
	public BookInfo(String bookcode, String bookname, String bookpublish, int bookaddnumber, String booksort,
			String bookauthor, String booktime) {
		super();
		this.bookcode = bookcode;
		this.bookname = bookname;
		this.bookpublish = bookpublish;
		this.bookaddnumber = bookaddnumber;
		this.booksort = booksort;
		this.bookauthor = bookauthor;
		this.booktime = booktime;
		
	}
	public BookInfo(String bookprice,String bookcode, String bookname, String bookpublish, int bookaddnumber, String booksort,
			String bookauthor, String booktime) {
		super();
		this.bookprice=bookprice;
		this.bookcode = bookcode;
		this.bookname = bookname;
		this.bookpublish = bookpublish;
		this.bookaddnumber = bookaddnumber;
		this.booksort = booksort;
		this.bookauthor = bookauthor;
		this.booktime = booktime;
		
	}
	public BookInfo(String bookcode, String bookname, String bookpublish, int bookaddnumber, String booksort,
			String bookauthor, String bookprice, String booktime) {
		super();
		this.bookcode = bookcode;
		this.bookname = bookname;
		this.bookpublish = bookpublish;
		this.bookaddnumber = bookaddnumber;
		this.booksort = booksort;
		this.bookauthor = bookauthor;
		this.bookprice = bookprice;
		this.booktime = booktime;
	}
	public BookInfo(String bookcode, String bookname,
			String bookpublish, String booksort, 
			Integer readerid,
			String retumdate, String readername,String readercardid, 
			String readertel, String readerremark,
			String readeraddress) {
		super();
		this.bookcode = bookcode;
		this.bookname = bookname;
		this.bookpublish = bookpublish;
		this.booksort = booksort;
		this.readername = readername;
		this.readerid = readerid;
		this.retumdate = retumdate;
		this.readercardid = readercardid;
		this.readertel = readertel;
		this.readerremark = readerremark;
		this.readeraddress = readeraddress;
	}
	public BookInfo() {
		super();
	}
	public BookInfo(String bookcode, String bookpublish, int bookaddnumber, String booksort, String bookauthor,
			String booktime) {
		super();
		this.bookcode = bookcode;
		this.bookpublish = bookpublish;
		this.bookaddnumber = bookaddnumber;
		this.booksort = booksort;
		this.bookauthor = bookauthor;
		this.booktime = booktime;
	}
	
	


}
