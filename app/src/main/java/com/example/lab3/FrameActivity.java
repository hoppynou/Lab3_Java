package com.example.lab3;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class FrameActivity extends AppCompatActivity {
    // Индекс текущей картинки
    private int currentIndex = 0;
    private final int[] images = {
            R.drawable.pic_1,
            R.drawable.pic_2,
            R.drawable.pic_3,
            R.drawable.pic_4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        ImageView imageView = findViewById(R.id.image_view_main);

        // Кнопка
        findViewById(R.id.btn_change_image).setOnClickListener(v -> {
            // Увеличиваем индекс и сбрасываем в 0, когда дойдем до конца (остаток от деления)
            currentIndex = (currentIndex + 1) % images.length;

            // Меняем картинку на экране
            imageView.setImageResource(images[currentIndex]);
        });
    }
}