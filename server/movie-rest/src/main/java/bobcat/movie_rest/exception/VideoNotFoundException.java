package bobcat.movie_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class VideoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VideoNotFoundException(String message) {
		super(message);
	}
	
	public VideoNotFoundException(String message, Throwable cause){
		super(message, cause);
	}
}
