package domain;
/**
 * 
 * @author omer
 *
 * This is an object representation of our Product Table in the database
 */

public class Product {
	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", descrip=" + descrip + "]";
	}

	private Integer prodId;
	private String descrip;
	
	public Product () {
		this.prodId = null;
		this.descrip = null;
	}
	
	public Product(Integer prodId, String descrip) {
		this.prodId = prodId;
		this.descrip = descrip; 
	}
	
	/*
	 * These are the getter methods for the Product Object 
	 */

	public Integer getProdId() {
		return prodId;
	}

	
	public String getDescrip() {
		return descrip;
	}
	
	/*
	 * The following setter methods return a handle to the current object in order to implement the fluent style
	 */

	public Product setDescrip(String descrip) {
		this.descrip = descrip;
		return this;
	}
	
	public Product setProdId(Integer prodId) {
		this.prodId = prodId;
		return this;
	}

	
	
	

}
