package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

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

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);


        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("What is your name?", "Tumhaara naam kya he?", R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "Mera naam hai...", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "Aap kaisa mahasoos kar rahe hain?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good.", "Main achchha mahasoos kar raha hoon.", R.raw.phrase_im_feeling_good));
        words.add(new Word("What is you age?", "Aapaki aayu kitani hai?", R.raw.phrase_are_you_coming));
        words.add(new Word("Thank you", "Dhanyavaad.", R.raw.phrase_yes_im_coming));
        words.add(new Word("We will meet again.", "Ham phir milenge.", R.raw.phrase_im_coming));
        words.add(new Word("Where do you live?", "Tum kahaan rahate ho?", R.raw.phrase_where_are_you_going));
        words.add(new Word("What happen?", "Kya hua?", R.raw.phrase_lets_go));


        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_phrases);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmAudioResourceId());
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