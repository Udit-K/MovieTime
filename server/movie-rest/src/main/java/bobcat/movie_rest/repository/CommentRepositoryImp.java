package bobcat.movie_rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import bobcat.movie_rest.entity.Comment;



@Repository
public class CommentRepositoryImp implements CommentRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Comment> findAll(String videoId) {
		
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findComments", Comment.class);
		query.setParameter("pVideoId", videoId);
		return query.getResultList();
	}

	@Override
	public Comment findById(String id) {
		//TypedQuery<Comment> query = em.createNamedQuery("Comment.findComment", Comment.class);
		
		
		return em.find(Comment.class, id);
	}

	@Override
	public Comment create(Comment com) {
			em.persist(com);
		return com;
	}

	@Override
	public Comment update(Comment com) {
			em.merge(com);
		return com;
	}

	@Override
	public void delete(Comment com) {
		em.remove(com);
		
	}

}
