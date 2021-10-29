package com.bitbox.bitboxserver.dao;

import com.bitbox.bitboxserver.model.Discount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountDAO extends CrudRepository<Discount, Long> {

    public Discount findByDiscountCode(Long code);
}
