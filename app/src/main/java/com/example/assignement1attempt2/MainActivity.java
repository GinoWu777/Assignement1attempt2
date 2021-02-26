package com.example.assignement1attempt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    }

    public void one(View view){
        printAns("1");
    }

    public void two(View view){
        printAns("2");
    }
    public void three(View view){
        printAns("3");
    }
    public void four(View view){
        printAns("4");
    }
    public void five(View view){
        printAns("5");
    }
    public void six(View view){
        printAns("6");
    }
    public void seven(View view){
        printAns("7");
    }
    public void eight(View view){
        printAns("8");
    }
    public void nine(View view){
        printAns("9");
    }
    public void zero(View view){
        printAns("0");
    }

    public void clear(View view){
        answer.setText("");
    }

    public void dots(View view){
        printAns(".");
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
                response.setText("You are Correct!");
                answer.setText("");
                generatenewquestion();
            }
            else {
                response.setText("Your answer is incorrect!");
                answer.setText("");
            }

        }
        else if(operator.getText().toString().equals("-")){
            correctans=firstnum-secondnum;
            if(correctans==userans){
                response.setText("You are Correct!");
                answer.setText("");
                generatenewquestion();
            }
            else {
                response.setText("Your answer is incorrect!");
                answer.setText("");
            }
        }

        else if(operator.getText().toString().equals("*")){
            correctans=firstnum*secondnum;
            if(correctans==userans){
                response.setText("You are Correct!");
                answer.setText("");
                generatenewquestion();
            }
            else {
                response.setText("Your answer is incorrect!");
                answer.setText("");
            }
        }

        else if(operator.getText().toString().equals("/")){
            correctans= Double.parseDouble(String.format("%.2f",firstnum/secondnum));

            if(correctans==userans){
                response.setText("You are Correct!");
                answer.setText("");
                generatenewquestion();
            }
            else {
                response.setText("Your answer is incorrect!");
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



    }



    private void printAns(String s) {
        String text= answer.getText().toString();
        answer.setText(text+s);
    }




}
