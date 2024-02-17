package s18d4.s18d4.service;

import s18d4.s18d4.entity.Account;
import s18d4.s18d4.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAll();
    Address save(Address address);
    Address find(long id);
    Address delete(long id);
}
