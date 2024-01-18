package com.example.agendaelectronica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> loginButtonClick());

        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(v -> registerButtonClick());

    }

    private void registerButtonClick()
    {
        SharedPreferencesManager preferencesManager= new SharedPreferencesManager(RegisterActivity.this);

        String user= ((EditText) findViewById(R.id.userEditText)).getText().toString();
        String pass= ((EditText) findViewById(R.id.passEditText)).getText().toString();
        String email= ((EditText) findViewById(R.id.emailEdittext)).getText().toString();

        preferencesManager.saveCredentials(user, pass, email);

        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);

    }

    private void loginButtonClick()
    {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {}
}