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
import com.bitbox.bitboxserver.model.Discount;
import com.bitbox.bitboxserver.model.Item;
import com.bitbox.bitboxserver.model.Supplier;
import com.bitbox.bitboxserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public List<ItemDTO> findAllItems() {
        List<ItemDTO> itemDTO = new ArrayList<>();
        for (Item item : itemDAO.findAll()) {
            itemDTO.add(itemAssembler.pojo2dto(item));
        }
        return itemDTO;
    }

    @Override
    public ItemDTO findByItemCode(int code) {
        return itemAssembler.pojo2dto(itemDAO.findByItemCode(code));
    }

    @Override
    public void createItem(ItemDTO itemDTO) {
        itemDAO.save(itemAssembler.dto2pojo(itemDTO));
    }

    @Override
    public void deleteItem(int code) {
        itemDAO.deleteByItemCode(code);
    }

    @Override
    public ResponseEntity<ItemDTO> updateItem(int code, ItemDTO itemDTO) {
        Item item = itemDAO.findByItemCode(code);
        Set<Supplier> suppliers = new HashSet<>();
        Set<Discount> discounts = new HashSet<>();

        item.setItemCode(itemDTO.getItemCode());
        item.setDescription(itemDTO.getDescription());
        item.setPrice(itemDTO.getPrice());
        item.setState(itemDTO.getState());
        item.setCreationDate(itemDTO.getCreationDate());

        for (SupplierDTO supplierDTO : itemDTO.getSuppliers()) {
            suppliers.add(supplierAssembler.dto2pojo(supplierDTO));
        }
        item.setSuppliers(suppliers);
        for (DiscountDTO discountDTO : itemDTO.getDiscounts()) {
            discounts.add(discountAssembler.dto2pojo(discountDTO));
        }
        item.setDiscounts(discounts);

        User user = userDAO.findByUserCode(itemDTO.getCreator().getUserCode());
        if (!user.equals(userAssembler.dto2pojo(itemDTO.getCreator()))) {
            user.addItem(item);
        }

        itemDAO.save(item);
        return ResponseEntity.ok().body(itemAssembler.pojo2dto(item));
    }

}
