package taskmanager.com.tasks.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import taskmanager.com.tasks.Repository.userRepository;
import taskmanager.com.tasks.model.Users;

@Service
public class Userservice {
	
	@Autowired
	public userRepository userrepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void add(Users user) {
		// Encode password before saving
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userrepo.save(user);
	}
	
	public boolean validateUser(String username, String password) {
	     Users user = userrepo.findByUsername(username);
	     return user != null && passwordEncoder.matches(password, user.getPassword());
	 }

}
