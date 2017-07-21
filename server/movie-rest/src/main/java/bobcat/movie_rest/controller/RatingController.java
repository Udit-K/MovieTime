package bobcat.movie_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bobcat.movie_rest.entity.Rating;
import bobcat.movie_rest.service.RatingService;

@RestController
@RequestMapping(path="rating")
public class RatingController {

	
	@Autowired 
	RatingService service;
	
	
	//Find all Comments
		@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Rating> findAll() {
			
			
			return service.findAll();
		}
		
		//Find comment by Id
		@RequestMapping(method = RequestMethod.GET, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Rating findById(@PathVariable("id") String id) {
			
			return service.findById(id);
		}
		
		//Create new comment
		@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Rating create(@RequestBody Rating rat) {
			
			return service.create(rat);
		}
		
		//Update existing comment
		@RequestMapping(method = RequestMethod.PUT, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Rating update(@PathVariable("id") String id,@RequestBody Rating rat) {
			
			return service.update(id, rat);
		}
		
		//Delete Comment
		@RequestMapping(method = RequestMethod.DELETE, path="{id}")
		public void delete(@PathVariable("id") String id) {
			
			service.delete(id);
		}
	
}
