package com.themaster.exception;


import lombok.Getter;
import lombok.Setter;

/**
 * <p>Generic class to set a custom message and error</p>
 * @author Cristian
 * @since 1.0.0
 */
@Getter
@Setter
public class RestErrorMessage{

    private String message;
    private Integer errorCode;
}
