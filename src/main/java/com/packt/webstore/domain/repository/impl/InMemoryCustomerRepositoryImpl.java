package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepositoryImpl implements CustomerRepository {

    List<Customer> listOfCustomers = new ArrayList<Customer>();

    public InMemoryCustomerRepositoryImpl() {
        Customer customer1 = new Customer("1", "Andrzej", "Nowakowski");
        customer1.setAddress("Warszawa");
        customer1.setNoOfOrdersMade(32);

        Customer customer2 = new Customer("2", "Marcin", "Biedrzycki");
        customer2.setAddress("Szczecin");
        customer2.setNoOfOrdersMade(17);

        Customer customer3 = new Customer("3", "Antoni", "Macierewicz");
        customer3.setAddress("Lublin");
        customer3.setNoOfOrdersMade(4);

        listOfCustomers.add(customer1);
        listOfCustomers.add(customer2);
        listOfCustomers.add(customer3);
    }

    public List<Customer> listOfCustomers() {
        return listOfCustomers;
    }

    public Customer getCustomerById(String customerId) {
        Customer customerById = null;

        for (Customer customer : listOfCustomers) {
            if (customer != null && customer.getCustomerId() != null && customer.getCustomerId().equals(customerId)){
                customerById = customer;
                break;
            }
        }
        if (customerById == null){
            throw new IllegalArgumentException("Brak uzytkownika o wskazanym id = "+customerId);
        }
        return customerById;
    }
}
