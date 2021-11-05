package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.assembler.DiscountAssembler;
import com.bitbox.bitboxserver.assembler.ItemAssembler;
import com.bitbox.bitboxserver.assembler.SupplierAssembler;
import com.bitbox.bitboxserver.assembler.UserAssembler;
import com.bitbox.bitboxserver.dao.ItemDAO;
import com.bitbox.bitboxserver.dao.UserDAO;
import com.bitbox.bitboxserver.dto.DiscountDTO;
import com.bitbox.bitboxserver.dto.ItemDTO;
import com.bitbox.bitboxserver.dto.SupplierDTO;
import com.bitbox.bitboxserver.dto.UserDTO;
import com.bitbox.bitboxserver.model.Discount;
import com.bitbox.bitboxserver.model.Item;
import com.bitbox.bitboxserver.model.Supplier;
import com.bitbox.bitboxserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class ItemService implements IItemService{

    @Autowired
    ItemDAO itemDAO;

    @Autowired
    UserDAO userDAO;

    private ItemAssembler itemAssembler = new ItemAssembler();
    private UserAssembler userAssembler = new UserAssembler();
    private SupplierAssembler supplierAssembler = new SupplierAssembler();
    private DiscountAssembler discountAssembler = new DiscountAssembler();

    public List<ItemDTO> findAllItems() {
        List<ItemDTO> itemDTO = new ArrayList<>();
        for (Item item : itemDAO.findAll()) {
            itemDTO.add(itemAssembler.pojo2dto(item));
        }
        return itemDTO;
    }

    public ItemDTO findByItemCode(Long code) {
        Optional<Item> item = itemDAO.findByItemCode(code);
        if (item.isPresent()) {
            return itemAssembler.pojo2dto(item.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("The item '%s' does not exist", code));
        }
    }

    public void createItem(ItemDTO itemDTO) {
        if (itemDTO == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The item to save is missing.");
        }
        UserDTO userDTO = itemDTO.getCreator();
        userDTO.addItem(itemDTO);
        itemDAO.save(itemAssembler.dto2pojo(itemDTO));
    }

    public void deleteItem(Long code) {
        Optional<Item> item = itemDAO.findByItemCode(code);
        if (item.isPresent()) {
            itemDAO.deleteByItemCode(code);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("The item '%s' does not exist", code));
        }

    }

    public ResponseEntity<ItemDTO> updateItem(Long code, ItemDTO itemDTO) {
        if (itemDAO.findByItemCode(code).isPresent()) {
            Item item = itemDAO.findByItemCode(code).get();
            Set<Supplier> suppliers = new HashSet<>();
            Set<Discount> discounts = new HashSet<>();

            item.setItemCode(itemDTO.getItemCode());
            item.setDescription(itemDTO.getDescription());
            item.setPrice(itemDTO.getPrice());
            item.setState(itemDTO.getState());
            item.setCreationDate(itemDTO.getCreationDate());
            item.setDiscontinuedReason(itemDTO.getDiscontinuedReason());

            for (SupplierDTO supplierDTO : itemDTO.getSuppliers()) {
                suppliers.add(supplierAssembler.dto2pojo(supplierDTO));
            }
            item.setSuppliers(suppliers);
            for (DiscountDTO discountDTO : itemDTO.getDiscounts()) {
                discounts.add(discountAssembler.dto2pojo(discountDTO));
            }
            item.setDiscounts(discounts);

            /*User user = userDAO.findByUserCode(itemDTO.getCreator().getUserCode());
            if (!user.equals(userAssembler.dto2pojo(itemDTO.getCreator()))) {
                user.addItem(item);
            }*/

            itemDAO.save(item);
            return ResponseEntity.ok().body(itemAssembler.pojo2dto(item));
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("The item '%s' does not exist", code));
        }
    }

}
