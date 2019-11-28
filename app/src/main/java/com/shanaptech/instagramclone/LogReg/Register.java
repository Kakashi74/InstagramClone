package com.shanaptech.instagramclone.LogReg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.shanaptech.instagramclone.MainActivity;
import com.shanaptech.instagramclone.R;

public class Register extends AppCompatActivity {
    private EditText name ,email , password;
    private Button signup;
    private TextView logText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.input_name);
        email = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);
        signup = findViewById(R.id.btn_signup);
        logText = findViewById(R.id.link_login);

        logText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this , Login.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this , MainActivity.class));
            }
        });
    }
}
