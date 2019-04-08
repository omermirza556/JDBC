package domain;
/**
 * 
 * @author omer
 * 
 * This is an object representation of the Department table in our database
 *
 */
public class Dept {
	private Integer deptNo;
	private String dName;
	private String loc;
	
	public Dept() {
		
	}
	
	public Dept(Integer deptNo, String dName, String loc) {
		this.deptNo = deptNo;
		this.dName = dName;
		this.loc = loc;
	}
	/*
	 * These are the getter methods for the Dept Object 
	 */
	public Integer getDeptNo() {
		return deptNo;
	}

	public String getdName() {
		return dName;
	}

	public String getLoc() {
		return loc;
	}
	
	/*
	 * The following setter methods return a handle to the current object in order to implement the fluent style
	 */

	public Dept setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
		return this;
	}

	public Dept setdName(String dName) {
		this.dName = dName;
		return this;
	}

	public Dept setLoc(String loc) {
		this.loc = loc;
		return this;
	}

	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", dName=" + dName + ", loc=" + loc + "]";
	}
	
	

}
