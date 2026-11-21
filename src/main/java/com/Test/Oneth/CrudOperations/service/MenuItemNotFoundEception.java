package com.Test.Oneth.CrudOperations.service;

//Custom Exception Handling
class MenuItemNotFoundException extends RuntimeException{
    public MenuItemNotFoundException(int id){
        super("No Menu Item with this id "+id);
    }
}
