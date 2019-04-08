package domain;
/**
 * 
 * @author omer
 *
 *This is an object representation of the item table in our database
 */
public class Item {
	
	@Override
	public String toString() {
		return "Item [ordId=" + ordId + ", itemId=" + itemId + ", prodId=" + prodId + ", actualPrice=" + actualPrice
				+ ", qty=" + qty + ", itemTotal=" + itemTotal + "]";
	}

	private Integer ordId;
	private Integer itemId;
	private Integer prodId;
	private Double actualPrice;
	private Integer qty;
	private Double itemTotal;
	
	public Item() {
		
	}

	public Item(Integer ordId, Integer itemId, Integer prodId, Double actualPrice, Integer qty, Double itemTotal) {
		super();
		this.ordId = ordId;
		this.itemId = itemId;
		this.prodId = prodId;
		this.actualPrice = actualPrice;
		this.qty = qty;
		this.itemTotal = itemTotal;
	}
	/*
	 * These are the getter methods for the Item Object 
	 */
	
	public Integer getOrdId() {
		return ordId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public Integer getProdId() {
		return prodId;
	}

	public Double getActualPrice() {
		return actualPrice;
	}

	public Integer getQty() {
		return qty;
	}

	public Double getItemTotal() {
		return itemTotal;
	}
	/*
	 * The following setter methods return a handle to the current object in order to implement the fluent style
	 */

	public Item setOrdId(Integer ordId) {
		this.ordId = ordId;
		return this;
	}

	public Item setItemId(Integer itemId) {
		this.itemId = itemId;
		return this;
	}

	public Item setProdId(Integer prodId) {
		this.prodId = prodId;
		return this;
	}

	public Item setActualPrice(Double actualPrice) {
		this.actualPrice = actualPrice;
		return this;
	}

	public Item setQty(Integer qty) {
		this.qty = qty;
		return this;
	}

	public Item setItemTotal(Double itemTotal) {
		this.itemTotal = itemTotal;
		return this;
	}
	
	

}
