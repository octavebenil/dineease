package com.sbosoft.dineease.tables.repository;

import com.sbosoft.dineease.tables.entity.Table;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends ReactiveCrudRepository<Table, Long> {
}
