package com.restaurantmanagementsystem.service.impl;

import com.restaurantmanagementsystem.entity.Menu;
import com.restaurantmanagementsystem.enums.EnumAvaliableStatus;
import com.restaurantmanagementsystem.exception.ExceptionConstant;
import com.restaurantmanagementsystem.exception.RestaurantException;
import com.restaurantmanagementsystem.repository.MenuRepository;
import com.restaurantmanagementsystem.request.ReqMenu;
import com.restaurantmanagementsystem.response.RespMenu;
import com.restaurantmanagementsystem.response.Response;
import com.restaurantmanagementsystem.response.ResponseStatus;
import com.restaurantmanagementsystem.response.ResponseStatusList;
import com.restaurantmanagementsystem.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuRepository menuRepository;

    @Override
    public Response<List<RespMenu>> getMenuList() {
        Response<List<RespMenu>> response = new Response<>();
        try {
            List<Menu> menuList = menuRepository.findAllByActive(EnumAvaliableStatus.ACTIVE.getValue());
            if (menuList == null) {
                throw new RestaurantException(ExceptionConstant.MENU_NOT_FOUND, "MENU NOT FOUND");
            }
            List<RespMenu> respMenus = new ArrayList<>();
            for (Menu menu : menuList) {
                RespMenu respMenu = new RespMenu();
                respMenu.setId(menu.getId());
                respMenu.setName(menu.getName());
                respMenu.setIngredient(menu.getIngredient());
                respMenu.setCatagory(menu.getCategory());
                respMenu.setPrice(menu.getPrice());
                respMenus.add(respMenu);
                response.setT(respMenus);
                response.setStatus(ResponseStatus.getSuccessMessage());
            }

        } catch (RestaurantException exx) {
            response.setStatus(new ResponseStatus(exx.getCode(), exx.getMessage()));
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }

        return response;

    }

    @Override
    public Response<List<RespMenu>> getMenuListByCategory(String category) {
        return null;
    }

    @Override
    public ResponseStatusList addMenu(ReqMenu reqMenu) {
        ResponseStatusList response = new ResponseStatusList();
        try {
            Long id = reqMenu.getId();
            String name = reqMenu.getName();
            String ingredient = reqMenu.getIngredient();
            String category = reqMenu.getCatagory();
            Integer price = reqMenu.getPrice();
            if (id == null || name == null || ingredient == null || category == null || price == null) {
                throw new RestaurantException(ExceptionConstant.INVALID_REQUEST_DATA, "INVALID REQUEST DATA");
            }
            Menu menu = new Menu();
            menu.setName(name);
            menu.setIngredient(ingredient);
            menu.setCategory(category);
            menu.setPrice(price);
            menuRepository.save(menu);
            response.setStatus(ResponseStatus.getSuccessMessage());
        } catch (RestaurantException exx) {
            response.setStatus(new ResponseStatus(exx.getCode(), exx.getMessage()));
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return response;
    }

    @Override
    public ResponseStatusList updateMenu(ReqMenu reqMenu) {
        ResponseStatusList response = new ResponseStatusList();
        try {
            Long id = reqMenu.getId();
            String name = reqMenu.getName();
            String ingredient = reqMenu.getIngredient();
            String category = reqMenu.getCatagory();
            Integer price = reqMenu.getPrice();
            if (id == null || name == null || ingredient == null || category == null || price == null) {
                throw new RestaurantException(ExceptionConstant.INVALID_REQUEST_DATA, "INVALID REQUEST DATA");
            }
            Menu menu = menuRepository.findMenuByCategoryAndActive(category, EnumAvaliableStatus.ACTIVE.getValue());
            if (menu == null) {
                throw new RestaurantException(ExceptionConstant.MENU_NOT_FOUND, "MENU NOT FOUND");
            }
            menu.setName(name);
            menu.setIngredient(ingredient);
            menu.setCategory(category);
            menu.setPrice(price);
            menuRepository.save(menu);
            response.setStatus(ResponseStatus.getSuccessMessage());
        } catch (RestaurantException exx) {
            response.setStatus(new ResponseStatus(exx.getCode(), exx.getMessage()));
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return response;
    }

    @Override
    public ResponseStatusList deleteMenu(Long menuId) {
        ResponseStatusList response = new ResponseStatusList();
        try {
            if (menuId == null) {
                throw new RestaurantException(ExceptionConstant.INVALID_REQUEST_DATA, "INVALID REQUEST DATA");
            }
            Menu menu = menuRepository.findMenuByIdAndActive(menuId, EnumAvaliableStatus.ACTIVE.getValue());
            if (menu == null) {
                throw new RestaurantException(ExceptionConstant.MENU_NOT_FOUND, "MENU NOT FOUND");
            }
            menu.setActive(EnumAvaliableStatus.DEACTIVE.getValue());
            menuRepository.save(menu);
            response.setStatus(ResponseStatus.getSuccessMessage());


        } catch (RestaurantException exx) {
            response.setStatus(new ResponseStatus(exx.getCode(), exx.getMessage()));
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));

        }
        return response;
    }
}
