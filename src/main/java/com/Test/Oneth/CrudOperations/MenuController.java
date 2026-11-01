package com.Test.Oneth.CrudOperations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/menu")
public class MenuController {
    private ArrayList<MenuLIst> menu = new ArrayList<>();

//counter uniue id for menu items
    private int nextId = 1;

    public MenuController(){
        menu.add(new MenuLIst(nextId++,"Milk Chocolate",200.0,true));
        menu.add(new MenuLIst(nextId++,"Fired Chicken",2700.0,true));
        menu.add(new MenuLIst(nextId++,"Cheese Pasta",1200.0,false));
        menu.add(new MenuLIst(nextId++,"Green Beans",900.0,true));
    }

    @GetMapping
    public ArrayList<MenuLIst> getAllMenus(){
        return menu;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuLIst> getItemById(@PathVariable int id){
        for(MenuLIst item:menu){
            if(item.getId() == id){
                return ResponseEntity.ok(item);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/addItem")
    public ResponseEntity<MenuLIst> addItem(@RequestBody MenuLIst newItem){
        newItem.setId(nextId++);
        menu.add(newItem);

        return ResponseEntity.ok(newItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuLIst> updateItem(
            @PathVariable  int id,
            @RequestBody MenuLIst updatedItem
            ){

        for(MenuLIst item: menu){
            if(item.getId() == id){
                //item found
                item.setName(updatedItem.getName());
                item.setPrice(updatedItem.getPrice());
                item.setAvailable(updatedItem.isAvailable());

                return ResponseEntity.ok(item);
            }
        }
        return ResponseEntity.notFound().build();
    }

}


