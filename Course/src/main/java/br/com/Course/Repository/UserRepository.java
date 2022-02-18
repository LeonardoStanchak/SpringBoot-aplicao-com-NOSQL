package br.com.Course.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Course.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
