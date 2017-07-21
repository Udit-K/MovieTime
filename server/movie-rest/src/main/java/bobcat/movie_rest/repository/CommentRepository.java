package bobcat.movie_rest.repository;

import java.util.List;

import bobcat.movie_rest.entity.Comment;

public interface CommentRepository {

	
public List<Comment> findAll(String videoId);
	
	public Comment findById(String id);
	
	public Comment create(Comment com);
	
	public Comment update(Comment com);
	
	public void delete(Comment com);
}
