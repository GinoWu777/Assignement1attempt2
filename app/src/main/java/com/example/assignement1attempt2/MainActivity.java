package com.example.assignement1attempt2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView firstno;
    private TextView secondno;
    private TextView operator;
    private TextView answer;
    private TextView response;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button delete;
    private Button confirm;
    private TextView textView8;
    private static final long START_TIME_IN_MILISEC= 30000;
    private TextView Timer;
    private CountDownTimer timelimit;
    private boolean TimerRunning;
    private long Timeleftinmilisec= START_TIME_IN_MILISEC;
    private Button dot;
    private Button minus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstno = findViewById(R.id.firstno);
        secondno = findViewById(R.id.secondno);
        operator = findViewById(R.id.operator);
        answer = findViewById(R.id.answer);
        response = findViewById(R.id.response);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        delete = findViewById(R.id.delete);
        confirm = findViewById(R.id.confirm);
        Timer = findViewById(R.id.Timer);
        textView8=findViewById(R.id.textView8);
        textView8.setText("?");
        StartTimer();
        response.setVisibility(View.INVISIBLE);
        dot = findViewById(R.id.dot);
        minus = findViewById(R.id.minus);
        dot.setText(".");
        minus.setText("-");


    }

    public void one(View view){
        printAns("1");
        response.setVisibility(View.INVISIBLE);
    }

    public void two(View view){
        printAns("2");
        response.setVisibility(View.INVISIBLE);
    }
    public void three(View view){
        printAns("3");
        response.setVisibility(View.INVISIBLE);
    }
    public void four(View view){
        printAns("4");
        response.setVisibility(View.INVISIBLE);
    }
    public void five(View view){
        printAns("5");
        response.setVisibility(View.INVISIBLE);
    }
    public void six(View view){
        printAns("6");
        response.setVisibility(View.INVISIBLE);
    }
    public void seven(View view){
        printAns("7");
        response.setVisibility(View.INVISIBLE);
    }
    public void eight(View view){
        printAns("8");
        response.setVisibility(View.INVISIBLE);
    }
    public void nine(View view){
        printAns("9");
        response.setVisibility(View.INVISIBLE);
    }
    public void zero(View view){
        printAns("0");
        response.setVisibility(View.INVISIBLE);
    }

    public void clear(View view){
        answer.setText("");
        response.setVisibility(View.INVISIBLE);
    }

    public void dots(View view){
        printAns(".");
        response.setVisibility(View.INVISIBLE);
    }

    public void minus(View view){
        printAns("-");
    }
    public void confirm(View view){
        double firstnum= Double.parseDouble(firstno.getText().toString());
        double secondnum= Double.parseDouble(secondno.getText().toString());
        double correctans;
        double userans= Double.parseDouble(answer.getText().toString());

        if (operator.getText().toString().equals("+")){
            correctans=firstnum+secondnum;
            if(correctans==userans){
                response.setVisibility(View.VISIBLE);
                response.setTextColor(Color.parseColor("Green"));
                response.setText("Correct!");
                answer.setText("");
                generatenewquestion();
                OnPause();
                ResetTimer();
                StartTimer();
            }
            else {
                response.setVisibility(View.VISIBLE);
                response.setTextColor(Color.parseColor("Red"));
                response.setText("Incorrect!");
                answer.setText("");
            }

        }
        else if(operator.getText().toString().equals("-")){
            correctans=firstnum-secondnum;
            if(correctans==userans){
                response.setVisibility(View.VISIBLE);
                response.setTextColor(Color.parseColor("Green"));
                response.setText("Correct!");
                answer.setText("");
                generatenewquestion();
                OnPause();
                ResetTimer();
                StartTimer();
            }
            else {
                response.setVisibility(View.VISIBLE);
                response.setTextColor(Color.parseColor("Red"));
                response.setText("Incorrect!");
                answer.setText("");
            }
        }

        else if(operator.getText().toString().equals("*")){
            correctans=firstnum*secondnum;
            if(correctans==userans){
                response.setVisibility(View.VISIBLE);
                response.setTextColor(Color.parseColor("Green"));
                response.setText("Correct!");
                answer.setText("");
                generatenewquestion();
                OnPause();
                ResetTimer();
                StartTimer();
            }
            else {
                response.setVisibility(View.VISIBLE);
                response.setTextColor(Color.parseColor("Red"));
                response.setText("Incorrect!");
                answer.setText("");
            }
        }

        else if(operator.getText().toString().equals("/")){
            correctans= Double.parseDouble(String.format("%.2f",firstnum/secondnum));

            if(correctans==userans){
                response.setVisibility(View.VISIBLE);
                response.setTextColor(Color.parseColor("Green"));
                response.setText("Correct!");
                answer.setText("");
                generatenewquestion();
                OnPause();
                ResetTimer();
                StartTimer();
            }
            else {
                response.setVisibility(View.VISIBLE);
                response.setTextColor(Color.parseColor("Red"));
                response.setText("Incorrect!");
                answer.setText("");
            }
        }



    }


    public void generatenewquestion() {
        Random random = new Random();
        double firstnum = random.nextInt(101);
        firstno.setText(String.valueOf(firstnum));
        double secondnum = random.nextInt(100)+1;
        secondno.setText(String.valueOf(secondnum));
        int ranoperator= random.nextInt(4);

        if(ranoperator==0){
            operator.setText("+");
        }
        else if (ranoperator==1){
            operator.setText("-");
        }
        else if (ranoperator==2){
            operator.setText("*");
        }
        else if (ranoperator==3){
            operator.setText("/");
        }

        ResetTimer();



    }



    private void printAns(String s) {
        String text= answer.getText().toString();
        answer.setText(text+s);
    }

    private void StartTimer (){
        timelimit= new CountDownTimer(Timeleftinmilisec,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //millisUntilFinished=30000;
                Timeleftinmilisec=millisUntilFinished;
                UpdateTimerText();

            }

            @Override
            public void onFinish() {
                TimerRunning=false;
                answer.setText("");
                generatenewquestion();
                StartTimer();

            }
        }.start();
        TimerRunning=true;
    }

    private void OnPause(){
        timelimit.cancel();
        TimerRunning=false;
    }

    private void UpdateTimerText(){
        int seconds= (int) Timeleftinmilisec/1000;
        String timeleft= String.format("%02d",seconds);
        Timer.setText(timeleft);
    }

    private void ResetTimer(){
        Timeleftinmilisec= START_TIME_IN_MILISEC;
        //Timeleftinmilisec=30000;

        UpdateTimerText();


    }




}
