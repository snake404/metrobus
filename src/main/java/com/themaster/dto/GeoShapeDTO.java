package com.themaster.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>Store the fields of the JSON {@link MainMetBusDTO} doc for more information</p>
 * @author Cristian
 * @since 1.0.0
 */
@Getter
@Setter
public class GeoShapeDTO{

    private String type;

    private List<Double[][]> coordinates;

}
