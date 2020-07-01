package com.themaster.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * <p>Store the fields of the JSON {@link MainMetBusDTO} doc for more information</p>
 * @author Cristian
 * @since 1.0.0
 */
@Getter
@Setter
public class GeometryDTO{

    private String type;
    private double[] coordinates;



}
