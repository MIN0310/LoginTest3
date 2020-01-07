package com.example.aaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PasswordActivity extends AppCompatActivity {

    private EditText edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        edPassword = findViewById(R.id.ed_password);
    }
    public void button(View view){
        String pw = edPassword.getText().toString();
        SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
        pref.edit()
                .putString("pw", pw)
                .apply();
        Intent intent = new Intent(this, PhoneActivity.class);
        startActivity(intent);
        finish();
    }
}
