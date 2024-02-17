package s18d4.s18d4.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import s18d4.s18d4.dto.AccountResponse;
import s18d4.s18d4.dto.CustomerResponse;
import s18d4.s18d4.entity.Account;
import s18d4.s18d4.entity.Customer;
import s18d4.s18d4.service.AccountService;
import s18d4.s18d4.service.CustomerService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final CustomerService customerService;

    private final AccountService accountService;

    @GetMapping("/get")
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @PostMapping("/{customerId}")
    public AccountResponse save(@RequestBody Account account, @PathVariable long customerId) {
        Customer customer = customerService.find(customerId);
        customer.getAccounts().add(account);
        account.setCustomer(customer);
        Account savedAccount = accountService.save(account);
        return new AccountResponse(savedAccount.getId(), savedAccount.getAccountName(), savedAccount.getMoneyAmount(),
                new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary()));
    }

    @PutMapping("/{customerId}")
    public AccountResponse update(@RequestBody Account account, @PathVariable long customerId){
        Customer customer = customerService.find(customerId);
        Account foundAccount = null;
        for(Account acc: customer.getAccounts()) {
            if(account.getId() == acc.getId()) {
                foundAccount = acc;
            }
        }
        if(foundAccount == null) {
            throw new RuntimeException("account not found");
        }
        int indexOfFound = customer.getAccounts().indexOf(foundAccount);
        customer.getAccounts().set(indexOfFound, account);
        account.setCustomer(customer);
        accountService.save(account);
        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),
                new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary()));
    }

    @DeleteMapping("/{id}")
    public AccountResponse remove(@PathVariable long id){
        Account account = accountService.find(id);
        accountService.delete(id);
        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),
                new CustomerResponse(account.getCustomer().getId(), account.getCustomer().getEmail(), account.getCustomer().getSalary()));
    }
}
