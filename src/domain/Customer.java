package domain;
/**
 * 
 * @author omer
 * 
 * This class is an object representation of the customer table in our database
 */
public class Customer {
	

	private Integer custId;
	private String name;
	private String address;
	private String city;
	private String state;
	private Integer zip;
	private String areaCode;
	private String phone;
	private Integer repId;
	private Double creditLimit;
	private String comments;
	
	public Customer(){}

	public Customer(Integer custId, String name, String address, String city, String state, Integer zip,
			String areaCode, String phone, Integer repId, Double creditLimit, String comments) {
		super();
		this.custId = custId;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.areaCode = areaCode;
		this.phone = phone;
		this.repId = repId;
		this.creditLimit = creditLimit;
		this.comments = comments;
	}


	/*
	 * These are the getter methods for the Object 
	 */
	
	public Integer getCustId() {
		return custId;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public Integer getZip() {
		return zip;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public String getPhone() {
		return phone;
	}

	public Integer getRepId() {
		return repId;
	}

	public Double getCreditLimit() {
		return creditLimit;
	}

	public String getComments() {
		return comments;
	}

	/*
	 * The following setter methods return a handle to the current object in order to implement the fluent style
	 */
	public Customer setCustId(Integer custId) {
		this.custId = custId;
		return this;
		
	}

	public Customer setName(String name) {
		this.name = name;
		return this;
		
	}

	public Customer setAddress(String address) {
		this.address = address;
		return this;
		
	}

	public Customer setCity(String city) {
		this.city = city;
		return this;
		
	}

	public Customer setState(String state) {
		this.state = state;
		return this;
		
	}

	public Customer setZip(Integer zip) {
		this.zip = zip;
		return this;
		
	}

	public Customer setAreaCode(String areaCode) {
		this.areaCode = areaCode;
		return this;
		
	}

	public Customer setPhone(String phone) {
		this.phone = phone;
		return this;
		
	}

	public Customer setRepId(Integer repId) {
		this.repId = repId;
		return this;
		
	}

	public Customer setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
		return this;
		
	}

	public Customer setComments(String comments) {
		this.comments = comments;
		return this;
		
	}
	
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", address=" + address + ", city=" + city + ", state="
				+ state + ", zip=" + zip + ", areaCode=" + areaCode + ", phone=" + phone + ", repId=" + repId
				+ ", creditLimit=" + creditLimit + ", comments=" + comments + "]";
	}
	
	
	

}
