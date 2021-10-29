package com.bitbox.bitboxserver.dao;

import com.bitbox.bitboxserver.model.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDAO extends CrudRepository<Supplier, Long> {
    public Supplier findBySupplierCode(Long code);
}
