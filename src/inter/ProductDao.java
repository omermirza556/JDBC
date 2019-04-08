package inter;

import java.util.List;
import domain.*;

public interface ProductDao {

	public List<Product> getAllProducts();

	public String returnDescriptionOfProduct(Integer prodId);

	public void createProduct(Product p);

	public void updateProduct(Product p);

	public void deleteProduct(Product p);

}
