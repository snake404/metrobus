package com.themaster.rest.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.themaster.controllers.MetController;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Object to set the values in the getBus service see {@link MetController#getBuses()}</p>
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusResponse{

    private Long busId;

    private String busLabel;

    private Long locality;

    private Integer status;

}
