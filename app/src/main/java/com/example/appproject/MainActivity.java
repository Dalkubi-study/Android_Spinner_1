package com.example.appproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.bgm);
        //mediaPlayer.setLooping(true); //무한재생
        mediaPlayer.start();

        final String[] movie = {"그레이브즈","카이사","진","렝가","제라스","쉬바나","아리"};
        final Integer[] posterID = { R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7};
        final Integer[] soundID = {R.raw.graves_sound, R.raw.phiz_sound, R.raw.bolibear_sound};

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,movie);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            public void onItemSelected(AdapterView<?>arg0, View arg1, int arg2, long arg3){
                ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
                ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ivPoster.setPadding(5,5,5,5);
                ivPoster.setImageResource(posterID[arg2]);


                // 그레이브즈가 선택되었을 때 음성 재생
                if (arg2 == 0) { // 0은 그레이브즈의 인덱스
                    MediaPlayer gravesSound = MediaPlayer.create(MainActivity.this, soundID[arg2]);
                    gravesSound.start();
                    gravesSound.setOnCompletionListener(mp -> {
                        mp.release(); // 재생이 끝나면 리소스 해제
                    });
                }
                if (arg2 == 1) { // 0은 그레이브즈의 인덱스
                    MediaPlayer gravesSound = MediaPlayer.create(MainActivity.this, soundID[arg2]);
                    gravesSound.start();
                    gravesSound.setOnCompletionListener(mp -> {
                        mp.release(); // 재생이 끝나면 리소스 해제
                    });
                }
                if (arg2 == 2) { // 0은 그레이브즈의 인덱스
                    MediaPlayer gravesSound = MediaPlayer.create(MainActivity.this, soundID[arg2]);
                    gravesSound.start();
                    gravesSound.setOnCompletionListener(mp -> {
                        mp.release(); // 재생이 끝나면 리소스 해제
                    });
                }

            }

            public void onNothingSelected(AdapterView<?>arg0){
                //예외처리
            } });}}