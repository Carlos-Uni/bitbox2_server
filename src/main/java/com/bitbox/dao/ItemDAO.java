package com.bitbox.dao;

import com.bitbox.dto.ItemDTO;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ItemDAO extends CrudRepository<ItemDTO, Long> {

    public ItemDTO findByItemCode(int code);

}
