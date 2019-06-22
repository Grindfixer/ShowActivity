package com.jwn.showactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView showMessage;
    private Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //messages from FirstActivity
        Bundle extras = getIntent().getExtras();

        showMessage = (TextView) findViewById(R.id.messageTextView);
        backButton = (Button) findViewById(R.id.goBackButtonID);

        //check
        if (extras != null) {
            String message = extras.getString("SecondMessage");
            int myInt = extras.getInt("Value");

            showMessage.setText("Message is " + message + " and " + String.valueOf(myInt));

        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData", "From SecondActivity");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

    }

}// end SecondActivity
