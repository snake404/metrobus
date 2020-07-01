package com.themaster.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Store the fields of the JSON {@link MainLocalitiesDTO} doc for more information</p>
 * @author Cristian
 * @since 1.0.0
 */
@Getter
@Setter
public class FieldsLocalitiesDTO{

    @JsonProperty("geo_point_2d")
    private double[] geoPoint;

    @JsonProperty("cve_mun")
    private String cveMun;

    private String cvegeo;

    private int gid;

    @JsonProperty("geo_shape")
    private GeoShapeDTO geoShape;

    @JsonProperty("cve_ent")
    private String cveEnt;

    private String nomgeo;
}
