package com.example.coffeecup;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0, total = 0;



    public void increment(View view) {

        quantity = quantity + 1;

        display(quantity);

        displayPrice(calculatePrice(quantity,10));



    }

    public void decrement(View view) {

        if (quantity > 0) {

            quantity = quantity - 1;
        }

        display(quantity);

        displayPrice(calculatePrice(quantity,10));

    }



    public int calculatePrice(int quantity,int cost_per_coffee){

        total = quantity * cost_per_coffee;

        return total;


    }



    public void ordersummary(int finalprice,boolean hasWhipCream, boolean addChoco,String name) {



        String priceMessage = "Name : " + name + "\n" + "Whipped Cream Added : " + hasWhipCream + "\n" + "Chocolate Added : " + addChoco + "\n" + "Quantity : " + quantity + "\n" + "Total : " + finalprice + "\n" + "Thank You visit Again";

        displayMessage(priceMessage);

    }


    public void submitorder(View view) {

        EditText name = (EditText) findViewById(R.id.editText);

        String value = name.getText().toString();

        CheckBox hasWhippedCream = (CheckBox) findViewById(R.id.checkbox);

        boolean hasWhipCream = hasWhippedCream.isChecked();

        CheckBox hasChocolate = (CheckBox) findViewById(R.id.checkboxOne);

        boolean add_chocolate = hasChocolate.isChecked();


        int totalprice = calculatePrice(quantity,10);
        displayPrice(totalprice);

        ordersummary(totalprice,hasWhipCream,add_chocolate,value);

    }


    private void displayMessage(String message) {

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

