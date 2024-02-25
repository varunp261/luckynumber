package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView welcomeTxt,luckyNumberTxt;
    Button sharebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcomeTxt = findViewById(R.id.textView2);
        luckyNumberTxt = findViewById(R.id.textView3);
        sharebtn = findViewById(R.id.sharebtn);

       //Receiving the data from Main Activity
        Intent i = getIntent();
        String userName = i.getStringExtra("name");

        //displaying the random number
        int random_num = generateRandomNumbers();
        luckyNumberTxt.setText(""+random_num);

        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName,random_num);
            }
        });

    }

    private void shareData(String userName, int randomNum) {
        //Implicit Intent

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,userName+ " got lucky today");
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is :"+randomNum);
        startActivity(Intent.createChooser(i,"Choose a Platform"));

    }


    //Generate Random Numbers

    public int generateRandomNumbers(){
        Random random = new Random();
        int upper_limit = 1000;
        int randomNumberGenerated = random.nextInt(upper_limit);

        return randomNumberGenerated;
    }
}