package com.bitbox.bitboxserver.controller;

import com.bitbox.bitboxserver.dto.ItemDTO;
import com.bitbox.bitboxserver.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/item/itemList")
    public List<ItemDTO> getItems(){
        return itemService.findAllItems();
    }

    @GetMapping("/item/search/{code}")
    public ItemDTO getItemByItemCode(@PathVariable(value = "code") int code){
        return itemService.findByItemCode(code);
    }

    @PostMapping(value = "/item/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void createItem(@RequestBody ItemDTO itemDTO){
        itemService.createItem(itemDTO);
    }

    @PutMapping("/item/update/{code}")
    public ResponseEntity<ItemDTO> updateItem(@PathVariable(value = "code") int code,
                                              @RequestBody ItemDTO itemDTO) {
        return itemService.updateItem(code, itemDTO);
    }

    @DeleteMapping("/item/delete/{code}")
    public void deleteItem(@PathVariable(value = "code") int code) {
        itemService.deleteItem(code);
    }
}
