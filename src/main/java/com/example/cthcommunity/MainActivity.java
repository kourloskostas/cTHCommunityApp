package com.example.cthcommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mediaPostInput;
    EditText addressInput;
    Button submitBtn;

    //Bottom help txt/btns
    TextView earnMore;
    ImageButton helpBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addressInput = findViewById(R.id.cTHAddress);
        mediaPostInput = findViewById(R.id.mediaPost);
        submitBtn = findViewById(R.id.submit);
        earnMore = findViewById(R.id.earnMore);
        helpBtn = findViewById(R.id.helpBtn);



        //Get and display previously submitted input
        setPrevSubmitted(mediaPostInput,addressInput);


        //Submit button listener
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //On click submit address to ?? TODO

                String mediaPostStr = mediaPostInput.getText().toString();
                String addressStr = addressInput.getText().toString();

                //todo possible validate address
                //if valid(address)
                //Invalid address or post
                if (mediaPostStr.length() < 3 && addressStr.length() < 3){displayToast("Enter post link and wallet address!");}
                else if(mediaPostStr.length() < 3){displayToast("Enter post link!");}
                else if(addressStr.length() < 3){displayToast("Enter wallet address");}

                //Submit post/address todo
                else{
                    displayToast("Address Submitted!");
                    rememberSubmitted(mediaPostStr,addressStr);

                }

            }
        });


        //Help button click listener
        helpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //On click open cheapeth.org on browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cheapeth.org"));
                startActivity(browserIntent);
            }
        });

        //Earn more textView click listener
        earnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //On click open cheapeth.org on browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cheapeth.org"));
                startActivity(browserIntent);
            }
        });



    }

    void displayToast(String text){Toast.makeText(getApplicationContext(), text,
            Toast.LENGTH_SHORT).show();
    }


    void rememberSubmitted(String post,String address){
        SharedPreferences.Editor editor = getSharedPreferences("PREVIOUSIN", MODE_PRIVATE).edit();
        editor.putString("URL",post);
        editor.putString("ADDRESS",address);
        editor.apply();
    }



    void setPrevSubmitted(EditText post,EditText address){
        SharedPreferences prefs = getSharedPreferences("PREVIOUSIN", MODE_PRIVATE);
        String addr = prefs.getString("ADDRESS", ""); // 0 is default
        String URL = prefs.getString("ADDRESS", ""); // 0 is default

        //If user has previously submitted , set equal
        if (addr != null && URL != null){
            post.setText(URL);
            address.setText(addr);
        }


    }
}
