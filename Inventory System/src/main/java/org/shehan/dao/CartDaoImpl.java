package org.shehan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartDaoImpl implements CartDao {
    @Override
    public boolean CheckProduct(int productId, int quantity) throws Exception {
        String sql = "SELECT quantity FROM product WHERE id = ?";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, productId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int availableQuantity = rs.getInt("quantity");


                    if (availableQuantity >= quantity) {
                        return true;
                    } else {

                        return false;
                    }
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error checking product availability: " + e.getMessage(), e);
        }
    }
}
