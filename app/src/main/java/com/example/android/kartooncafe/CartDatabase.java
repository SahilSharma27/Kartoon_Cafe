package com.example.android.kartooncafe;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Cart.class}, version = 1, exportSchema = false)
public abstract class CartDatabase extends RoomDatabase {
    abstract CartDao getCartDao();
}
