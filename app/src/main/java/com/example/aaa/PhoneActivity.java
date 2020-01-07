package com.example.aaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PhoneActivity extends AppCompatActivity {

    private EditText edPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        edPhone = findViewById(R.id.ed_phone);
    }
    public void button(View view){
        String ph = edPhone.getText().toString();
        SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
        pref.edit()
                .putString("ph", ph)
                .apply();
        finish();
    }
}
