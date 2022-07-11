package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

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
        words.add(new Word("Father", "Pita", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("Mother", "Mata", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("Son", "Beta", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("Elder Brother", "Bhaiyya", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("Elder Sister", "Didi", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("Younger Brother", "Bhai", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("Younger Sister", "Behan", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("Grandfather", "Dada", R.drawable.family_grandfather, R.raw.family_grandfather));
        words.add(new Word("Grandmother", "Dadi", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("Uncle", "Chaha", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("Aunty", "Chahi", R.drawable.family_mother, R.raw.family_mother));


        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_family);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getmAudioResourceId());
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