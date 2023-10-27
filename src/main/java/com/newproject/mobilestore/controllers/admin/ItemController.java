package com.newproject.mobilestore.controllers.admin;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.newproject.mobilestore.models.admin.Item;
import com.newproject.mobilestore.services.admin.ItemService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/admin/api")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/items")
    public CollectionModel<EntityModel<Item>> getItems() {
        return itemService.getItems();
    }

    @PostMapping("/items")
    public ResponseEntity<?> saveItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    @GetMapping("/items/{itemId}")
    public EntityModel<Item> getItem(@PathVariable Long itemId) {
        return itemService.getItem(itemId);
    }

    @PutMapping("/items/{itemId}")
    public ResponseEntity<?> replaceItem(@PathVariable Long itemId, @RequestBody Item newItem) {
        return itemService.replaceItem(itemId, newItem);
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable Long itemId) {
        return itemService.deleteItem(itemId);
    }
}
