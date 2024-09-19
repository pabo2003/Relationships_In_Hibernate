package lk.ijse.gdse;

import lk.ijse.gdse.config.FactoryConfiguration;
import lk.ijse.gdse.Entity.Address;
import lk.ijse.gdse.Entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Address> addresses = new ArrayList<>();

        Customer customer = new Customer();
        customer.setId(2);
        customer.setName("Namal");
        customer.setAddress(addresses);

        Address address = new Address();
        address.setId(3);
        address.setStreet("thempana road");
        address.setCity("Kurunegala");
        address.setCustomer(customer);

       /* Address address1 = new Address();
        address1.setId(2);
        address1.setStreet("kulathunga road");
        address1.setCity("Panadura");
        address1.setCustomer(customer);*/

        addresses.add(address);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        session.save(address);

        transaction.commit();
        session.close();
    }

}