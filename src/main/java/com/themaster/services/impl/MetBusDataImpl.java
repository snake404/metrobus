package com.themaster.services.impl;


import com.themaster.jpa.entity.BusEntity;
import com.themaster.jpa.entity.BusHistory;
import com.themaster.jpa.entity.LocalityEntity;
import com.themaster.exception.BusException;
import com.themaster.jpa.repository.BusHistoryRepository;
import com.themaster.jpa.repository.BusRepository;
import com.themaster.jpa.repository.LocalityRepository;
import com.themaster.rest.response.BusLocalityResponse;
import com.themaster.rest.response.BusResponse;
import com.themaster.rest.response.HistoryResponse;
import com.themaster.rest.response.LocalityResponse;
import com.themaster.services.MetBusData;
import com.themaster.util.Constants;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Log4j2
@Service
public class MetBusDataImpl implements MetBusData{

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private LocalityRepository localityRepository;

    @Autowired
    private BusHistoryRepository historyRepository;

    @Override
    public Map<String, Object> getBuses(Integer page){
        log.info("Starting getBuses with pagination");
        Pageable pageable = PageRequest.of(page, 20);
        Page<BusEntity> busPage = busRepository.findAll(pageable);

        validatePage(page, busPage.getTotalPages());

        List<BusResponse> busList = addBuses(busPage.getContent());
        Map<String, Object> response = new LinkedHashMap<>();
        response.put(Constants.TOTAL_ELEMENTS, busPage.getTotalElements());
        response.put(Constants.TOTAL_PAGES, busPage.getTotalPages());
        response.put(Constants.CURRENT_PAGE, busPage.getNumber());
        response.put(Constants.DATA, busList);

        log.info("Finished getBuses with pagination");
        return response;
    }

    @Override
    public List<BusResponse> getBuses(){
        log.info("Starting getBuses without pagination");
        List<BusEntity> entityList = busRepository.findAll();
        List<BusResponse> response = addBuses(entityList);
        log.info("finished getBuses without pagination");
        return response;
    }

    /**
     * <p>Common method to add the bus data with and without pagination</p>
     * @param sourceList The list with the bus data
     * @return A list with the objects to be send to the front
     */
    private List<BusResponse> addBuses(List<BusEntity> sourceList){

        List<BusResponse> destList = new LinkedList<>();
        sourceList.forEach(bus -> {
            BusResponse response = new BusResponse();
            response.setBusId(bus.getId());
            response.setBusLabel(bus.getBusLabel());
            response.setLocality(bus.getLocalityFK().getId());
            response.setStatus(bus.getStatus());
            destList.add(response);
        });
        return destList;
    }

    @Override
    public Map<String, Object> getLocalities(){
        log.info("Starting localities");
        List<LocalityEntity> localityList = localityRepository.findAllByStatusEquals(1);
        List<LocalityResponse> responseList = new LinkedList<>();
        localityList.forEach(locality -> {
            LocalityResponse tmp = new LocalityResponse();
            tmp.setId(locality.getId());
            tmp.setName(locality.getName());
            responseList.add(tmp);
        });
        Map<String, Object> response = new HashMap<>(1);
        response.put(Constants.DATA,responseList);
        log.info("Finished localities");
        return response;
    }

    @Override
    public Map<String, Object> getBusHistory(Long busId, Integer page){
        log.info("Starting getbusHistory");

        if(!busRepository.existsById(busId)){
            String message = String.format(Constants.NOT_FOUND_MESSAGE, "BusId");
            log.error(message);
            throw new BusException(message, Constants.NOT_FOUND_CODE);
        }

        Pageable pageable = PageRequest.of(page, 50);
        Page<BusHistory> busHistories = historyRepository.findAllByBus_Id(busId, pageable);

        validatePage(page, busHistories.getTotalPages());

        List<BusHistory> historyList = busHistories.getContent();
        List<HistoryResponse> listResponse = new LinkedList<>();

        historyList.forEach(history -> {
            HistoryResponse tmp = new HistoryResponse();
            tmp.setLatitude(history.getLatitude());
            tmp.setLongitude(history.getLongitude());
            tmp.setLocality(history.getLocality());
            tmp.setDate(history.getLastUpdate().getTime());

            listResponse.add(tmp);
        });

        Map<String, Object> response = new LinkedHashMap<>();
        BusHistory currentHistory = historyList.get(historyList.size() - 1);
        response.put(Constants.BUS_ID, busId);
        response.put(Constants.CURRENT_LATITUDE, currentHistory.getLatitude());
        response.put(Constants.CURRENT_LONGITUDE, currentHistory.getLongitude());
        response.put(Constants.CURRENT_LOCALITY,currentHistory.getLocality());
        response.put(Constants.CURRENT_PAGE, page);
        response.put(Constants.TOTAL_PAGES, busHistories.getTotalPages());
        response.put(Constants.TOTAL_ELEMENTS, busHistories.getTotalElements());
        response.put(Constants.DATA, listResponse);

        log.info("Finished getbusHistory");
        return response;
    }

    @Override
    public Map<String, Object> getHistoryByLocality(Long locality, Integer page){
        log.info("Starting getHistoryByLocality");
        Pageable pageable = PageRequest.of(page, 50);
        Optional<LocalityEntity> localityOptional = localityRepository.findById(locality);

        LocalityEntity localityEntity = localityOptional.<BusException>orElseThrow(() ->{
            String message = String.format(Constants.NOT_FOUND_MESSAGE,"Locality");
            log.error(message);
            throw new BusException(message, Constants.NOT_FOUND_CODE);
        });


        if(!localityEntity.getStatus().equals(Constants.ACTIVE_LOCALITY)){
            String message = String.format(Constants.NOT_VALID_MESSAGE,"Locality");
            log.error(message);
            throw new BusException(message, Constants.NOT_VALID_ERROR);
        }

        Page<BusHistory> busHistories = historyRepository.findAllByLocality(locality,pageable);

        validatePage(page, busHistories.getTotalPages());

        List<BusHistory> historyList = busHistories.getContent();
        List<BusLocalityResponse> listResponse = new LinkedList<>();

        historyList.forEach(history -> {
            BusLocalityResponse tmp = new BusLocalityResponse();
            BusEntity busEntity = history.getBus();
            tmp.setBusId(busEntity.getId());
            tmp.setBusLabel(busEntity.getBusLabel());

            listResponse.add(tmp);
        });

        BusHistory currentBus = historyList.get(0);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put(Constants.CURRENT_LOCALITY, currentBus.getLocality());
        response.put(Constants.LOCALITY_NAME, currentBus.getBus().getLocalityFK().getName());
        response.put(Constants.CURRENT_PAGE, page);
        response.put(Constants.TOTAL_PAGES, busHistories.getTotalPages());
        response.put(Constants.TOTAL_ELEMENTS, busHistories.getTotalElements());
        response.put(Constants.DATA, listResponse);
        log.info("Ending getHistoryByLocality");
        return response;
    }

    /**
     * <p>Validate if the current page is in the range</p>
     * @param page The page to be validated
     * @param totalPages The total pages of the elements
     */
    private void validatePage(Integer page, Integer totalPages){
        if(page > totalPages - 1){
            String message = String.format(Constants.NOT_VALID_MESSAGE,"Page");
            log.error(message);
            throw new BusException(message, Constants.NOT_VALID_ERROR);
        }
    }
}
