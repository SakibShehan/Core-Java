package org.shehan.dao;

public interface CartDao {
    boolean CheckProduct(int productId, int quantity) throws Exception;
}
