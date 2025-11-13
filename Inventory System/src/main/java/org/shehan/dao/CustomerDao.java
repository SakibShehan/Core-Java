package org.shehan.dao;

import org.shehan.model.Customer;

public interface CustomerDao {
    Customer save(Customer customer) throws Exception;

    Customer findByEmail(String email) throws Exception;

    Customer login(String email, String password) throws Exception;
}
