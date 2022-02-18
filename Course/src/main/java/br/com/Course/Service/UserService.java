package br.com.Course.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Course.Entities.User;
import br.com.Course.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepos;

	public List<User> findall() {
		return userRepos.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = userRepos.findById(id);
		return obj.get();
	}

	public User insert(User obj) {
		return userRepos.save(obj);
	}
	
	public void delete(Long id) {
		userRepos.deleteById(id);
	}
	
	public User update(Long id, User user) {
		User entity = userRepos.getOne(id);
		updateData(entity, user);
		return userRepos.save(entity);
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
		
		
	}
}
