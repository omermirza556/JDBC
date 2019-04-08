package domain;
/**
 * 
 * @author omer
 * This is an object representation of the Emp table in our database
 */
public class Emp {
	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", eName=" + eName + ", job=" + job + ", mgr=" + mgr + ", hireDate=" + hireDate
				+ ", sal=" + sal + ", comm=" + comm + ", deptNo=" + deptNo + "]";
	}

	
	private Integer empNo;
	private String eName;
	private String job;
	private Integer mgr;
	private String hireDate;
	private Double sal;
	private Double comm;
	private Integer deptNo;
	
	public Emp() {
		
	}

	public Emp(Integer empNo, String eName, String job, Integer mgr, String hireDate, Double sal, Double comm,
			Integer deptNo) {
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.hireDate = hireDate;
		this.sal = sal;
		this.comm = comm;
		this.deptNo = deptNo;
	}


	/*
	 * These are the getter methods for the Emp Object 
	 */
	
	public Integer getEmpNo() {
		return empNo;
	}

	public String geteName() {
		return eName;
	}

	public String getJob() {
		return job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public String getHireDate() {
		return hireDate;
	}

	public Double getSal() {
		return sal;
	}

	public Double getComm() {
		return comm;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	/*
	 * The following setter methods return a handle to the current object in order to implement the fluent style
	 */
	
	public Emp setEmpNo(Integer empNo) {
		this.empNo = empNo;
		return this;
	}

	public Emp seteName(String eName) {
		this.eName = eName;
		return this;
	}

	public Emp setJob(String job) {
		this.job = job;
		return this;
	}

	public Emp setMgr(Integer mgr) {
		this.mgr = mgr;
		return this;
	}

	public Emp setHireDate(String hireDate) {
		this.hireDate = hireDate;
		return this;
	}

	public Emp setSal(Double sal) {
		this.sal = sal;
		return this;
	}

	public Emp setComm(Double comm) {
		this.comm = comm;
		return this;
	}

	public Emp setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
		return this;
	}
	
	
	
	
	
	
	

}
