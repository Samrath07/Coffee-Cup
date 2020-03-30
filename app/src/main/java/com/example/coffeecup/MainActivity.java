package com.example.coffeecup;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 1;
    public void increment(View view){

        quantity = quantity + 1;
        display(quantity);
        displayPrice(quantity * 10);

    }

    public void decrement(View view) {

        if(quantity > 0) {

            quantity = quantity - 1;
        }
        display(quantity);
        displayPrice(quantity * 10);
    }

    public void submitorder(View view){

        String priceMessage = "Total :$" + quantity * 10 + "\n" + "Thank You visit Again" ;

        displayMessage(priceMessage);

    }


    private void displayMessage(String message){

        TextView priceTextView = (TextView) findViewById(R.id.displayPrice);
        priceTextView.setText(message);


    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.displayPrice);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }


    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText("" + number);
    }
}

