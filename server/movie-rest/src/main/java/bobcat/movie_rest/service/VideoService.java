package bobcat.movie_rest.service;

import java.util.List;

import bobcat.movie_rest.entity.Video;

public interface VideoService {
	
	public List<Video> findAll();
	
	public Video findOne(String id);
	
	public Video create(Video vid);
	
	public Video update(String id, Video vid);
	
	public void delete(String id);

}
