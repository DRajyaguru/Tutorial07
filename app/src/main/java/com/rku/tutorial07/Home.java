package com.rku.tutorial07;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    TextView txtWelcome;
    String valUser;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txtWelcome = findViewById(R.id.txtWelcome);

        //creat pref object for retrive pref value
        SharedPreferences preferences = getSharedPreferences("collage", MODE_PRIVATE);
        editor = preferences.edit();
        valUser = preferences.getString("user", "");
        txtWelcome.setText("Welcome " + valUser);
    }
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater inflater = getMenuInflater();//create menu inflater obj for getmanu in .java file
            inflater.inflate(R.menu.option_menu, menu);//here we are getting that which menu we want to disp
            return super.onCreateOptionsMenu(menu);
        }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnu_logout)
        {
            editor.remove("user");
            editor.commit();
            Toast.makeText(Home.this,"Logout Successfully...",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Home.this,Login.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}