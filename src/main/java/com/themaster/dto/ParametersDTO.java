package com.themaster.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Store the fields of the JSON {@link MainMetBusDTO} doc for more information</p>
 * @author Cristian
 * @since 1.0.0
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParametersDTO{

    private String dataset;

    private String timezone;

    private int rows;

    private int start;

    private String[] sort;

    private String format;

    private String[] facet;

}
