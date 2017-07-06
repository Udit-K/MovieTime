package bobcat.movie_rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bobcat.movie_rest.entity.Video;
import bobcat.movie_rest.exception.VideoAlreadyExistsException;
import bobcat.movie_rest.exception.VideoNotFoundException;
import bobcat.movie_rest.repository.VideoRepository;

@Service
public class VideoServiceImp implements VideoService{
	
	@Autowired
	VideoRepository repository;

	@Override
	public List<Video> findAll() {
		
		
		return repository.findAll();
	}

	@Override
	public Video findOne(String id) {
		Video existing = repository.findOne(id);
		if(existing == null) {
			throw new VideoNotFoundException("Video with id: " + id + " not found");
		}
		
		return existing;
	}

	@Override
	@Transactional
	public Video create(Video vid) {
		Video existing = repository.findByTitle(vid.getTitle());
		
		if(existing != null) {
			
			throw new VideoAlreadyExistsException("Title already in use : " + vid.getTitle());
		}
		
		return repository.create(vid);
	}

	@Override
	@Transactional
	public Video update(String id, Video vid) {
			
			Video existing = repository.findOne(id);
			
			if( existing == null) {
				throw new VideoNotFoundException("Video with id: " + id + " not found");
			}
 		return repository.update(vid);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Video existing = repository.findOne(id);
		if(existing == null) {
			throw new  VideoNotFoundException("Video with id: " + id + " not found");
		}
		
		repository.delete(existing);
	}

	
}
