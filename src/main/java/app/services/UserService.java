package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.User;
import app.interfaces.IService;
import app.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService implements IService<User>{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User entity) {
		return this.userRepository.save(entity);
	}

	@Override
	public List<User> saveAll(List<User> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(String id) throws EntityNotFoundException{
		return this.userRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public List<User> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User update(String id, User entity) {
		this.userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		
		return userRepository.save(entity);
	}

	@Override
	public void delete(String id) {
		this.userRepository.findById(id)
			.ifPresentOrElse(
					(user) -> this.userRepository.deleteById(id), 
					() -> new EntityNotFoundException()
			);
	}

	@Override
	public void deleteAll(List<String> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
