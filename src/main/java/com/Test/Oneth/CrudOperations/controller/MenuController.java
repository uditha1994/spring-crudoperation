package com.Test.Oneth.CrudOperations.controller;

import com.Test.Oneth.CrudOperations.src.MenuItemRequest;
import com.Test.Oneth.CrudOperations.src.MenuItemResponse;
import com.Test.Oneth.CrudOperations.service.MenuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService service){
        this.menuService = service;
    }

    @GetMapping
    public List<MenuItemResponse> getAllItems(){
        return this.menuService.getAllItem();
    }

    @GetMapping("/{id}")
    public MenuItemResponse getById(@PathVariable int id){
        return menuService.getItemById(id);
    }

    @PostMapping
    public ResponseEntity<MenuItemResponse> addItem(
            @Valid @RequestBody MenuItemRequest request
    ){
        MenuItemResponse saved = menuService.addItem(request);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public MenuItemResponse updateItem(
            @PathVariable int id,
            @Valid @RequestBody MenuItemRequest request
    ){
        return menuService.updateItem(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable int id){
        menuService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}


