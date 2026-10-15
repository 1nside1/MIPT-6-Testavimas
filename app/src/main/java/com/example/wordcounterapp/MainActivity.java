package com.example.wordcounterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText edtUserInput = findViewById(R.id.edtUserInput);
        Spinner spnOption = findViewById(R.id.spnOption);
        Button btnCount = findViewById(R.id.btnCount);
        TextView tvResult = findViewById(R.id.tvResult);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = edtUserInput.getText().toString();

                if (text.trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, getString(R.string.error_empty_text), Toast.LENGTH_SHORT).show();
                    tvResult.setText(getString(R.string.txt_result_default));
                    return; // Sustabdome tolimesnį kodo vykdymą, nes nėra ką skaičiuoti
                }

                String selectedOption = spnOption.getSelectedItem().toString();
                int result = 0;

                if (selectedOption.equals("Words")) {
                    result = TextCounter.countWords(text);
                } else if (selectedOption.equals("Sentences")) {
                    result = TextCounter.countSentences(text);
                } else if (selectedOption.equals("Punctuation")) {
                    result = TextCounter.countPunctuation(text);
                } else if (selectedOption.equals("Numbers")) {
                    result = TextCounter.countNumbers(text);
                }

                tvResult.setText("Result: " + result);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}