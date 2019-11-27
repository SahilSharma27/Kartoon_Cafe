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

    @Query("select * from carttable")
    List<Cart> getCart();

    @Query("delete from carttable")
    void deleteCart();

}
