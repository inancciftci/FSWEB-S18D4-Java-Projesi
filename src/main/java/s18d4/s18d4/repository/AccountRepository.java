package s18d4.s18d4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s18d4.s18d4.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
