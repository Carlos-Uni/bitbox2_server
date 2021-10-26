package com.bitbox.dao;

import com.bitbox.dto.SupplierDTO;
import org.springframework.data.repository.CrudRepository;

public interface SupplierDAO extends CrudRepository<SupplierDTO, Long> {

}
