package org.shehan.dao;

import org.shehan.model.Customer;
import java.sql.*;

public class CustomerDAOImpl implements CustomerDao {

    @Override
    public Customer save(Customer customer) throws Exception {
        String sql = "INSERT INTO customer(name, email, phone, password) VALUES (?, ?, ?, ?) RETURNING id";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getPassword()); // <-- এটা আগের কোডে ভুল ছিল (তুমি ৩ দুইবার লিখেছো)

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int generatedId = rs.getInt("id");
                    customer.setId(generatedId);
                    return customer; // ✅ customer object return করবে
                } else {
                    throw new SQLException("Failed to insert customer, no ID returned.");
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Customer findByEmail(String email) throws Exception {
        String sql = "SELECT * FROM customer WHERE email = ?";
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getInt("id"));
                    customer.setName(rs.getString("name"));
                    customer.setEmail(rs.getString("email"));
                    customer.setPhone(rs.getString("phone"));
                    customer.setPassword(rs.getString("password"));
                    return customer;
                }
            }
        }
        return null;
    }

    @Override
    public Customer login(String email, String password) throws Exception {
        String sql = "SELECT * FROM customer WHERE email = ? AND password = ?";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getInt("id"));
                    customer.setName(rs.getString("name"));
                    customer.setEmail(rs.getString("email"));
                    customer.setPhone(rs.getString("phone"));
                    customer.setPassword(rs.getString("password"));
                    return customer;
                } else {
                    return null;
                }


            }
        }
    }
}
