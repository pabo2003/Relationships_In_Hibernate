package lk.ijse.gdse;

import lk.ijse.gdse.Entity.Address;
import lk.ijse.gdse.Entity.Customer;
import lk.ijse.gdse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Address> addresses = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Kamal");
        customer.setAddress(addresses);

        Customer customer1 = new Customer();
        customer.setId(2);
        customer.setName("Namal");
        customer.setAddress(addresses);

        Address address = new Address();
        address.setId(1);
        address.setStreet("thempana road");
        address.setCity("kurunegala");
        address.setCustomers(customers);

        Address address1 = new Address();
        address1.setId(2);
        address1.setStreet("kulathunga road");
        address1.setCity("panadura");
        address1.setCustomers(customers);

        customers.add(customer);
        customers.add(customer1);

        addresses.add(address);
        addresses.add(address1);

        session.save(customer);
        session.save(customer1);
        session.save(address);
        session.save(address1);


        transaction.commit();
        session.close();
    }
}