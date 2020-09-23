package com.rku.tutorial07;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    Database helper;
    EditText edtFirstName,edtLastName,edtEmail,edtPassword;
    RadioGroup rdbGender;
    Spinner swcBranch;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("Registration Form");

        helper = new Database(this);
        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        rdbGender = findViewById(R.id.rdbGender);
        swcBranch = findViewById(R.id.swcBranch);
    }
    public void btnSubmit(View view){
        String v_FirstName = edtFirstName.getText().toString();
        String v_LastName = edtLastName.getText().toString();
        String v_Email = edtEmail.getText().toString();
        String v_Password = edtPassword.getText().toString();
        String v_Branch = swcBranch.getSelectedItem().toString();

        //int selectedID = rdbGender.getCheckedRadioButtonId();
        RadioButton v_Gender =findViewById(rdbGender.getCheckedRadioButtonId());
        String gender = v_Gender.getText().toString();

       /* String valid = "";
        if (v_FirstName.equals("")) {
            valid = valid + "FirstName ";
        }
        if (v_LastName.equals("")) {
            valid = valid + "LastName ";
        }
        if (v_Email.equals("")) {
            valid = valid + "Email ";
        }
        if (v_Password.equals("")) {
            valid = valid + "Password ";
        }
        if (v_Branch.equals("Select branch")) {
            valid = valid + "City ";
        }
        if (!valid.equals("")) {
            Toast.makeText(Registration.this, "Enter " + valid, Toast.LENGTH_SHORT).show();
        }
        if (valid.equals(""))
        {
            if(helper.insertData(v_FirstName,v_LastName,v_Email,v_Password,v_Gender,v_Branch))
            {
                Toast.makeText(Registration.this,"Registration Successfully",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Registration.this, Login.class);
                startActivity(i);
            }
            finish();
        }*/
        if(helper.insertData(v_FirstName,v_LastName,v_Email,v_Password,gender,v_Branch))
        {
            Toast.makeText(Registration.this,"Registration Successful",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Registration.this,Home.class);
            startActivity(intent);

        }
        else {
            Toast.makeText(Registration.this,"Something Went Wrong",Toast.LENGTH_LONG).show();
        }
    }


}