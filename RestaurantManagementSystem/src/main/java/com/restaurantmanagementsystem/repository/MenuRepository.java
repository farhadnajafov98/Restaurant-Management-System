package com.restaurantmanagementsystem.repository;

import com.restaurantmanagementsystem.entity.Employee;
import com.restaurantmanagementsystem.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findAllByActive(Integer active);

    Menu findMenuByCategoryAndActive(String category, Integer active);

    Menu findMenuByIdAndActive(Long id, Integer active);
}
