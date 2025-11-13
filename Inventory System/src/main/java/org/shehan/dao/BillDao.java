package org.shehan.dao;

import org.shehan.model.Bill;
import org.shehan.model.Product;

import java.sql.Timestamp;
import java.util.List;

public interface BillDao {
     Product GetProduct(int id) throws Exception;

     void GenerateReport(Bill bill) throws Exception;

     List<Bill> getBill() throws Exception;
}
