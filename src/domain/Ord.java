package domain;
/**
 * 
 * @author omer
 *This is an object representation of the order table in our database
 */
public class Ord {
	@Override
	public String toString() {
		return "Ord [ordId=" + ordId + ", orderDate=" + orderDate + ", commPlan=" + commPlan + ", custId=" + custId
				+ ", shipDate=" + shipDate + ", total=" + total + "]";
	}

	private Integer ordId;
	private String orderDate;
	private String commPlan;
	private Integer custId;
	private String shipDate;
	private Double total;
	
	public Ord() {
		
	}

	public Ord(Integer ordId, String orderDate, String commPlan, Integer custId, String shipDate, Double total) {
		super();
		this.ordId = ordId;
		this.orderDate = orderDate;
		this.commPlan = commPlan;
		this.custId = custId;
		this.shipDate = shipDate;
		this.total = total;
	}
	
	/*
	 * These are the getter methods for the Emp Object 
	 */

	public Integer getOrdId() {
		return ordId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public String getCommPlan() {
		return commPlan;
	}

	public Integer getCustId() {
		return custId;
	}

	public String getShipDate() {
		return shipDate;
	}

	public Double getTotal() {
		return total;
	}
	/*
	 * The following setter methods return a handle to the current object in order to implement the fluent style
	 */
	public Ord setOrdId(Integer ordId) {
		this.ordId = ordId;
		return this;
	}

	public Ord setOrderDate(String orderDate) {
		this.orderDate = orderDate;
		return this;
	}

	public Ord setCommPlan(String commPlan) {
		this.commPlan = commPlan;
		return this;
	}

	public Ord setCustId(Integer custId) {
		this.custId = custId;
		return this;
	}

	public Ord setShipDate(String shipDate) {
		this.shipDate = shipDate;
		return this;
	}

	public Ord setTotal(Double total) {
		this.total = total;
		return this;
	}
	
	
	
	
	
	
	

}
