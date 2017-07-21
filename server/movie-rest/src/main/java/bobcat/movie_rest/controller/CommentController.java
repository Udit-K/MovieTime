package bobcat.movie_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bobcat.movie_rest.entity.Comment;
import bobcat.movie_rest.service.CommentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="comment")
public class CommentController {

	@Autowired
	CommentService service;
	
	
	//Find all Comments
	@RequestMapping(method = RequestMethod.GET, path ="{id}/comments/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Comment> findAllComments(@PathVariable("id") String videoId) {
		
		
		return service.findAll(videoId);
	}
	
	//Find comment by Id
	@RequestMapping(method = RequestMethod.GET, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment findById(@PathVariable("id") String id) {
		
		return service.findById(id);
	}
	
	//Create new comment
	@RequestMapping(method = RequestMethod.POST, path = "{id}/comments/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment create(@PathVariable("id") String id, @PathVariable("userId") String userId, @RequestBody Comment com) {
		
		return service.create(id, userId, com);
	}
	
	//Update existing comment
	@RequestMapping(method = RequestMethod.PUT, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment update(@PathVariable("id") String id,@RequestBody Comment com) {
		
		return service.update(id, com);
	}
	
	//Delete Comment
	@RequestMapping(method = RequestMethod.DELETE, path="{id}")
	public void delete(@PathVariable("id") String id) {
		
		 service.delete(id);
	}
	
}
