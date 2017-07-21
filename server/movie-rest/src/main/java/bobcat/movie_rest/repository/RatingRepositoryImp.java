package bobcat.movie_rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import bobcat.movie_rest.entity.Rating;

@Repository
public class RatingRepositoryImp implements RatingRepository{

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<Rating> findAll() {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findAll", Rating.class);
		
		return query.getResultList();
	}

	@Override
	public Rating findById(String id) {
		//TypedQuery<Rating> query = em.createNamedQuery("Rating.findById", Rating.class);
		//query.setParameter("ratingId", id);
		
		return em.find(Rating.class, id);
	}

	@Override
	public Rating create(Rating rat) {
		em.persist(rat);
		return rat;
	}

	@Override
	public Rating update(Rating rat) {
		em.merge(rat);
		return rat;
	}

	@Override
	public void delete(Rating rat) {
		em.remove(rat);
		
	}

}
