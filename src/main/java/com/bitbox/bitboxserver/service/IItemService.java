package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.dto.ItemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IItemService {

    public List<ItemDTO> findAllItems();
    public ItemDTO findByItemCode(int code);
    public void createItem(ItemDTO itemDTO);
    public void deleteItem(int code);
    public ResponseEntity<ItemDTO> updateItem(int code, ItemDTO itemDTO);

}
