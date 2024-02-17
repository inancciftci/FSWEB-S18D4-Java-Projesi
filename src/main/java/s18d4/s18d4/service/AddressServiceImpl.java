package s18d4.s18d4.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import s18d4.s18d4.entity.Address;
import s18d4.s18d4.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService{
    private final AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address find(long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        return addressOptional.orElseThrow(()-> new RuntimeException("address not found"));
    }

    @Override
    public Address delete(long id) {
        Address address = find(id);
        addressRepository.delete(address);
        return address;
    }
}
