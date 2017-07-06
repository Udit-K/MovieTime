package bobcat.movie_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bobcat.movie_rest.entity.Video;
import bobcat.movie_rest.service.VideoService;

@RestController
@RequestMapping(path="videos")
public class VideoController {

	@Autowired
	VideoService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Video> findAll() {
		
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{id}" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Video findOne(@PathVariable("id") String id) {
		
		return service.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Video create(@RequestBody Video vid) {
			if (vid.getWriter().length()> 255){
				vid.setWriter("You exceed max length");
				return vid;
			}
		
			return service.create(vid);
	
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Video update(@PathVariable("id") String id,@RequestBody Video vid) {
		
		return service.update(id, vid);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") String id) {
		
		service.delete(id);
	}
}
