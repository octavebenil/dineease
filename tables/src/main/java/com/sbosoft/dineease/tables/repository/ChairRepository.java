package com.sbosoft.dineease.tables.repository;

import com.sbosoft.dineease.tables.entity.Chair;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChairRepository extends ReactiveCrudRepository<Chair, Long> {
}
