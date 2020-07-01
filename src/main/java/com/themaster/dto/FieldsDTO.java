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
public class FieldsDTO{

    @JsonProperty("vehicle_id")
    private String vehicleId;

    @JsonProperty("trip_start_date")
    private String tripStartDate;

    @JsonProperty("date_updated")
    private String dateUpdated;

    @JsonProperty("position_longitude")
    private double positionLongitude;

    @JsonProperty("trip_schedule_relationship")
    private int tripScheduleRelationship;

    @JsonProperty("position_speed")
    private int positionSpeed;

    @JsonProperty("position_latitude")
    private double positionLatitude;

    @JsonProperty("trip_route_id")
    private String tripRouteId;

    @JsonProperty("vehicle_label")
    private String vehicleLabel;

    @JsonProperty("position_odometer")
    private int positionOdometer;

    @JsonProperty("trip_id")
    private String tripId;

    @JsonProperty("vehicle_current_status")
    private int vehicleCurrentStatus;

    @JsonProperty("geographic_point")
    private double[] geographicPoint;
}
