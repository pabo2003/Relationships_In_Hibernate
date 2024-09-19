package lk.ijse.gdse;

import lk.ijse.gdse.Entity.Address;
import lk.ijse.gdse.Entity.Customer;
import lk.ijse.gdse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        /*Address address = new Address();
        address.setaId(1);
        address.setNo("409");
        address.setRoad("Thempana Road");
        address.setCity("Kurunegala");

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Kamal");
        customer.setAddress(address);*/

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Kamal");
        customer.setAddress("kurunegala");

        Address address = new Address();
        address.setaId(1);
        address.setNo("409");
        address.setRoad("Thempana Road");
        address.setCity("Kurunegala");
        address.setCustomer(customer);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        session.save(address);
        transaction.commit();
        session.close();
    }
}