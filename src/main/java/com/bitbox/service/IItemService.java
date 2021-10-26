package com.bitbox.service;

import com.bitbox.dto.ItemDTO;

import java.util.List;

public interface IItemService {

    public List<ItemDTO> findAllItems();
    public void saveItem(ItemDTO itemDTO);
    public ItemDTO findByItemCode(int code);
}
