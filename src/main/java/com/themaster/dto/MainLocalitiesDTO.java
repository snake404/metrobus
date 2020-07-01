package com.themaster.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>
 *     Utility DTO to obtain the polygons of every CDMX locality, you can get a JSON like the following:
 *     {
 *     "nhits": 16,
 *     "parameters": {
 *         "dataset": "limite-de-las-alcaldias",
 *         "timezone": "UTC",
 *         "rows": 16,
 *         "format": "json"
 *     },
 *     "records": [
 *         {
 *             "datasetid": "limite-de-las-alcaldias",
 *             "recordid": "7bc3848c2da909dc5f3271ae4ed4fd9f76dafe2c",
 *             "fields": {
 *                 "geo_point_2d": [
 *                     19.396911897,
 *                     -99.094329797
 *                 ],
 *                 "cve_mun": "006",
 *                 "cvegeo": "09006",
 *                 "gid": 2,
 *                 "geo_shape": {
 *                     "type": "Polygon",
 *                     "coordinates": [
 *                         [
 *                             [
 *                                 -99.05583625999998,
 *                                 19.421961229999095
 *                             ],
 *                             [
 *                                 -99.05588834999998,
 *                                 19.421550489999195
 *                             ]
 *                         ]
 *                      ]
 *                 },
 *                 "cve_ent": "09",
 *                 "nomgeo": "Cuauhtémoc"
 *             },
 *             "geometry": {
 *                 "type": "Point",
 *                 "coordinates": [
 *                     -99.1490557562,
 *                     19.4313734294
 *                 ]
 *             },
 *             "record_timestamp": "2020-05-08T00:57:31.991000+00:00"
 *         }
 *     ]
 * }
 * This is not part of the solution of the main project
 * </p>
 * @author Cristian
 * @since 1.0.0
 */
@Getter
@Setter
public class MainLocalitiesDTO{

    private int nhits;

    private ParametersDTO parameters;

    private List<RecordsLocalitiesDTO> records;


}
