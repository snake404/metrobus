package com.themaster.services.impl;


import com.themaster.dto.MainLocalitiesDTO;
import com.themaster.dto.MainMetBusDTO;
import com.themaster.services.SendRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Component
public class SendRequestImpl implements SendRequest{

    @Value("${met.localitiesUrl}")
    private String localitiesUrl;

    @Override
    public MainMetBusDTO getMetBusRequest(String url){
        RestTemplate restTemplate = new RestTemplate();
        MainMetBusDTO dto;

        //I know is a bad practice to catch runtime exceptions and then throw the same exception
        //but I need to do this to log the error with the CompletableFuture
        try{
            dto = restTemplate.getForObject(url,MainMetBusDTO.class);
        }catch(RestClientException ex){
            log.error("An error occurred while sending the request", ex);
            throw ex;
        }
        return dto;
    }

    @Override
    public MainLocalitiesDTO getLocalities(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(localitiesUrl, MainLocalitiesDTO.class);
    }
}
