package com.example.animatedimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadGif();
    }
    private void loadGif() {
        try {
            ImageDecoder.Source source = null;

                source = ImageDecoder.createSource(getResources(),
                        R.drawable.giphy);
            Drawable decodedAnimation = null;
                decodedAnimation = ImageDecoder.decodeDrawable(source);


            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageDrawable(decodedAnimation);


                if (decodedAnimation instanceof AnimatedImageDrawable) {
                    Toast.makeText(getApplicationContext(),
                            "loadGif: Animation started",
                            Toast.LENGTH_LONG).show();
                    ((AnimatedImageDrawable) decodedAnimation).start();
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
