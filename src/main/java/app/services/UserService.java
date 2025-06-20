package app.services;

import java.util.List;

import app.entities.Department;
import app.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import app.entities.User;
import app.exceptions.UserAlreadyExistsException;
import app.exceptions.UserNotFoundException;
import app.exceptions.UserUpdateConflictException;
import app.interfaces.IService;
import app.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService implements IService<User> {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Override
	public User save(User entity) {
		//System.out.println(entity.getDepartment());
		
		String senhaCriptografada = bcryptEncoder.encode(entity.getPassword());
		entity.setPassword(senhaCriptografada);
		
		//this.userRepository.save(entity);		

		String tinyName = entity.getName().toLowerCase();
		entity.setName(tinyName);

		if (userRepository.existsByEmail(entity.getEmail())) {
			throw new UserAlreadyExistsException("Usuário com o email " + entity.getEmail() + " já existe.");
		}
		
		return this.userRepository.save(entity);
	}

	@Override
	public List<User> saveAll(List<User> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(String id) throws UserNotFoundException {
		return this.userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Usuário com id " + id + " não encontrado."));
	}
	
	public Page<User> findAll(int numPaginaAtual) {
		int totalPorPagina = 2;
		PageRequest pageRequest = PageRequest.of(numPaginaAtual - 1, totalPorPagina);
		return this.userRepository.findAll(pageRequest);
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
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Usuário com id " + id + " não encontrado."));

		if (!existingUser.getEmail().equals(entity.getEmail()) && userRepository.existsByEmail(entity.getEmail())) {
			throw new UserUpdateConflictException(
					"O email " + entity.getEmail() + " já está em uso por outro usuário.");
		}

		return userRepository.save(entity);
	}

	@Override
	public void delete(String id) {
		this.userRepository.findById(id).ifPresentOrElse((user) -> this.userRepository.deleteById(id),
				() -> new EntityNotFoundException());
	}

	@Override
	public void deleteAll(List<String> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	public List<User> findByNameStartingWith(String name) {
		return this.userRepository.findByNameStartingWith(name);
	}

	public List<User> findByEmailContaining(String email) {
		return this.userRepository.findByEmailContaining(email);
	}

}
