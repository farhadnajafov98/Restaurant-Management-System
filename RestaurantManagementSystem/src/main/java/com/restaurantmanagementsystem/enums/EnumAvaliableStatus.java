package com.restaurantmanagementsystem.enums;

public enum EnumAvaliableStatus {
    ACTIVE(1), DEACTIVE(0);
    private int value;

    private EnumAvaliableStatus(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
