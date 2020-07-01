package com.themaster.rest.response;


import lombok.Getter;
import lombok.Setter;

/**
 * <p>Store the values to be send to the front, see {@link com.themaster.controllers.MetController#getBusHistory(Long, Integer)}</p>
 * @author Cristian
 * @since 1.0.0
 */
@Getter
@Setter
public class HistoryResponse{

    private Double latitude;
    private Double longitude;
    private Long locality;
    private Long date;

}
