package com.example.elliot.extralettuce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.elliot.extralettuce.support.Typefaces;

public class RegisterActivity extends Activity {
    protected EditText mUsername;
    protected EditText mUserEmail;
    protected EditText mUserPassword;
    protected Button mRegisterButton;
    protected mRegisterTitle;
    protected mRegisterInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mUsername = (EditText) findViewById(R.id.usernameRegisterEditText);
        mUserEmail = (EditText) findViewById(R.id.emailRegisterEditText);
        mUserPassword = (EditText) findViewById(R.id.passwordRegisterEditText);
        mRegisterButton = (Button) findViewById(R.id.registerButton);
        mRegisterTitle = (EditText) findViewById(R.id.registrationTitleTextView);
        mRegisterInfo = (EditText) findViewById(R.id.registrationInfoTextView);

        mRegisterTitle.setTypeface(Typefaces.yeahPapa(this));
        mRegisterTitle.setTypeface(Typefaces.yeahPapa(this));
        //Listen to register button click
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //toast
                Toast.makeText(RegisterActivity.this, "Welcome", Toast.LENGTH_LONG).show();

                String username = mUsername.getText().toString().trim();
                String password = mUserPassword.getText().toString().trim();
                String email = mUserEmail.getText().toString().trim();
                Intent returnHome = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(returnHome);
                //www.extraleetuce.co/account/create

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}