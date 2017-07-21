package bobcat.movie_rest.repository;

import java.util.List;

import bobcat.movie_rest.entity.User;


public interface UserRepository {
	
public List<User> findAll();
	
	public User findOne(String id);
	
	public User userAuth(String email, String password);
	
	public User findByEmail(String email);
	
	public User create(User user);
	
	public User update(User user);
	
	public User delete(User user);

}
