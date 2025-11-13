package org.shehan.dao;

import org.shehan.model.Bill;
import org.shehan.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImpl implements BillDao {

    @Override
    public Product GetProduct(int id) throws Exception {
        String sql = "SELECT * FROM product WHERE id = ?";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

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



        @Override
        public void GenerateReport(Bill bill) throws Exception {
            String sql = "INSERT INTO salesreport (time, productid, product_name, quantity, cash) VALUES (?, ?, ?, ?, ?)";

            try (Connection conn = DBconnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setTimestamp(1, bill.getTime());
                ps.setInt(2, bill.getProductId());
                ps.setString(3, bill.getProductName());
                ps.setInt(4, bill.getQuantity());
                ps.setDouble(5, bill.getSubtotal());

                int rowsInserted = ps.executeUpdate();


            } catch (SQLException e) {
                throw new Exception( e.getMessage(), e);
            }

        }

    @Override
    public List<Bill> getBill() throws Exception {
        String sql = "SELECT * FROM salesreport ORDER BY time DESC";
        List<Bill> bills = new ArrayList<>();

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Bill bill = new Bill();
                bill.setTime(rs.getTimestamp("time"));
                bill.setProductId(rs.getInt("productid"));
                bill.setProductName(rs.getString("product_name"));
                bill.setQuantity(rs.getInt("quantity"));
                bill.setSubtotal(rs.getDouble("cash"));

                bills.add(bill);
            }

        } catch (SQLException e) {
            throw new Exception("Error fetching bills: " + e.getMessage(), e);
        }

        return bills;
    }
}


