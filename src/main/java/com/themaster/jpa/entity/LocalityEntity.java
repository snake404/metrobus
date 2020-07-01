package com.themaster.jpa.entity;


import com.themaster.jpa.entity.BusEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * <p>Store the data of the 16 localities of CDMX</p>
 * @author Cristian
 * @version 1.0.0
 */
@Getter
@Setter
@Entity
@Table(name = "LOCALITY")
public class LocalityEntity implements Serializable{

    private static final long serialVersionUID = 8749921358267535003L;

    @Id
    private Long id;

    @Column(name = "NAME", length = 40)
    private String name;

    private Integer status;

    @OneToMany(mappedBy = "localityFK")
    private List<BusEntity> busEntity;

}
