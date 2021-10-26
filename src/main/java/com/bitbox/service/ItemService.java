package com.bitbox.service;

import com.bitbox.dao.ItemDAO;
import com.bitbox.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements IItemService{
    @Autowired
    ItemDAO itemDAO;

    public List<ItemDTO> findAllItems() {
        return (List<ItemDTO>)itemDAO.findAll();
    }

    @Override
    public void saveItem(ItemDTO itemDTO) {
        itemDAO.save(itemDTO);
    }

    @Override
    public ItemDTO findByItemCode(int code) {
        return itemDAO.findByItemCode(code);
    }

}
