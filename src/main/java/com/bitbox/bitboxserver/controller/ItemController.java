package com.bitbox.bitboxserver.controller;

import com.bitbox.bitboxserver.dto.ItemDTO;
import com.bitbox.bitboxserver.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    IItemService itemService;

    @GetMapping("/item/itemList")
    public List<ItemDTO> getItems(){
        return itemService.findAllItems();
    }

    @GetMapping("/item/search/{code}")
    public ItemDTO getItemByItemCode(@PathVariable(value = "code") Long code) {
        return itemService.findByItemCode(code);
    }

    @PostMapping(value = "/item/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void createItem(@RequestBody ItemDTO itemDTO){
        itemService.createItem(itemDTO);
    }

    @PutMapping("/item/update/{code}")
    public ResponseEntity<ItemDTO> updateItem(@PathVariable(value = "code") Long code,
                                              @RequestBody ItemDTO itemDTO) {
        return itemService.updateItem(code, itemDTO);
    }

    @DeleteMapping(value = "/item/delete/{code}")
    public void deleteItem(@PathVariable(value = "code") Long code) {
        itemService.deleteItem(code);
    }
}
