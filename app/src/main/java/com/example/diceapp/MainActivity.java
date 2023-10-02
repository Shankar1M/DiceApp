package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView diceimg1 = findViewById(R.id.imgdice1);
        final ImageView diceimg2 = findViewById(R.id.imgdice2);

        final int [] diceimages = { R.drawable.dice_1,
                R.drawable.dice_2,
                R.drawable.dice_3,
                R.drawable.dice_4,
                R.drawable.dice_5,
                R.drawable.dice_6 };
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.dice_sound);
        Button btnRoll = findViewById(R.id.btnRollTheDice);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("DiceApp"," btnRoll is Tapped now!");

                Random rndObject1 = new Random();
                int newrndObject1 = rndObject1.nextInt(6);
                diceimg1.setImageResource(diceimages[newrndObject1]);

                int newrndObject2 = rndObject1.nextInt(6);
                diceimg2.setImageResource(diceimages[newrndObject2]);
                mediaPlayer.start();
                if(newrndObject1 == newrndObject2)
                {
                    Toast.makeText(MainActivity.this,"Both dices are matched",Toast.LENGTH_SHORT).show();
                }
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(diceimg1);
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(diceimg2);
            }

        });
    }
}