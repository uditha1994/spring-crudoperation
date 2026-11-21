package com.Test.Oneth.CrudOperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuItem, Integer> {
    List<MenuItem> findByAvailableTrue();

    List<MenuItem> findByNameContainingIgnoreCase(String name);

    List<MenuItem> findByPriceLessThanEqual(double maxPrice);
}
