package com.themaster.controllers;


import com.themaster.rest.response.BusResponse;
import com.themaster.services.MetBusData;
import com.themaster.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Main controller to handle all the HTTP request</p>
 * @author Cristian
 * @since 1.0.0
 */
@RestController
public class MetController{

    @Autowired
    private MetBusData metBusData;

    /**
     * <p>Get all the buses with pagination</p>
     * @param page the desired page to get the results
     * @return A json with the result of the query
     */
    @GetMapping(value = "/buses")
    public ResponseEntity getPagedBuses(@RequestParam int page){
        Map<String, Object> response = metBusData.getBuses(page);
        return ResponseEntity
                .ok(response);
    }

    /**
     * <p>Get all the buses without pagination</p>
     * @return A json with the result of the query
     */
    @GetMapping(value = "/allBuses")
    public ResponseEntity getBuses(){
        List<BusResponse> busList = metBusData.getBuses();
        Map<String, List<BusResponse>> response = new HashMap<>(1);
        response.put(Constants.DATA,busList);
        return ResponseEntity
                .ok(response);
    }

    /**
     * <p>Get all the localities registered in the database</p>
     * @return A json with the result of the query
     */
    @GetMapping(value = "/localities")
    public ResponseEntity getLocalities(){
        Map<String, Object> response = metBusData.getLocalities();
        return ResponseEntity
                .ok(response);
    }

    /**
     * <p>Get the history of every bus with the coordinates</p>
     * @param busId The desired bus id
     * @param page The desired page
     * @return A json with the result of the query
     */
    @GetMapping(value = "/busHistory")
    public ResponseEntity getBusHistory(@RequestParam Long busId, @RequestParam Integer page){
        Map<String, Object> response = metBusData.getBusHistory(busId, page);
        return ResponseEntity
                .ok(response);
    }

    /**
     * <p>Get all the buses within a locality</p>
     * @param localityId The locality to search
     * @param page The desired page
     * @return A json with the result of the query
     */
    @GetMapping(value = "/busWithinLocality")
    public ResponseEntity getHistoryByLocality(@RequestParam Long localityId, @RequestParam Integer page){
        Map<String, Object> response = metBusData.getHistoryByLocality(localityId, page);
        return ResponseEntity
                .ok(response);
    }
}
