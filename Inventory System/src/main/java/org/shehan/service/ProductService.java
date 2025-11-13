package org.shehan.service;

import org.shehan.dao.ProductDao;
import org.shehan.dao.ProductDAOimpl;
import org.shehan.model.Product;

import java.util.List;

public class ProductService {

    // DAO object for database operations
    private static final ProductDao productDao = new ProductDAOimpl();

    // Add new product method
    public static Product AddNewProduct(int ProductId, String ProductCategory, String ProductcName,
                                        int ProductcQuantity, double ProductcPrice, double ProductcOffer) throws Exception {

        // Basic validation
        if (ProductcName == null || ProductcName.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name is required");
        }
        if (ProductCategory == null || ProductCategory.trim().isEmpty()) {
            throw new IllegalArgumentException("Product category is required");
        }
        if (ProductcPrice <= 0) {
            throw new IllegalArgumentException("Product price must be greater than zero");
        }
        if (ProductcQuantity < 0) {
            throw new IllegalArgumentException("Product quantity cannot be negative");
        }

        // Create Product object
        Product product = new Product(ProductId, ProductCategory.trim(), ProductcName.trim(),ProductcQuantity, ProductcPrice, ProductcOffer);

        // Pass to DAO for saving
        return productDao.saveproduct(product);


    }

    public static List<Product> getAllProducts() throws Exception {
        return productDao.getAllProducts();

    }

    public static boolean updateProduct(int productId, String productCategory, String productcName, int productcQuantity, double productcPrice, double productcOffer) throws Exception {
        Product product = new Product();
        product.setProductId(productId);
        product.setProductCategory(productCategory);
        product.setProductcName(productcName);
        product.setProductcQuantity( productcQuantity);
        product.setProductcPrice(productcPrice);
        product.setProductcOffer(productcOffer);

        return productDao.updateProduct(product);
    }

    public static boolean DeleteProduct(int productId) throws Exception {

        Product product=new Product();
        product.setProductId(productId);

        return productDao.DeleteProduct(product);
    }

    public static List<Product> LowStockAlert(int lowstock) throws Exception {

        if (lowstock < 0) {
            throw new IllegalArgumentException("Product quantity cannot be negative");
        }

        return productDao.LowStockAlert(lowstock);
    }

    public static Product SearchProduct(String productname) throws Exception{
        return productDao.SearchProduct(productname);
    }


}
