package com.bitbox.controller;

import com.bitbox.dao.ItemDAO;
import com.bitbox.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ItemController {

    @Autowired
    ItemDAO itemDAO;

    @GetMapping(value = "/itemList")
    public Iterable<ItemDTO> getItems(){
        return itemDAO.findAll();
    }

    @GetMapping(value = "/item/{code}")
    public ItemDTO getItemByItemCode(@PathVariable(value = "code") int code){
        return itemDAO.findByItemCode(code);
    }

    @PostMapping("/item")
    public ItemDTO createItem(@RequestBody ItemDTO itemDTO){
        return itemDAO.save(itemDTO);
    }

    @PutMapping("/item/{code}")
    public ResponseEntity<ItemDTO> updateItem(@PathVariable(value = "code") int code,
                                              @RequestBody ItemDTO item) {

        ItemDTO itemDTO = itemDAO.findByItemCode(code);

        itemDTO.setItemCode(item.getItemCode());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setState(item.getState());
        itemDTO.setSuppliers(item.getSuppliers());
        itemDTO.setDiscounts(item.getDiscounts());
        itemDTO.setCreationDate(item.getCreationDate());
        itemDTO.setCreator(item.getCreator());

        final ItemDTO updatedItem = itemDAO.save(itemDTO);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/item/{code}")
    public ResponseEntity deleteEmployee(@PathVariable(value = "code") int code) {

        ItemDTO itemDTO = itemDAO.findByItemCode(code);
        itemDAO.delete(itemDTO);


        return ResponseEntity.ok(itemDTO);
    }
}
