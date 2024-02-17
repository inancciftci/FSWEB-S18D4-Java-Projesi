package s18d4.s18d4.service;

import s18d4.s18d4.entity.Account;
import s18d4.s18d4.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer save(Customer customer);
    Customer find(long id);
    Customer delete(long id);
}
