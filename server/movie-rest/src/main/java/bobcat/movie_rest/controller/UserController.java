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

import bobcat.movie_rest.entity.User;
import bobcat.movie_rest.service.UserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="users")
public class UserController {
	
	@Autowired
	UserService service;
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll() {
		
		return service.findAll();
	}
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "{id}" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findOne(@PathVariable("id") String id) {
		
		return service.findOne(id);
	}
>>>>>>> origin/module-api
	@RequestMapping(method=RequestMethod.GET, path="/{email}/{password}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User userAuth(@PathVariable("email") String email, @PathVariable("password") String password) {
		return service.userAuth(email, password);
	}
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User user) {

		
			return service.create(user);
	
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT, path = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("id") String id,@RequestBody User user) {
		
		return service.update(id, user);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") String id) {
		
		service.delete(id);
	}
	
}
