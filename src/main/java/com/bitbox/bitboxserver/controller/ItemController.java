package com.bitbox.bitboxserver.controller;

import com.bitbox.bitboxserver.dto.ItemDTO;
import com.bitbox.bitboxserver.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    IItemService iItemService;

    @GetMapping("/itemList")
    public Iterable<ItemDTO> getItems(){
        return iItemService.findAllItems();
    }

    @GetMapping("/search/{code}")
    public ItemDTO getItemByItemCode(@PathVariable(value = "code") int code){
        return iItemService.findByItemCode(code);
    }

    @PostMapping(name = "/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO){
        iItemService.createItem(itemDTO);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/update/{code}")
    public ResponseEntity<?> updateItem(@PathVariable(value = "code") int code,
                                              @RequestBody ItemDTO itemDTO) {
        iItemService.updateItem(itemDTO.getItemCode(), itemDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "code") int code) {
        iItemService.deleteItem(code);
        return new ResponseEntity(HttpStatus.OK);
    }
}
