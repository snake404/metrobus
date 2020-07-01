package com.themaster.rest.response;


import com.themaster.controllers.MetController;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Just store the values to be send to the front see {@link MetController#getBusHistory(Long, Integer)}</p>
 */
@Getter
@Setter
public class BusLocalityResponse{

    private Long busId;
    private String busLabel;

}
