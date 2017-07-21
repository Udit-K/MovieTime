package bobcat.movie_rest.repository;

import java.util.List;

import bobcat.movie_rest.entity.Rating;

public interface RatingRepository {

public List<Rating> findAll();
	
	public Rating findById(String id);
	
	
	public Rating create(Rating rat);
	
	public Rating update(Rating rat);
	
	public void delete(Rating rat);

}
