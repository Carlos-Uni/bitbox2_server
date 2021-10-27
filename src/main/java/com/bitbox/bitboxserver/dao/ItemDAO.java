package com.bitbox.bitboxserver.dao;

import com.bitbox.bitboxserver.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAO extends CrudRepository<Item, Long> {

    public Item findByItemCode(int code);

}
