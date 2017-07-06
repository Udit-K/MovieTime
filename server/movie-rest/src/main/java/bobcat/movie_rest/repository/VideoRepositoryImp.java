package bobcat.movie_rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import bobcat.movie_rest.entity.Video;

@Repository
public class VideoRepositoryImp implements VideoRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Video> findAll() {
		TypedQuery<Video> query = em.createNamedQuery("Video.findAll", Video.class);
		
		return query.getResultList();
	}

	@Override
	public Video findOne(String id) {
		
		return em.find(Video.class, id);
	}

	@Override
	public Video findByTitle(String title) {
		TypedQuery<Video> query = em.createNamedQuery("Video.findByTitle", Video.class);
		query.setParameter("pTitle", title);
		List<Video> videos = query.getResultList();
		if(videos != null && videos.size() == 1) {
			return videos.get(0);
		}
		return null;
	}

	@Override
	public Video create(Video vid) {
		em.persist(vid);
		
		return vid;
	}

	@Override
	public Video update(Video vid) {
		
		em.merge(vid);
		
		return vid;
	}

	@Override
	public Video delete(Video vid) {
		
		em.remove(vid);
		
		return vid;
	}

}
