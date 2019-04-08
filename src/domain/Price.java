package domain;
/**
 * 
 * @author omer
 *
 *
 *This class is an object representation for our price table in our database
 */
public class Price {
	@Override
	public String toString() {
		return "Price [prodId=" + prodId + ", stdPrice=" + stdPrice + ", minPrice=" + minPrice + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}

	private Integer prodId;
	private Double stdPrice;
	private Double minPrice;
	private String startDate;
	private String endDate;
	
	public Price() {
		
	}
	
	

	public Price(Integer prodId, Double stdPrice, Double minPrice, String startDate, String endDate) {
		super();
		this.prodId = prodId;
		this.stdPrice = stdPrice;
		this.minPrice = minPrice;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	/*
	 * These are the getter methods for the Object 
	 */

	public Integer getProdId() {
		return prodId;
	}

	public Double getStdPrice() {
		return stdPrice;
	}

	public Double getMinPrice() {
		return minPrice;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}
	

	/*
	 * The following setter methods return a handle to the current object in order to implement the fluent style
	 */

	public Price setProdId(Integer prodId) {
		this.prodId = prodId;
		return this;
	}

	public Price setStdPrice(Double stdPrice) {
		this.stdPrice = stdPrice;
		return this;
	}

	public Price setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
		return this;
	}

	public Price setStartDate(String startDate) {
		this.startDate = startDate;
		return this;
	}

	public Price setEndDate(String endDate) {
		this.endDate = endDate;
		return this;
	}
	
	

}
