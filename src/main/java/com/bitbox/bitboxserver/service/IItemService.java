package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.dto.ItemDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IItemService {

    public List<ItemDTO> findAllItems();
    public ItemDTO findByItemCode(Long code);
    public void createItem(ItemDTO itemDTO);
    public void deleteItem(Long code);
    public ResponseEntity<ItemDTO> updateItem(Long code, ItemDTO itemDTO);

}
