package com.themaster.services;


import com.themaster.rest.response.BusResponse;

import java.util.List;
import java.util.Map;

/**
 * <p>Store all the methods that handle the main logic of the project</p>
 *
 * @author Cristian
 * @since 1.0.0
 */
public interface MetBusData{

    /**
     * <p>Get all the buses with pagination from the database, then set the values</p>
     *
     * @param page The desired page
     *
     * @return A map with the buses and pages information
     */
    Map<String, Object> getBuses(Integer page);

    /**
     * <p>Get all the buses without pagination from the database, then set the values</p>
     *
     * @return A list with the buses data
     */
    List<BusResponse> getBuses();

    /**
     * <p>Get all the localities from the database, then set the values</p>
     *
     * @return A map with the localities
     */
    Map<String, Object> getLocalities();

    /**
     * <p>Get all the buses history with pagination from the database, then set the values</p>
     *
     * @param page The desired page
     *
     * @return A map with the bus history and pages information
     */
    Map<String, Object> getBusHistory(Long busId, Integer page);

    /**
     * <p>Get all the buses within a locality with pagination from the database, then set the values</p>
     *
     * @param page The desired page
     *
     * @return A map with the buses history and pages information
     */
    Map<String, Object> getHistoryByLocality(Long locality, Integer page);

}
