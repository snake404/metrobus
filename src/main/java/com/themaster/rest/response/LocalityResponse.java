package com.themaster.rest.response;


import com.themaster.controllers.MetController;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Store the values to be send to the front, see {@link MetController#getLocalities()}</p>
 * @author Cristian
 * @since 1.0.0
 */
@Getter
@Setter
public class LocalityResponse{

    private String name;
    private Long id;

}
