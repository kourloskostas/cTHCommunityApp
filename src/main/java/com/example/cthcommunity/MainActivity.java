package com.example.cthcommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText addressInput;
    Button submitBtn;
    ImageButton helpBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addressInput = findViewById(R.id.cTHAddress);
        submitBtn = findViewById(R.id.submit);
        helpBtn = findViewById(R.id.helpBtn);

        //Submit button listener
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //On click submit address to ?? TODO

                String address = addressInput.getText().toString();

                //todo possible validate address
                //if valid(address)

                Toast.makeText(getApplicationContext(), "Address Submitted!",
                        Toast.LENGTH_SHORT).show();
            }
        });


        //Help button listener
        helpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //On click open cheapeth.org on browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cheapeth.org"));
                startActivity(browserIntent);
            }
        });



    }
}
