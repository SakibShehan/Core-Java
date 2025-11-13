package org.shehan.dao;

import org.shehan.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOimpl implements ProductDao {



    @Override
    public Product saveproduct(Product product) throws Exception {
        String sql = "INSERT INTO product(id, name, price, quantity, offer, category) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, product.getProductId());
            ps.setString(2, product.getProductcName());
            ps.setDouble(3, product.getProductcPrice());
            ps.setInt(4, product.getProductcQuantity());
            ps.setDouble(5, product.getProductcOffer());
            ps.setString(6, product.getProductCategory());

            int rowsInserted = ps.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println(" Product inserted successfully!");
                return product; // return the same product object (with user-given ID)
            } else {
                throw new SQLException("Product insertion failed — no rows affected.");
            }

        } catch (SQLException e) {
            throw new Exception(" Error inserting product: " + e.getMessage(), e);
        }
    }
    public List<Product> getAllProducts() throws Exception {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try (Connection conn = DBconnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("id"));
                product.setProductcName(rs.getString("name"));
                product.setProductcPrice(rs.getDouble("price"));
                product.setProductcQuantity(rs.getInt("quantity"));
                product.setProductcOffer(rs.getDouble("offer"));
                product.setProductCategory(rs.getString("category"));

                products.add(product);
            }
        } catch (SQLException e) {
            throw new Exception("Error fetching products: " + e.getMessage(), e);
        }

        return products;
    }

    public boolean updateProduct(Product product) throws Exception {
        String sql = "UPDATE product SET name = ?, price = ?, quantity = ?, offer = ?, category = ? WHERE id = ?";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, product.getProductcName());
            ps.setDouble(2, product.getProductcPrice());
            ps.setInt(3, product.getProductcQuantity());
            ps.setDouble(4, product.getProductcOffer());
            ps.setString(5, product.getProductCategory());
            ps.setInt(6, product.getProductId());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            throw new Exception("Error updating product: " + e.getMessage(), e);
        }
    }
    public boolean DeleteProduct(Product product) throws Exception {
        String sql = "DELETE FROM product WHERE id = ?";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1,product.getProductId());
            int rowsDeleted = ps.executeUpdate();

            return rowsDeleted > 0; // returns true if a product was deleted

        } catch (SQLException e) {
            throw new Exception("Error deleting product: " + e.getMessage(), e);
        }
    }


    @Override
    public List<Product> LowStockAlert(int lowstock) throws Exception {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE quantity < ?"; // fixed typo

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, lowstock);
            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Product product = new Product();
                    product.setProductId(rs.getInt("id"));
                    product.setProductcName(rs.getString("name"));
                    product.setProductcQuantity(rs.getInt("quantity"));
                    product.setProductcPrice(rs.getDouble("price"));
                    product.setProductcOffer(rs.getDouble("offer"));
                    product.setProductCategory(rs.getString("category"));
                    products.add(product);
                }
            }

        } catch (SQLException e) {
            throw new Exception("Error fetching low stock products: " + e.getMessage(), e);
        }

        return products;
    }



    @Override
    public Product SearchProduct(String productname) throws Exception {
        String sql = "SELECT * FROM product WHERE name = ?";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, productname.trim());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Product product = new Product();
                    product.setProductId(rs.getInt("id"));
                    product.setProductcName(rs.getString("name"));
                    product.setProductCategory(rs.getString("category"));
                    product.setProductcQuantity(rs.getInt("quantity"));
                    product.setProductcPrice(rs.getDouble("price"));
                    product.setProductcOffer(rs.getDouble("offer"));
                    return product;
                } else {
                    return null;
                }
            }

        } catch (SQLException e) {
            throw new Exception("Error fetching product: " + e.getMessage(), e);
        }
    }





}



