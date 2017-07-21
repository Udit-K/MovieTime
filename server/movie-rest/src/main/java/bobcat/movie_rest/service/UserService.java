package bobcat.movie_rest.service;

import java.util.List;

import bobcat.movie_rest.entity.User;

public interface UserService {

public List<User> findAll();
	
	public User findOne(String id);
	
	public User userAuth(String email, String password);
	
	public User create(User user);
	
	public User update(String id, User user);
	
	public void delete(String id);
}
