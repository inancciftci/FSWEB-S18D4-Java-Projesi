package s18d4.s18d4.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import s18d4.s18d4.entity.Customer;
import s18d4.s18d4.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer find(long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerOptional.orElseThrow(()-> new RuntimeException("customer not found"));
    }

    @Override
    public Customer delete(long id) {
        Customer customer = find(id);
        customerRepository.delete(customer);
        return customer;
    }
}
