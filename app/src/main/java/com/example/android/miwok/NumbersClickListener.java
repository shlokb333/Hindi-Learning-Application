package com.example.android.miwok;

import android.view.View;
import android.widget.Toast;

//Only use such if onClickListener has to be use many times the same way
//or else use anonymous  class object
public class NumbersClickListener implements View.OnClickListener{

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Numbers clicked", Toast.LENGTH_SHORT).show();
    }
}
