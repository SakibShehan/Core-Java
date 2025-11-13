package org.shehan.service;

import org.shehan.dao.BillDao;
import org.shehan.dao.BillDaoImpl;
import org.shehan.model.Bill;
import org.shehan.model.Product;

import java.sql.Timestamp;
import java.util.List;

public class BillService {

    private static final BillDao billDao = new BillDaoImpl();

    public static Product GetProduct(int id) throws Exception {
        return billDao.GetProduct(id);
    }

    public static void GenerateReport(Timestamp time, int id, String name, int quantity, double subtotal) throws Exception {


        Bill bill= new Bill(time, id, name, quantity, subtotal);

        billDao.GenerateReport(bill);
    }

    public static List<Bill> getBill() throws Exception {

        return billDao.getBill();
    }
}
