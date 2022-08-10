package com.restaurantmanagementsystem.service;

import com.restaurantmanagementsystem.request.ReqMenu;
import com.restaurantmanagementsystem.response.RespMenu;
import com.restaurantmanagementsystem.response.Response;
import com.restaurantmanagementsystem.response.ResponseStatusList;

import java.util.List;

public interface MenuService {
    Response<List<RespMenu>> getMenuList();
    Response<List<RespMenu>> getMenuListByCategory(String category);
    ResponseStatusList addMenu(ReqMenu reqMenu);
    ResponseStatusList updateMenu(ReqMenu reqMenu);
    ResponseStatusList deleteMenu(Long menuId);
}
