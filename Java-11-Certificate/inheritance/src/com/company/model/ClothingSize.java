package com.company.model;

public enum ClothingSize {
    XS("Extra Small"), S("Small"), M("Medium"), L("Large"),
    XL("Extra Large"), XXL("Extra Extra Large");
    private String description;

    ClothingSize(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
