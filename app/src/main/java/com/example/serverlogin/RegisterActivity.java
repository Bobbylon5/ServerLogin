package com.example.serverlogin;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.serverlogin.ui.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    public static final String O_Key = "key";

    private Button button1;
    private TextView tvScreenInfo;
    private EditText enterName;
    private EditText enterPassword;
    private FakeServer server;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);

        tvScreenInfo = findViewById(R.id.tv_textview1);
        tvScreenInfo.setText(R.string.registration_screen);
        button1 = findViewById(R.id.btn_confirm);
        button1.setText(R.string.register);
        enterName = findViewById(R.id.et_enternametext);
        enterPassword = findViewById(R.id.et_enterpasswordtext);
        server = new FakeServer();

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String name = enterName.getText().toString();
                String password = enterPassword.getText().toString();

                if((name.trim().isEmpty()) || (password.trim().isEmpty())){
                    Toast.makeText(getApplicationContext(), R.string.user_and_pass_fail, Toast.LENGTH_SHORT).show();
                }else {
                    server.registerUser(name, password);
                    startActivity(new Intent( RegisterActivity.this, LoginActivity.class).putExtra(O_Key, server ));
                }
            }

        });
    }
}

