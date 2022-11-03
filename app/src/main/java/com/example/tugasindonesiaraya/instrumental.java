package com.example.tugasindonesiaraya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Toast;
public class instrumental extends AppCompatActivity {
    MediaPlayer player;
    //menyambungkan
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrumental);
    }
    //fungsi play
    public void play(View v) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.song2);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }
    //fungsi pause
    public void pause(View v) {
        if (player != null) {
            player.pause();
        }
    }

    //fungsi stop atau restart
    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}