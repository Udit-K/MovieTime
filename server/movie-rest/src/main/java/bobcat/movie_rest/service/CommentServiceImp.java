package bobcat.movie_rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bobcat.movie_rest.entity.Comment;
import bobcat.movie_rest.entity.User;
import bobcat.movie_rest.entity.Video;
import bobcat.movie_rest.exception.ReviewNotFoundException;
import bobcat.movie_rest.repository.CommentRepository;
import bobcat.movie_rest.repository.UserRepository;
import bobcat.movie_rest.repository.VideoRepository;

@Service
public class CommentServiceImp implements CommentService{
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	VideoRepository videoRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	

	@Override
	public List<Comment> findAll(String videoId) {
		
		return commentRepository.findAll(videoId);
	}

	
	
	@Override
	public Comment findById(String id) {
		
		Comment existing = commentRepository.findById(id);
		
		if(existing == null) {
			throw new ReviewNotFoundException("Comment not found: " + id);
		}
		
		
		return existing;
	}

	
	
	@Override
	@Transactional
	public Comment create(String videoId, String userId,Comment com) {

		Video video = videoRepository.findOne(videoId);
		User user = userRepository.findOne(userId);
		
		com.setVideo(video);
		com.setUser(user);
		
		return commentRepository.create(com);
	}
	
	

	@Override
	@Transactional
	public Comment update(String id, Comment com) {
		Comment existing = commentRepository.findById(id);
		
		if(existing == null) {
			throw new ReviewNotFoundException("Comment with user id: "+  id + " doesn't exist: ");
		}
		
		
		return commentRepository.update(com);
	}
	
	
	

	@Override
	@Transactional
	public void delete(String id) {
		Comment existing = commentRepository.findById(id);
		
		if(existing == null) {
			throw new ReviewNotFoundException("Comment with user id: "+  id + " doesn't exist: ");
		}
		
		commentRepository.delete(existing);
	}

}
