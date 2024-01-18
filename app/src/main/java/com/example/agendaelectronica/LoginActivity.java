package com.example.agendaelectronica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> loginButtonClick());

        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(v -> registerButtonClick());
    }

    private void registerButtonClick()
    {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void loginButtonClick()
    {
        SharedPreferencesManager preferencesManager= new SharedPreferencesManager(LoginActivity.this);

        EditText userEdittext= findViewById(R.id.userEditText);
        EditText passEditText=findViewById(R.id.passEditText);

        String user=userEdittext.getText().toString();
        String pass=passEditText.getText().toString();

        if(preferencesManager.checkCredentials(user,pass))
        {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Toast toast = Toast.makeText(LoginActivity.this, "Utilizator sau parola incorecte!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onBackPressed() {}

}