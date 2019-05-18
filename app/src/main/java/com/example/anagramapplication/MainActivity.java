package com.example.anagramapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAnagram(View view) {
        Anagram anagram = new Anagram();
        EditText editAnagramView = findViewById(R.id.editText);
        String editAnagramText = editAnagramView.getText().toString();

        TextView anagramView = findViewById(R.id.textView);
        anagramView.setText(anagram.getAnagram(editAnagramText));
    }

    public void onClear(View view) {
        EditText editAnagramView = findViewById(R.id.editText);
        editAnagramView.setText("");
    }
}
