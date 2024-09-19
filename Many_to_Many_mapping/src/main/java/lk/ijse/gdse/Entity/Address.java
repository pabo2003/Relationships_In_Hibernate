package lk.ijse.gdse.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Address {
    @Id
    private int id;
    private String street;
    private String city;
    @ManyToMany(mappedBy = "address")
    private List<Customer> customers;

    public Address() {

    }

    public Address(int id, String street, String city, List<Customer> customers) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.customers = customers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}