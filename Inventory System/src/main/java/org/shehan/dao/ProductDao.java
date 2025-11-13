package org.shehan.dao;

import org.shehan.model.Customer;
import org.shehan.model.Product;

import java.util.List;

public interface ProductDao {


   Product SearchProduct(String productname) throws Exception;


   Product saveproduct(Product product) throws Exception;

   List<Product> getAllProducts() throws Exception;

   boolean updateProduct(Product product) throws Exception;

   boolean DeleteProduct(Product product) throws Exception;

   List<Product> LowStockAlert(int lowstock) throws Exception;


}
