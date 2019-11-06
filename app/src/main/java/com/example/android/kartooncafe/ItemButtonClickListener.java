package com.example.android.kartooncafe;

import android.view.View;

public interface ItemButtonClickListener {
    void onAddToCart( View view,int position);
    void onCustomize(View view,int position);
}
