package lk.ijse.gdse;

import lk.ijse.gdse.Entity.Address;
import lk.ijse.gdse.Entity.Customer;
import lk.ijse.gdse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Address> addresses = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

/*//        all data from Customer
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();
        for (Customer customer:customerList){
            System.out.println(customer.getId());
        }*/

//        unique one data form Customer
/*//        My code
        Query query = session.createQuery("from Customer where id in (1,2)");
        List<Customer> customerList = query.list();
        for (Customer customer:customerList){
            System.out.println(customer.getName());
        }*/

/*//        sirge code
        Query query = session.createQuery("from Customer where id=?1");
        query.setParameter(1,1);
        Customer customer = (Customer) query.uniqueResult();
        System.out.println(customer.getName());*/


//        load onily one column
       /* Query query = session.createQuery("from Address name");
        List<Address> addressList = query.list();
        for (Address address:addressList){
            System.out.println(address.getCity());
        }*/
        Query query = session.createQuery("name from Customer");
        List<String> namelist = query.list();
        for (String name:namelist){
            System.out.println(name);
        }

        transaction.commit();
        session.close();
    }
}