package s18d4.s18d4.service;

import s18d4.s18d4.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account save(Account account);
    Account find(long id);
    Account delete(long id);
}
