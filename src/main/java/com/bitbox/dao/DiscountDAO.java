package com.bitbox.dao;

import com.bitbox.dto.DiscountDTO;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface DiscountDAO extends CrudRepository<DiscountDTO, Long> {

}
