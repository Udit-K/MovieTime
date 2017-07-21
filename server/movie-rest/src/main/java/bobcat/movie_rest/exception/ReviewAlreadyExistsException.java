package bobcat.movie_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class ReviewAlreadyExistsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ReviewAlreadyExistsException(String message){
		super(message);
	}
	
	public ReviewAlreadyExistsException(String message, Throwable cause){
		super(message, cause);
	}

}
