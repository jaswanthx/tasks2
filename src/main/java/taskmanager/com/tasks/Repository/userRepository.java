package taskmanager.com.tasks.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taskmanager.com.tasks.model.Users;

@Repository
public interface userRepository extends JpaRepository<Users, Integer>{

	Users findByUsername(String username);
}
