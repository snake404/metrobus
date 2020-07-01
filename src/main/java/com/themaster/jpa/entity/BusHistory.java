package com.themaster.jpa.entity;


import com.themaster.jpa.entity.BusEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>Store all the history of the location of the buses every 5 minutes</p>
 * @author Cristian
 * @version 1.0.0
 */
@Getter
@Setter
@Entity
@Table(name = "BUS_HISTORY")
@SequenceGenerator(name = "bus_history_seq", sequenceName = "bus_history_seq", allocationSize = 1)
public class BusHistory implements Serializable{

    private static final long serialVersionUID = 3185491721000565453L;

    @Id
    @Column(name = "history_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bus_history_seq")
    private Long id;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @Column(name = "LAST_UPDATE")
    private Date lastUpdate;

    @Column(name = "LOCALITY")
    private Long locality;


    @ManyToOne
    @JoinColumn(name = "bus_id")
    private BusEntity bus;

}
