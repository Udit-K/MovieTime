package bobcat.movie_rest.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bobcat.movie_rest.entity.Rating;
import bobcat.movie_rest.entity.User;
import bobcat.movie_rest.entity.Video;
import bobcat.movie_rest.exception.ReviewNotFoundException;
import bobcat.movie_rest.repository.RatingRepository;
import bobcat.movie_rest.repository.UserRepository;
import bobcat.movie_rest.repository.VideoRepository;

@Service
public class RatingServiceImp implements RatingService {
	
	@Autowired
	RatingRepository ratingRepository;
	
	@Autowired
	VideoRepository videoRepository;
	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public List<Rating> findAll() {
		
		return ratingRepository.findAll();
	}

	@Override
	public Rating findById(String id) {
		Rating existing = ratingRepository.findById(id);
		
		if(existing == null) {
			throw new ReviewNotFoundException("Rating for user with id: " + id + " not found");
		}
		
		
		return existing;
	}

	@Override
	public Rating create(Rating rat) {
		Video video = videoRepository.findOne(rat.getVideo().getId());
		User user = userRepository.findOne(rat.getUser().getUserId());
		
		rat.setVideo(video);
		rat.setUser(user);
		
		return ratingRepository.create(rat);
	}

	@Override
	public Rating update(String id, Rating rat) {
		Rating existing = ratingRepository.findById(id);
		
		if(existing == null) {
			throw new ReviewNotFoundException("Rating for user with id: " + id + " not found");
		}
		
		return ratingRepository.update(rat);
	}

	@Override
	public void delete(String id) {
		Rating existing = ratingRepository.findById(id);
		
		if(existing == null) {
			throw new ReviewNotFoundException("Rating for user with id: " + id + " not found");
		}
		
		ratingRepository.delete(existing);
		
	}

}
