package com.vickyhuang.soundpool;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private SoundPool soundPool;
    private int sound1, sound2, sound3, sound4, sound5, sound6, sound7;
    private int sound1Stream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(7)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(7, AudioManager.STREAM_MUSIC, 0);
        }

        sound1 = soundPool.load(this, R.raw.poyo, 1);
        sound2 = soundPool.load(this, R.raw.cartoon, 1);
        sound3 = soundPool.load(this, R.raw.goofy_spring_bounces, 1);
        sound4 = soundPool.load(this, R.raw.slide_whistle, 1);
        sound5 = soundPool.load(this, R.raw.slide_whistle_to_drum, 1);
        sound6 = soundPool.load(this, R.raw.stomach_thumps, 1);
        sound7 = soundPool.load(this, R.raw.the_slow_rabbit, 1);
    }



    public void playSound(View v) {
        switch (v.getId()) {
            case R.id.sound1:
                sound1Stream = soundPool.play(sound1, 1, 1, 0, 0, 1);
                break;
            case R.id.sound2:
                soundPool.play(sound2, 1, 1, 0, 0, 1);
                break;
            case R.id.sound3:
                soundPool.play(sound3, 1, 1, 0, 0, 1);
                break;
            case R.id.sound4:
                soundPool.play(sound4, 1, 1, 0, 0, 1);
                break;
            case R.id.sound5:
                soundPool.play(sound5, 1, 1, 0, 0, 1);
                break;
            case R.id.sound6:
                soundPool.play(sound6, 1, 1, 0, 0, 1);
                break;
            case R.id.sound7:
                soundPool.play(sound7, 1, 1, 0, 0, 1);
                soundPool.pause(sound1Stream);
//                soundPool.autoPause();
                break;

        }
        /*if (v.getId() == R.id.sound1) {
            soundPool.play(sound1, 1, 1, 0, 0, 1);
        } else if (v.getId() == R.id.sound2) {
            soundPool.play(sound2, 1, 1, 0, 0, 1);
        }*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}