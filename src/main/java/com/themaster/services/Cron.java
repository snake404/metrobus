package com.themaster.services;


import com.themaster.dto.FieldsDTO;
import com.themaster.dto.MainMetBusDTO;
import com.themaster.jpa.entity.BusEntity;
import com.themaster.jpa.entity.BusHistory;
import com.themaster.jpa.entity.LocalityEntity;
import com.themaster.jpa.repository.BusHistoryRepository;
import com.themaster.jpa.repository.BusRepository;
import com.themaster.jpa.repository.LocalityRepository;
import com.themaster.util.Constants;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * <p>Store the methods that save the records in the database</p>
 *
 * @author Cristian
 * @since 1.0.0
 */
@Log4j2
@Service
@EnableScheduling
public class Cron{

    @Autowired
    private SendRequest sendRequest;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private BusHistoryRepository busHistoryRepository;

    @Autowired
    private LocalityRepository localityRepository;

    /**
     * <p>Save the records of the localities with metrobus every 5 minutes</p>
     */
    @Scheduled(fixedRate = 300000)
    public void initialData(){

        CompletableFuture.runAsync(() -> saveRecords(Constants.GET_VC_BUS_URL, Constants.VC_ID));
        CompletableFuture.runAsync(() -> saveRecords(Constants.GET_AO_BUS_URL, Constants.AO_ID));
        CompletableFuture.runAsync(() -> saveRecords(Constants.GET_AZ_BUS_URL, Constants.AZ_ID));
        CompletableFuture.runAsync(() -> saveRecords(Constants.GET_MH_BUS_URL, Constants.MH_ID));
        CompletableFuture.runAsync(() -> saveRecords(Constants.GET_IZ_BUS_URL, Constants.IZ_ID));
        CompletableFuture.runAsync(() -> saveRecords(Constants.GET_GAM_BUS_URL, Constants.GAM_ID));
        CompletableFuture.runAsync(() -> saveRecords(Constants.GET_IZTAC_BUS_URL, Constants.IZTAC_ID));
        CompletableFuture.runAsync(() -> saveRecords(Constants.GET_BJ_BUS_URL, Constants.BJ_ID));
        CompletableFuture.runAsync(() -> saveRecords(Constants.GET_COY_BUS_URL, Constants.COY_ID));
        CompletableFuture.runAsync(() -> saveRecords(Constants.GET_TLAL_BUS_URL, Constants.TLAL_ID));
        CompletableFuture.runAsync(() -> saveRecords(Constants.GET_CUAU_BUS_URL, Constants.CUAU_ID));
    }

    /**
     * <p>
     * Send the request and iterate over the response of the service then save the records in the corresponding
     * entities
     * </p>
     *
     * @param url The url to send the request
     * @param localityId The id oof the locality to store the records
     */
    private void saveRecords(String url, Long localityId){

        log.info("Starting records of locality id " + localityId);
        MainMetBusDTO response = sendRequest.getMetBusRequest(url);
        Optional<LocalityEntity> locality = localityRepository.findById(localityId);


        response.getRecords().forEach(x -> {
            FieldsDTO fields = x.getFields();
            Long vehicleId = Long.valueOf(fields.getVehicleId());
            Optional<BusEntity> busOptional = busRepository.findById(vehicleId);
            BusEntity busEntity = busOptional.orElse(new BusEntity());
            busEntity.setId(vehicleId);
            busEntity.setBusLabel(fields.getVehicleLabel());
            busEntity.setStatus(fields.getVehicleCurrentStatus());
            busEntity.setLocalityFK(locality.get());
            busRepository.save(busEntity);

            BusHistory history = new BusHistory();
            history.setBus(busEntity);
            history.setLastUpdate(new Date());
            history.setLatitude(fields.getGeographicPoint()[0]);
            history.setLongitude(fields.getGeographicPoint()[1]);
            history.setLocality(locality.get().getId());
            busHistoryRepository.save(history);
        });
        log.info("Ending records of locality id " + localityId);
    }
}
