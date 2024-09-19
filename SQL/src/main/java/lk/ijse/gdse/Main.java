package lk.ijse.gdse;

import lk.ijse.gdse.Entity.Address;
import lk.ijse.gdse.Entity.Customer;
import lk.ijse.gdse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Address> addresses = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery query = session.createNativeQuery("select * from Customer");
        query.addEntity(Customer.class);
        List<Customer> customerList = query.list();
        for (Customer customer:customerList){
            System.out.println(customer);
        }


        transaction.commit();
        session.close();
    }
}