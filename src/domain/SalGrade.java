package domain;

public class SalGrade {
	@Override
	public String toString() {
		return "SalGrade [grade=" + grade + ", loSal=" + loSal + ", hiSal=" + hiSal + "]";
	}

	private Integer grade;
	private Integer loSal;
	private Integer hiSal;
	
	public SalGrade() {}
	

	public SalGrade(Integer grade, Integer loSal, Integer hiSal) {
		super();
		this.grade = grade;
		this.loSal = loSal;
		this.hiSal = hiSal;
	}


	/*
	 * These are the getter methods for the Object 
	 */
	
	public Integer getGrade() {
		return grade;
	}

	public Integer getLoSal() {
		return loSal;
	}

	public Integer getHiSal() {
		return hiSal;
	}
	/*
	 * The following setter methods return a handle to the current object in order to implement the fluent style
	 */
	public SalGrade setGrade(Integer grade) {
		this.grade = grade;
		return this;
	}

	public SalGrade setLoSal(Integer loSal) {
		this.loSal = loSal;
		return this;
		
	}

	public SalGrade setHiSal(Integer hiSal) {
		this.hiSal = hiSal;
		return this;
	}
	
	

}
