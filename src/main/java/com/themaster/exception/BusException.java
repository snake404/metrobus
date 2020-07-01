package com.themaster.exception;


import lombok.Getter;
import lombok.Setter;

/**
 * <p>General exception of the project</p>
 * @author Cristian
 * @since 1.0.0
 */
@Getter
@Setter
public class BusException extends RuntimeException{

    private String message;
    private Integer errorCode;

    public BusException(String message){
        super(message);
    }

    public BusException(String message, Throwable e){
        super(message, e);
    }

    public BusException(String message, Integer errorCode){
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }

}
