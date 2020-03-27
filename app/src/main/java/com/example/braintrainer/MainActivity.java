package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    boolean f=true;
    int a,b,z,right=0,wrong=0;
    public void playAgain(View view){
        f=true;
        right=0;
        TextView name = (TextView) findViewById(R.id.textView);
        name.animate().alpha(1).setDuration(1000);

        Button pA = (Button) findViewById(R.id.playAgain);
        pA.animate().alpha(0).setDuration(500);
        wrong=0;
        timer();
        generateNo();
    }

    public void timer() {

        CountDownTimer timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                TextView timer1 = (TextView) findViewById(R.id.timer);
                int c = (int) millisUntilFinished / 1000;
                String s;
                if (c <= 9) {
                    s = "0" + Integer.toString(c);
                } else {
                    s = Integer.toString(c);
                }
                timer1.setText("00:" + s);
            }

            @Override
            public void onFinish() {
                f = false;
                TextView textView = (TextView) findViewById(R.id.ab);
                textView.setText("Your Score: " + Integer.toString(right));

                TextView name = (TextView) findViewById(R.id.textView);
                name.animate().alpha(0).setDuration(500);

                Button pA = (Button) findViewById(R.id.playAgain);
                pA.animate().alpha(1).setDuration(1000);
            }
        }.start();
    }



    public int random(){
        int random=new Random().nextInt(100);
        return random;
    }

    public int random4(){
        int random=new Random().nextInt(4)+1;
        return random;

    }




    public void checkAnswer(View view) {

        if (f) {
            Button bet = (Button) view;
            String buttonText = bet.getText().toString();
            if (Integer.toString(a + b).equals(buttonText)) {
                right += 1;
                generateNo();
            } else {
                wrong += 1;
                generateNo();

            }

        }
    }

    public void generateNo(){
        a =random();
        b=random();
        TextView textView=(TextView) findViewById(R.id.ab);
        textView.setText(Integer.toString(a)+"+"+Integer.toString(b));

        TextView textView1=(TextView) findViewById(R.id.score);
        textView1.setText(Integer.toString(right)+"/"+Integer.toString(wrong));

        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        Button b4 = (Button) findViewById(R.id.button4);
        z=random4();
        if(z==1){
            b1.setText(Integer.toString(a+b));
            b2.setText(Integer.toString(random()));
            b3.setText(Integer.toString(random()));
            b4.setText(Integer.toString(random()));
        }
        else if(z==2){
            b2.setText(Integer.toString(a+b));
            b1.setText(Integer.toString(random()));
            b3.setText(Integer.toString(random()));
            b4.setText(Integer.toString(random()));
        }
        else if(z==3){
            b3.setText(Integer.toString(a+b));
            b1.setText(Integer.toString(random()));
            b2.setText(Integer.toString(random()));
            b4.setText(Integer.toString(random()));
        }
        else if(z==4){
            b4.setText(Integer.toString(a+b));
            b1.setText(Integer.toString(random()));
            b3.setText(Integer.toString(random()));
            b2.setText(Integer.toString(random()));
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
