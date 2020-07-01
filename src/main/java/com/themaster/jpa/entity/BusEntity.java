package com.themaster.jpa.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * <p>Store the data of the buses</p>
 * @author Cristian
 * @version 1.0.0
 */
@Getter
@Setter
@Entity
@Table(name = "BUS")
public class BusEntity implements Serializable{

    private static final long serialVersionUID = 8332746141113378335L;

    @Id
    @Column(name = "bus_id")
    private Long id;

    @Column(name = "BUS_LABEL", length = 6)
    private String busLabel;

    @Column(name = "STATUS")
    private int status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locality")
    private LocalityEntity localityFK;

    @OneToMany(mappedBy = "bus")
    private List<BusHistory> busHistory;

}
