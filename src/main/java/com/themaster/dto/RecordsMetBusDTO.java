package com.themaster.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Store the fields of the JSON {@link MainMetBusDTO} doc for more information</p>
 * @author Cristian
 * @since 1.0.0
 */
@Getter
@Setter
public class RecordsMetBusDTO{

    private String datasetid;
    private String recordid;
    private FieldsDTO fields;
    private GeometryDTO geometry;
    @JsonProperty("record_timestamp")
    private String recordTimestamp;

}
