package com.jwn.showactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.BatchUpdateException;

public class FirstActivity extends AppCompatActivity {
    private Button goToSecondButton;
    private final int REQUEST_CODE = 2;// never changes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToSecondButton = (Button) findViewById(R.id.showButtonID);
        goToSecondButton.setOnClickListener(new View.OnClickListener() {// put a listenter on button to tell when its clicked
            @Override
            public void onClick(View view) {
                // Intent tells android what we want to do. In this case start with FirstActivity (where we are) & got to SecondActivity class (where we want to go)
                // Intent constructor tells android what we want to do. In this case start with FirstActivity (where we are) & got to SecondActivity class (where we want to go)
                //StartActivity starts the process we feed to it (parameters)
                //Version 1
                //Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                //startActivity(intent);
                //Version 2
                //startActivity(new Intent(FirstActivity.this,SecondActivity.class));

                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("Message", "Hello From First Activity");//you can have as many Extras as you want
                intent.putExtra("SecondMessage", "Hello Again");
                intent.putExtra("Value", 123);
                //collect the previous intents & makes available
                //startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("returnData");

                Toast.makeText(FirstActivity.this, result, Toast.LENGTH_LONG).show();
            }
        }
    }
}
