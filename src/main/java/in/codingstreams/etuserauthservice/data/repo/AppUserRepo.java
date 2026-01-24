package in.codingstreams.etuserauthservice.data.repo;

import in.codingstreams.etuserauthservice.data.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepo extends JpaRepository<AppUser, String> {

    Optional<AppUser> findByEmail(String email);

    boolean existsByEmail(String email);
}
