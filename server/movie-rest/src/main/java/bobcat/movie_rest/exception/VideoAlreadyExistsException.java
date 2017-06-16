package bobcat.movie_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class VideoAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VideoAlreadyExistsException(String message){
		super(message);
	}
	
	public VideoAlreadyExistsException(String message, Throwable cause){
		super(message, cause);
	}

	
}
