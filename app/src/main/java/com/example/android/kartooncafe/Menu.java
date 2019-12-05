package com.example.android.kartooncafe;

import java.util.ArrayList;

public class Menu {
    private String menuTitle;
    private String menuCategory;
    private int menuBackDrop;
    private ArrayList<Item> menuItemList;

    public Menu(String menuTitle, String menuCategory, int menuBackDrop) {
        this.menuTitle = menuTitle;
        this.menuCategory = menuCategory;
        this.menuBackDrop = menuBackDrop;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(String menuCategory) {
        this.menuCategory = menuCategory;
    }

    public int getMenuBackDrop() {
        return menuBackDrop;
    }

    public void setMenuBackDrop(int menuBackDrop) {
        this.menuBackDrop = menuBackDrop;
    }

    public ArrayList<Item> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(ArrayList<Item> menuItemList) {
        this.menuItemList = menuItemList;
    }
}
