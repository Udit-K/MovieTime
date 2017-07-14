package bobcat.movie_rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bobcat.movie_rest.entity.User;

import bobcat.movie_rest.exception.UserAlreadyExistsException;
import bobcat.movie_rest.exception.UserNotFoundException;
import bobcat.movie_rest.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	UserRepository repository;

	@Override
	public List<User> findAll() {
		
		return repository.findAll();
	}

	@Override
	public User findOne(String id) {
		User existing = repository.findOne(id);
		if(existing == null) {
			throw new UserNotFoundException("User with id: " + id + " not found");
		}
		
		return existing;
	}
	
	@Override
	public User userAuth(String email, String password) {
		
		User existing = repository.userAuth(email, password);
		
		if( existing == null) {
			throw new UserNotFoundException("User has invalid credentials ");
		}
		
		return existing;
	}

	@Override
	@Transactional
	public User create(User user) {
		
		User existing = repository.findByEmail(user.getEmailId());
		
		if(existing != null) {
			
			throw new UserAlreadyExistsException("Email already in use : " + user.getEmailId());
		}
		
		return repository.create(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		
		
		User existing = repository.findOne(id);
		
		if( existing == null) {
			throw new UserNotFoundException("User with id: " + id + " not found");
		}
		return repository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existing = repository.findOne(id);
		if(existing == null) {
			throw new  UserNotFoundException("User with id: " + id + " not found");
		}
		
		repository.delete(existing);
		
	}


}
