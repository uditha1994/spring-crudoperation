package com.Test.Oneth.CrudOperations.service;

import com.Test.Oneth.CrudOperations.repository.MenuItem;
import com.Test.Oneth.CrudOperations.repository.MenuRepository;
import com.Test.Oneth.CrudOperations.src.MenuItemRequest;
import com.Test.Oneth.CrudOperations.src.MenuItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//this class as the home for controller
//no HTTP, concerns just rules
public class MenuService {
    private final MenuRepository menuRepository;

    @Autowired
//    never call new MenuRepository(); ourselves
    public MenuService(MenuRepository repository){
        this.menuRepository = repository;
    }

    public List<MenuItemResponse> getAllItem(){
        List<MenuItemResponse> responses = new ArrayList<>();
        for(MenuItem item: menuRepository.findAll()){
            responses.add(convertResponse(item));
        }
        return responses;
    }

    public MenuItemResponse getItemById(int id){
        MenuItem item = menuRepository.findById(id)
                .orElseThrow(()-> new MenuItemNotFoundException(id));
        return convertResponse(item);
    }

    public MenuItemResponse addItem(MenuItemRequest request){
        MenuItem item = new MenuItem(
                request.getName(),
                request.getPrice(),
                request.isAvailable()
        );
        MenuItem saved = menuRepository.save(item);
        return convertResponse(saved);
    }

    public MenuItemResponse updateItem(int id, MenuItemRequest request){
        MenuItem item = menuRepository.findById(id).orElseThrow(
                ()->  new MenuItemNotFoundException(id)
        );
        item.setName(request.getName());
        item.setPrice(request.getPrice());
        item.setAvailable(request.isAvailable());
        return convertResponse(menuRepository.save(item));
    }

    public void deleteItem(int id){
        if(!menuRepository.existsById(id)){
            throw new MenuItemNotFoundException(id);
        }
        menuRepository.deleteById(id);
    }

    private MenuItemResponse convertResponse(MenuItem item){
        return new MenuItemResponse(
                item.getId(), item.getName(), item.getPrice(),
                item.isAvailable());
    }

}
