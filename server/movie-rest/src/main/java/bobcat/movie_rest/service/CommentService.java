package bobcat.movie_rest.service;

import java.util.List;

import bobcat.movie_rest.entity.Comment;

public interface CommentService {
	
	public List<Comment> findAll(String videoId);
	
	public Comment findById(String id);
	
	public Comment create(String videoId, String userId, Comment com);
	
	public Comment update(String id, Comment com);
	
	public void delete(String id);

}
