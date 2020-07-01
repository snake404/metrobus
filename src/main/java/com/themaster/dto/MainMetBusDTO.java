package com.themaster.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>
 *     Main DTO to store the response of the metrobus service, you can get a JSON like the following example:
 *      {
 *     "nhits": 207,
 *     "parameters": {
 *         "dataset": "prueba_fetchdata_metrobus",
 *         "timezone": "UTC",
 *         "rows": 200,
 *         "start": 200,
 *         "sort": [
 *             "trip_schedule_relationship"
 *         ],
 *         "format": "json"
 *     },
 *     "records": [
 *         {
 *             "datasetid": "prueba_fetchdata_metrobus",
 *             "recordid": "483c289b12837deecc26df5ff10014c4d301231c",
 *             "fields": {
 *                 "vehicle_id": "1217",
 *                 "trip_start_date": "20200428",
 *                 "date_updated": "2020-06-28 01:01:17",
 *                 "position_longitude": -99.07599639892578,
 *                 "trip_schedule_relationship": 0,
 *                 "position_speed": 6,
 *                 "position_latitude": 19.384300231933594,
 *                 "trip_route_id": "301",
 *                 "vehicle_label": "2316",
 *                 "position_odometer": 478,
 *                 "trip_id": "9737443",
 *                 "vehicle_current_status": 2,
 *                 "geographic_point": [
 *                     19.384300231934,
 *                     -99.075996398926
 *                 ]
 *             },
 *             "geometry": {
 *                 "type": "Point",
 *                 "coordinates": [
 *                     -99.075996398926,
 *                     19.384300231934
 *                 ]
 *             },
 *             "record_timestamp": "2020-06-28T06:01:19.813000+00:00"
 *         }
 *      }
 * </p>
 * @author Cristian
 * @since 1.0.0
 */
@Getter
@Setter
public class MainMetBusDTO{

    private int nhits;

    private ParametersDTO parameters;

    private List<RecordsMetBusDTO> records;

}
