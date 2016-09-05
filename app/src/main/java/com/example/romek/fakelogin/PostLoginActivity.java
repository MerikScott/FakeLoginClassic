package com.example.romek.fakelogin;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PostLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_login_activity);
        final ImageView moodImageView = (ImageView) findViewById(R.id.moodImageView);
        final EditText enterMood = (EditText) findViewById(R.id.enterMood);

        Button submitMoodButton = (Button) findViewById(R.id.submitMoodButton);
        submitMoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int input = Integer.parseInt(enterMood.getText().toString());

                if (input>=0 && input <= 100) {
                    if (input>50) {
                        displayDialog(R.layout.dialog_mood, "Doskonale...", "To wspaniała wiadomość.");
                        moodImageView.setImageResource(R.drawable.happy);
                    } else {
                        displayDialog(R.layout.dialog_mood, "Szkoda...", "Przykro mi.");
                        moodImageView.setImageResource(R.drawable.sad);
                    }
                } else {
                    Toast.makeText(PostLoginActivity.this, "Wprowadzone dane z poza zakresu 0--100", Toast.LENGTH_LONG).show();
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
            // kończy bierzące Activity i parrents as well
            finishAffinity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void displayDialog(int myDialogLayout, String myDialogTitle, String myDialogText ) {
        final Dialog dialog = new Dialog(PostLoginActivity.this);
        dialog.setContentView(myDialogLayout);
        dialog.setTitle(myDialogTitle);
        TextView moodText = (TextView)dialog.findViewById(R.id.moodText);
        moodText.setText(myDialogText);
        dialog.show();
        Button moodAnswerConfirmButton = (Button)dialog.findViewById(R.id.moodAnswerConfirmButton);
        moodAnswerConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }


}
