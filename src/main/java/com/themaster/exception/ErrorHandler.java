package com.themaster.exception;


import com.themaster.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * <p>Handle all the custom and general exceptions of the project, send a custom error to the front</p>
 * @author Cristian
 * @since 1.0.0
 */
@ControllerAdvice
public class ErrorHandler{

    /**
     * <p>Catch all the intentionally exceptions</p>
     * @param ex The exception with the message and error code
     * @return A custom message
     */
    @ExceptionHandler(BusException.class)
    public ResponseEntity busException(BusException ex){
        RestErrorMessage message = new RestErrorMessage();
        message.setMessage(ex.getMessage());
        message.setErrorCode(ex.getErrorCode());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(message);
    }

    /**
     * <p>Catch all the exceptions not contemplated above</p>
     * @param ex The generic exception
     * @return A custom message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity generalException(Exception ex){
        RestErrorMessage message = new RestErrorMessage();
        message.setMessage(Constants.GENERIC_ERROR_MESSAGE);
        message.setErrorCode(Constants.GENERIC_ERROR_CODE);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(message);
    }
}
