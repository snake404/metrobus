package com.themaster.services;


import com.themaster.dto.MainLocalitiesDTO;
import com.themaster.dto.MainMetBusDTO;

/**
 * <p>Store the methods that send the request to obtain the desired data</p>
 * @author Cristian
 * @since 1.0.0
 */
public interface SendRequest{

    /**
     * <p>Get all the metrobuses with the current location per locality or all the localities</p>
     * @param url The url to send the request
     * @return The response of the service
     */
    MainMetBusDTO getMetBusRequest(String url);

    /**
     * <p>Get all the localities with the polygon coordinates. This is not part of the main solution</p>
     * @return The response of the service
     */
    MainLocalitiesDTO getLocalities();

}
