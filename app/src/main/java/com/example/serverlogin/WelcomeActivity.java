package com.example.serverlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    public static final String N_Key = "key";

    private TextView tvWelcomeText;
    private TextView tvDisplayName;
    private String welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        tvWelcomeText = findViewById(R.id.textView1);
        tvDisplayName = findViewById(R.id.textView2);

        //welcomeText = String.valueOf(R.string.welcome);

        String name = getIntent().getStringExtra(LoginActivity.N_Key);

        tvDisplayName.setText(name);
    }
}
