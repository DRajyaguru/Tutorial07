package com.rku.tutorial07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText txtUsername,txtPassword;
    Button btnLogin;
    Database helper;
    SharedPreferences preferences;
    SharedPreferences.Editor edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        helper = new Database(this);

        preferences = getSharedPreferences("collage",MODE_PRIVATE); //Create fill for saving SharedPrefs data (name:collage)
        edit = preferences.edit();
        String username = preferences.getString("user","");

        assert username != null;
        if(!username.equals(""))
        {
            Intent intent = new Intent(Login.this,Home.class);
            startActivity(intent);
            finish();
        }

        final EditText Username = findViewById(R.id.edtEmail);
        final EditText Password = findViewById(R.id.edtPassword);
        Button LoginBtn = findViewById(R.id.btnLogin);


    }
    public void LoginData(View view){
        Cursor cursor=helper.checkLogin();
       /* String UsernameValue = Username.getText().toString();
        String PasswordValue = Password.getText().toString();*/

        if(cursor!=null&&cursor.getCount()>0) {
            cursor.moveToFirst();

            do {
                String UsernameVal = cursor.getString(3);
                String PasswordVal = cursor.getString(4);
                if (UsernameVal.equals(txtUsername.getText().toString()) && PasswordVal.equals(txtPassword.getText().toString())) {
                    Intent intent = new Intent(Login.this, Home.class);
                    intent.putExtra("username", txtUsername.getText().toString());
                    startActivity(intent);

                    finish();
                }
            } while (cursor.moveToNext());
        }
    }
    public void MoveOnRegister(View view) {
        Intent i=new Intent(Login.this,Registration.class);
        startActivity(i);
    }
}