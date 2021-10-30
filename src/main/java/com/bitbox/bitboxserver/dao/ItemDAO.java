package com.bitbox.bitboxserver.dao;

import com.bitbox.bitboxserver.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemDAO extends CrudRepository<Item, Long> {

    public Optional<Item> findByItemCode(Long code);
    public void deleteByItemCode(Long code);
}
