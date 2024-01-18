package com.example.agendaelectronica;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {

    private static final String PREF_NAME = "MyAppPreferences";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_EMAIL = "email";
    private final SharedPreferences preferences;
    private final SharedPreferences.Editor editor;

    public SharedPreferencesManager(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void saveCredentials(String username, String password, String email) {

        editor.putString(KEY_USERNAME+username, username);
        editor.putString(KEY_PASSWORD+password, password);
        editor.putString(KEY_EMAIL+email, email);
        editor.apply();
    }

    public boolean checkCredentials(String enteredUsername, String enteredPassword) {
        // Retrieve saved credentials based on the entered username
        String savedUsername = preferences.getString(KEY_USERNAME + enteredUsername, "");
        String savedPassword = preferences.getString(KEY_PASSWORD + enteredUsername, "");

        // Check if entered credentials match the saved ones
        return enteredUsername.equals(savedUsername) && enteredPassword.equals(savedPassword);
    }
}
