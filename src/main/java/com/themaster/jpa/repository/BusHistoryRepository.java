package com.themaster.jpa.repository;


import com.themaster.jpa.entity.BusHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusHistoryRepository extends CrudRepository<BusHistory, Long>{

    Page<BusHistory> findAllByLocality(Long locality, Pageable pageable);

    Page<BusHistory> findAllByBus_Id(Long busId, Pageable pageable);

}
