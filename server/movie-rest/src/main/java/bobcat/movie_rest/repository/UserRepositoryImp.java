package bobcat.movie_rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import bobcat.movie_rest.entity.User;
import bobcat.movie_rest.exception.UserNotFoundException;

@Repository
public class UserRepositoryImp implements UserRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<User> findAll() {
		
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findOne(String id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}
	
	
	@Override
	public User userAuth(String email, String password) {
		
		
		TypedQuery<User> query = em.createQuery("Select u from User u where u.emailId= :pEmail AND u.password = :pPassword", User.class);
		query.setParameter("pEmail", email);
		query.setParameter("pPassword", password);
		User user = query.getSingleResult();
		
		if(user != null ) {
			return user;
		}
		return null;
		
		
	}


	@Override
	public User findByEmail(String email) {
		
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
			query.setParameter("pEmail", email);
			List<User> users = query.getResultList();
			if(users != null && users.size() == 1) {
				return users.get(0);
			}
		
		return null;
	}

	@Override
	public User create(User user) {
		
		em.persist(user);
		
		return user;
	}

	@Override
	public User update(User user) {
		
		em.merge(user);
		return user;
	}

	@Override
	public User delete(User user) {
		em.remove(user);
		return user;
	}

	
	

}
