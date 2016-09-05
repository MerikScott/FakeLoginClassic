package com.example.romek.fakelogin;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView loginPrompt, loginEntered, passwordEntered;
    final static String PROPER_LOGIN = "a";//"oskar";
    final static String PROPER_PASSWORD = "b";//"password12";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton;
        loginButton = (Button) findViewById(R.id.loginButton);
        loginPrompt = (TextView) findViewById(R.id.loginPrompt);
        loginEntered = (TextView) findViewById(R.id.loginEntered);
        passwordEntered = (TextView) findViewById(R.id.passwordEntered);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( (PROPER_LOGIN.equals(loginEntered.getText().toString()) ) &&
                        (PROPER_PASSWORD.equals(passwordEntered.getText().toString()) )
                        ) {
                    doPostLoginActivity();
                } else {
                    displayLoginDialog();
                }
            }
        });
    }

    // This method creates the menu on the app
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // Called when a options menu item is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.exit_the_app) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void displayLoginDialog() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_login);
        dialog.setTitle("Ups..");
        dialog.show();
        //Toast.makeText(MainActivity.this, "zły login i hasło ", Toast.LENGTH_LONG).show();
        Button oneMoreTimeButton = (Button) dialog.findViewById(R.id.oneMoreTimeButton);
        oneMoreTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        Button quitButton = (Button) dialog.findViewById(R.id.quitButton);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                finish();
            }
        });
    }

    private void doPostLoginActivity() {
        startActivity(new Intent(getApplicationContext(), PostLoginActivity.class));
    }
}
