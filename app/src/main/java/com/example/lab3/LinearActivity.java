package com.example.lab3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LinearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        // Настройка системных отступов
        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        // Поиск элементов интерфейса
        LinearLayout chatContainer = findViewById(R.id.chat_container);
        EditText editText = findViewById(R.id.edit_text_chat);
        Button btnSend = findViewById(R.id.btn_send);
        ScrollView scrollView = (ScrollView) chatContainer.getParent();

        // Обработка нажатия кнопки "Отправить"
        btnSend.setOnClickListener(v -> {
            String message = editText.getText().toString().trim();

            if (!message.isEmpty()) {
                // Создаем новое TextView для сообщения [cite: 10]
                TextView newMessage = new TextView(this);
                newMessage.setText(message);
                newMessage.setTextSize(18);
                newMessage.setPadding(0, 0, 0, 16); // Отступ между сообщениями

                // Добавляем сообщение в контейнер
                chatContainer.addView(newMessage);

                // Очищаем поле ввода
                editText.setText("");

                // Автоматическая прокрутка вниз
                scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));
            }
        });
    }
}