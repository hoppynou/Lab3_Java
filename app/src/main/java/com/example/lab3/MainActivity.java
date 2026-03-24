package com.example.lab3;

import android.content.Intent; // Обязательно добавь этот импорт
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Устанавливаем разметку с кнопками
        setContentView(R.layout.activity_main);

        // 1. Переход на экран с LinearLayout
        findViewById(R.id.btn_linear).setOnClickListener(v ->
                startActivity(new Intent(this, LinearActivity.class)));

        // 2. Переход на экран с ConstraintLayout
        findViewById(R.id.btn_constraint).setOnClickListener(v ->
                startActivity(new Intent(this, ConstraintActivity.class)));

        // 3. Переход на экран с FrameLayout (пока будет гореть красным, сейчас создадим)
        findViewById(R.id.btn_frame).setOnClickListener(v ->
                startActivity(new Intent(this, FrameActivity.class)));
    }
}