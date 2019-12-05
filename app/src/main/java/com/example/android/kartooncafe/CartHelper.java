package com.example.android.kartooncafe;

import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class CartHelper {

    public static void addItemToCart(Context context, Cart cart) {
        CartDatabase database = Room.databaseBuilder(context, CartDatabase.class, "cart _db").
                allowMainThreadQueries().build();
        CartDao dao = database.getCartDao();
        dao.addToCart(cart);

    }

    public static void removeItemFromCart(Context context, Cart cart) {
        CartDatabase database = Room.databaseBuilder(context, CartDatabase.class, "cart _db").
                allowMainThreadQueries().build();
        CartDao dao = database.getCartDao();
        dao.removeFromCart(cart);
    }

    public static ArrayList<Cart> getItemsFromCart(Context context, String type) {
        CartDatabase database = Room.databaseBuilder(context, CartDatabase.class, "cart _db").
                allowMainThreadQueries().build();
        CartDao dao = database.getCartDao();
        List<Cart> cart1 = dao.getCart(type);
        ArrayList<Cart> cart2 = new ArrayList<>();
        cart2.addAll(cart1);
        return cart2;

    }

    public static void emptyThecart(Context context, String type) {
        CartDatabase database = Room.databaseBuilder(context, CartDatabase.class, "cart _db").
                allowMainThreadQueries().build();
        CartDao dao = database.getCartDao();
        dao.deleteCart(type);
    }

    public static void deleteCart(Context context) {
        CartDatabase database = Room.databaseBuilder(context, CartDatabase.class, "cart _db").
                allowMainThreadQueries().build();
        CartDao dao = database.getCartDao();
        dao.deleteWholeCart();
    }


    public static void updateCartItemQty(Context context, int id, int qty) {
        CartDatabase database = Room.databaseBuilder(context, CartDatabase.class, "cart _db").
                allowMainThreadQueries().build();
        CartDao dao = database.getCartDao();
        dao.updateQty(qty, id);

    }


}
