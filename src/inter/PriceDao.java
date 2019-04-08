package inter;

import java.util.List;
import domain.*;

public interface PriceDao {
	public List<Price> returnListOfPrices();

	public Double returnMinimumPriceAfterDate(Integer prodId, String startDate);

	public Double returnStdPriceAfterDate(Integer prodId, String startDate);

	public Double returnMinimumPriceBeforeDate(Integer prodId, String endDate);

	public Double returnStdPriceBeforeDate(Integer prodId, String endDate);
	
	public void updatePrice(Price p);
	public void deletePrice(Price p);
	public void createPrice(Price p);
	

}
