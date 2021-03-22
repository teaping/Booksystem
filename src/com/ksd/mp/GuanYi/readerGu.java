package com.ksd.mp.GuanYi;
/**
 *¶ÁÕß¶ÔÏó
 * */
public class readerGu {
	private Integer readerid;
	private String readername;
	private	String readercardid;
	private String readerdate;
	private	String readertel;
	private String readeraddress;
	private String readerremark;
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
	public String getReadercardid() {
		return readercardid;
	}
	public void setReadercardid(String readercardid) {
		this.readercardid = readercardid;
	}
	public String getReaderdate() {
		return readerdate;
	}
	public void setReaderdate(String readerdate) {
		this.readerdate = readerdate;
	}
	public String getReadertel() {
		return readertel;
	}
	public void setReadertel(String readertel) {
		this.readertel = readertel;
	}
	public String getReaderaddress() {
		return readeraddress;
	}
	public void setReaderaddress(String readeraddress) {
		this.readeraddress = readeraddress;
	}
	public String getReaderremark() {
		return readerremark;
	}
	public void setReaderremark(String readerremark) {
		this.readerremark = readerremark;
	}
	public readerGu(Integer readerid, String readername, String readercardid, String readerdate, String readertel,
			String readeraddress, String readerremark) {
		super();
		this.readerid = readerid;
		this.readername = readername;
		this.readercardid = readercardid;
		this.readerdate = readerdate;
		this.readertel = readertel;
		this.readeraddress = readeraddress;
		this.readerremark = readerremark;
	}
	public readerGu() {
		super();
	}
	@Override
	public String toString() {
		return "readerGu [readerid=" + readerid + ", readername=" + readername + ", readercardid=" + readercardid
				+ ", readerdate=" + readerdate + ", readertel=" + readertel + ", readeraddress=" + readeraddress
				+ ", readerremark=" + readerremark + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((readeraddress == null) ? 0 : readeraddress.hashCode());
		result = prime * result + ((readercardid == null) ? 0 : readercardid.hashCode());
		result = prime * result + ((readerdate == null) ? 0 : readerdate.hashCode());
		result = prime * result + ((readerid == null) ? 0 : readerid.hashCode());
		result = prime * result + ((readername == null) ? 0 : readername.hashCode());
		result = prime * result + ((readerremark == null) ? 0 : readerremark.hashCode());
		result = prime * result + ((readertel == null) ? 0 : readertel.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		readerGu other = (readerGu) obj;
		if (readeraddress == null) {
			if (other.readeraddress != null)
				return false;
		} else if (!readeraddress.equals(other.readeraddress))
			return false;
		if (readercardid == null) {
			if (other.readercardid != null)
				return false;
		} else if (!readercardid.equals(other.readercardid))
			return false;
		if (readerdate == null) {
			if (other.readerdate != null)
				return false;
		} else if (!readerdate.equals(other.readerdate))
			return false;
		if (readerid == null) {
			if (other.readerid != null)
				return false;
		} else if (!readerid.equals(other.readerid))
			return false;
		if (readername == null) {
			if (other.readername != null)
				return false;
		} else if (!readername.equals(other.readername))
			return false;
		if (readerremark == null) {
			if (other.readerremark != null)
				return false;
		} else if (!readerremark.equals(other.readerremark))
			return false;
		if (readertel == null) {
			if (other.readertel != null)
				return false;
		} else if (!readertel.equals(other.readertel))
			return false;
		return true;
	}
	

}
