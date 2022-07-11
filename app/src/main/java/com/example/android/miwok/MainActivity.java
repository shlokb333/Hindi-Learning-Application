/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // ************* Without using inline OnClickListener
//        NumbersClickListener clickListener = new NumbersClickListener();
//        TextView numbers = (TextView) findViewById(R.id.numbers);
//        numbers.setOnClickListener(clickListener);

        // ************* Directly using class object
//        1. Find the view that will be clicked
        TextView numberTextView = findViewById(R.id.numbers);
//        2. setOnClickListener on that view
        numberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(intent);
            }
        });

        TextView familyTextView = findViewById(R.id.family);
        familyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(intent);
            }
        });

        TextView colorsTextView = findViewById(R.id.colors);
        colorsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(intent);
            }
        });

        TextView phrasesTextView = findViewById(R.id.phrases);
        phrasesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(intent);
            }
        });
    }

//    // Find the View that shows the numbers category
//        TextView numbers = (TextView) findViewById(R.id.numbers);
//
//   //  Set a click listener on that View
//        numbers.setOnClickListener(new View.OnClickListener()
//    {
//        // The code in this method will be executed when the numbers View is clicked on.
//        @Override
//        public void onClick (View view){
//        Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
//        startActivity(numbersIntent);
//    }
//    });


//    public void startNumbersActivity(View view) {
//        Intent i = new Intent(this, NumbersActivity.class);
//        startActivity(i);
//    }
//
//    public void startFamilyActivity(View view) {
//        Intent i = new Intent(this, FamilyActivity.class);
//        startActivity(i);
//    }
//
//    public void startColorsActivity(View view) {
//        Intent i = new Intent(this, ColorsActivity.class);
//        startActivity(i);
//    }
//
//    public void startPhrasesActivity(View view) {
//        Intent i = new Intent(this, PhrasesActivity.class);
//        startActivity(i);
//    }
}
