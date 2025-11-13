package org.shehan.service;

import org.shehan.dao.CustomerDao;
import org.shehan.dao.CustomerDAOImpl;
import org.shehan.model.Customer;

public class CustomerService {

    private static final CustomerDao customerDao = new CustomerDAOImpl();

    public static Customer registerCustomer(String name, String email, String phone, String password) throws Exception {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Valid email is required");
        }

        Customer existing = customerDao.findByEmail(email);
        if (existing != null) {
            throw new IllegalArgumentException("Email already registered");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }

        Customer customer = new Customer(name.trim(), email.trim(), phone == null ? "" : phone.trim(), password.trim());
        return customerDao.save(customer); // ✅ এখন সঠিকভাবে customer ফেরত আসবে
    }

    public static Customer login(String email, String password) throws Exception {

        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Valid email is required");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }

        return customerDao.login(email,password);
    }
}
