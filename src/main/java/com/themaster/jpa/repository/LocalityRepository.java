package com.themaster.jpa.repository;


import com.themaster.jpa.entity.LocalityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalityRepository extends CrudRepository<LocalityEntity, Long>{

    List<LocalityEntity> findAllByStatusEquals(Integer status);

}
