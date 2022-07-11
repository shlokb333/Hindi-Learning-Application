package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        // Create array of words
//        String words[] = new String[10];
//        words = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
//
//        Log.v("NumbersActivity", "Word at 0: "+ words[0]);
//        Log.v("NumbersActivity", "Word at 1: "+ words[1]);
//        Log.v("NumbersActivity", "Word at 2: "+ words[2]);
//        Log.v("NumbersActivity", "Word at 3: "+ words[3]);
//        Log.v("NumbersActivity", "Word at 4: "+ words[4]);
//        Log.v("NumbersActivity", "Word at 5: "+ words[5]);
//        Log.v("NumbersActivity", "Word at 6: "+ words[6]);
//        Log.v("NumbersActivity", "Word at 7: "+ words[7]);
//        Log.v("NumbersActivity", "Word at 8: "+ words[8]);
//        Log.v("NumbersActivity", "Word at 9: "+ words[9]);
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("One", "Ek", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Two", "Do", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Three", "Teen", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Four", "Char", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Five", "Panch", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Six", "Che", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Seven", "Saat", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Eight", "Aanth", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Nine", "Nau", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Ten", "Das", R.drawable.number_ten, R.raw.number_ten));

//        Log.v("NumbersActivity", "Word at 0: "+ words.get(0));
//        Log.v("NumbersActivity", "Word at 1: "+ words.get(1));
//        Log.v("NumbersActivity", "Word at 2: "+ words.get(2));
//        Log.v("NumbersActivity", "Word at 3: "+ words.get(3));
//        Log.v("NumbersActivity", "Word at 4: "+ words.get(4));
//        Log.v("NumbersActivity", "Word at 5: "+ words.get(5));
//        Log.v("NumbersActivity", "Word at 6: "+ words.get(6));
//        Log.v("NumbersActivity", "Word at 7: "+ words.get(7));
//        Log.v("NumbersActivity", "Word at 8: "+ words.get(8));
//        Log.v("NumbersActivity", "Word at 9: "+ words.get(9));


//        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, words);
//
//        ListView listView = (ListView) findViewById(R.id.list);
//
//        listView.setAdapter(itemsAdapter);

        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}