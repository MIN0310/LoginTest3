package com.example.aaa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    public static final int RC_LOGIN = 1;
    boolean isNext = false;
    private EditText edUserid;
    private EditText edPassword;
    private EditText edPhone;
    private Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUserid = findViewById(R.id.ed_userid);
        edPassword = findViewById(R.id.ed_password);
        edPhone = findViewById(R.id.ed_phone);
        sw = findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text = findViewById(R.id.switch1);
                text.setText(isNext? "註冊" :"登入");
                TextView text2 = findViewById(R.id.button);
                text2.setText(isNext? "註冊": "登入");
            }
        });

    }
    public void button(View view){
        if(!isNext){

        }else {
            Intent intent = new Intent(this, AccountActivity.class);
            startActivityForResult(intent, RC_LOGIN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_LOGIN){
            if(resultCode == RESULT_OK){
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                String a = pref.getString("uid", "");
                edUserid.setText(a +"");
                String b = pref.getString("pw", "");
                edPassword.setText(b +"");
                String c = pref.getString("ph", "");
                edPhone.setText(c +"");
            }
        }
    }
}
