package com.restaurantmanagementsystem.controller;

import com.restaurantmanagementsystem.request.ReqMenu;
import com.restaurantmanagementsystem.response.RespMenu;
import com.restaurantmanagementsystem.response.Response;
import com.restaurantmanagementsystem.response.ResponseStatusList;
import com.restaurantmanagementsystem.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping(value = "/getMenuList")
    public Response<List<RespMenu>> getMenuList() {
        return menuService.getMenuList();
    }

    @GetMapping(value = "/getMenuListByCategory")
    public Response<List<RespMenu>> getMenuListByCategory(@RequestParam String category) {
        return menuService.getMenuListByCategory(category);

    }

    @PostMapping(value = "/addMenu")
    public ResponseStatusList addMenu(@RequestBody ReqMenu reqMenu) {
        return menuService.addMenu(reqMenu);
    }

    @PutMapping(value = "/updateMenu")
    public ResponseStatusList updateMenu(@RequestBody ReqMenu reqMenu) {
        return menuService.updateMenu(reqMenu);
    }

    @PutMapping(value = "/deleteMenu/{menuId}")
    public ResponseStatusList deleteMenu(@PathVariable Long menuId) {
        return menuService.deleteMenu(menuId);
    }
}
