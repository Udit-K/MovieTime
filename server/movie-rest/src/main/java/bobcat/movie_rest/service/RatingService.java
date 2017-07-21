package bobcat.movie_rest.service;

import java.util.List;


import bobcat.movie_rest.entity.Rating;

public interface RatingService {
	
public List<Rating> findAll();
	
	public Rating findById(String id);
	
	public Rating create(Rating rat);
	
	public Rating update(String id, Rating rat);
	
	public void delete(String id);

}
