package com.example.aaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AccountActivity extends AppCompatActivity {

    private EditText edUserid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        edUserid = findViewById(R.id.ed_userid);
    }
    public void button(View view){
        String uid = edUserid.getText().toString();
        SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
        pref.edit()
                .putString("uid", uid)
                .apply();
        AccountActivity.this.setResult(RESULT_OK);
        Intent intent = new Intent(this, PasswordActivity.class);
        startActivity(intent);
        finish();
    }
}
