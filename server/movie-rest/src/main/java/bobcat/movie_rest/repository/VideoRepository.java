package bobcat.movie_rest.repository;

import java.util.List;

import bobcat.movie_rest.entity.Video;

public interface VideoRepository {

	public List<Video> findAll();
	
	public Video findOne(String id);
	
	public Video findByTitle(String title);
	
	public Video create(Video vid);
	
	public Video update(Video vid);
	
	public Video delete(Video vid);
}
