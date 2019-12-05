package com.example.android.kartooncafe;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CartDao {

    @Insert
    void addToCart(Cart cart);

    @Delete
    void removeFromCart(Cart cart);

    @Query("select * from carttable where cart_item_type= :type")
    List<Cart> getCart(String type);

    @Query("delete from carttable where cart_item_type= :type")
    void deleteCart(String type);

    @Query("delete from carttable")
    void deleteWholeCart();

    @Query("update carttable set cart_item_qty= :qty where cart_item_id= :id")
    void updateQty(int qty, int id);

}
