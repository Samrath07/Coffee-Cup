package com.example.coffeecup;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 1, total = 0;


    public void increment(View view) {

        if (quantity < 100) {

            quantity = quantity + 1;


        } else {

            Toast.makeText(getApplicationContext(), "You cannot order more than 100 cup", Toast.LENGTH_SHORT).show();
        }


        display(quantity);


    }

    public void decrement(View view) {

        if (quantity > 1) {

            quantity = quantity - 1;


        } else {

            Toast.makeText(getApplicationContext(), "You cannot order less than 1 cup", Toast.LENGTH_SHORT).show();
        }


        display(quantity);
    }


    public int calculatePrice(int quantity, int cost_per_coffee, boolean hasWhipCream, boolean addChocolate) {

        if (hasWhipCream && addChocolate) {

            total = (cost_per_coffee + 20) * quantity;
        } else if (addChocolate) {

            total = (cost_per_coffee + 15) * quantity;
        } else if (hasWhipCream) {

            total = (cost_per_coffee + 10) * quantity;
        } else {

            total = cost_per_coffee * quantity;
        }

        return total;


    }


    public String ordersummary(int finalprice, boolean hasWhipCream, boolean addChoco, String name) {

        String priceMessage = " ";
         priceMessage = "Name : " + name + "\n" + "Whipped Cream Added : "
                + hasWhipCream + "\n" + "Chocolate Added : "
                + addChoco + "\n" + "Quantity : " + quantity + "\n" + "Total : "
                + finalprice + "\n" + "Thank You visit Again";

        return priceMessage;
    }


    public void submitorder(View view) {

        EditText name = (EditText) findViewById(R.id.editText);

        String value = name.getText().toString();
        //
        CheckBox hasWhippedCream = (CheckBox) findViewById(R.id.checkbox);
        //
        boolean hasWhipCream = hasWhippedCream.isChecked();
        //
        //
        CheckBox hasChocolate = (CheckBox) findViewById(R.id.checkboxOne);
        //
        boolean add_chocolate = hasChocolate.isChecked();
        //
        //
        int totalprice = calculatePrice(quantity, 10, hasWhipCream, add_chocolate);
        //
        String message = ordersummary(totalprice, hasWhipCream, add_chocolate, value);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Cup for " + value);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null) {

            startActivity(intent);
        }


    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText("" + number);

    }
}

