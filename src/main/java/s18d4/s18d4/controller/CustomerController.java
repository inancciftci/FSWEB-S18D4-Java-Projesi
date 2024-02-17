package s18d4.s18d4.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import s18d4.s18d4.dto.CustomerResponse;
import s18d4.s18d4.entity.Customer;
import s18d4.s18d4.service.CustomerService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable long id){
        return customerService.find(id);
    }

    @PostMapping
    public CustomerResponse save(@RequestBody Customer customer){
        Customer saved = customerService.save(customer);
        return new CustomerResponse(saved.getId(), saved.getEmail(), saved.getSalary());
    }
}
