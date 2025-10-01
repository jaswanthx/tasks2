package taskmanager.com.tasks.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import taskmanager.com.tasks.model.Users;
import taskmanager.com.tasks.model.tasks;

@Repository
public interface TaskRepositoy extends JpaRepository<tasks, Long>{
	 List<tasks> findByUser(Users user); 
}
