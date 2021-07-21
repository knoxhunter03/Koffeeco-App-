package com.beans.koffeeco;
/**
 * Koffeeco
 * Design and Developed by Mangalam Kallo - 2021
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Checkout extends AppCompatActivity {

    int updateTotalPrice = 0; // variable to access totalPrice in all scopes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        /**
         * Recieves the data from main
         *
         */
        Intent intent = getIntent();
        int totalPrice = intent.getIntExtra(MainActivity.EXTRA_TOTAL, 0);
        updateTotalPrice += totalPrice;

        int cappuccino_qty = intent.getIntExtra(MainActivity.EXTRA_CAPPUCCINO, 0);
        int espresso_qty = intent.getIntExtra(MainActivity.EXTRA_ESPRESSO, 0);
        int latte_qty = intent.getIntExtra(MainActivity.EXTRA_LATTE, 0);
        int mocha_qty = intent.getIntExtra(MainActivity.EXTRA_MOCHA, 0);
        int frappuccino_qty = intent.getIntExtra(MainActivity.EXTRA_FRAPPUCCINO, 0);
        int americano_qty = intent.getIntExtra(MainActivity.EXTRA_AMERICANO, 0);

        TextView coffeeorder = (TextView) findViewById(R.id.order_summarry_coffee);
        TextView coffeeorder_prices = (TextView) findViewById(R.id.order_summarry_coffee_prices);
        TextView total = (TextView) findViewById(R.id.total_price_textview);

        String coffee_summary_message = "";
        String coffee_summary_price = "";


        /**
         * Displays summary of coffees with their prices
         */
        if(cappuccino_qty>0){
            int cprice = cappuccino_qty * 60;
            coffee_summary_message += "" + cappuccino_qty + " x Cappuccino\n";
            coffee_summary_price += "₹" + cprice + "\n";
        }

        if(espresso_qty>0){
            int eprice = espresso_qty * 75;
            coffee_summary_message += "" + espresso_qty + " x Espresso\n";
            coffee_summary_price += "₹" + eprice + "\n";
        }

        if(latte_qty>0){
            int lprice = latte_qty * 90;
            coffee_summary_message += "" + latte_qty + " x Latte\n";
            coffee_summary_price += "₹" + lprice + "\n";
        }

        if(mocha_qty>0){
            int mprice =  mocha_qty * 120;
            coffee_summary_message += "" + mocha_qty + " x Mocha\n";
            coffee_summary_price += "₹" + mprice + "\n";
        }

        if(frappuccino_qty>0){
            int fprice = frappuccino_qty * 120;
            coffee_summary_message += "" + frappuccino_qty+ " x Frappuccino\n";
            coffee_summary_price += "₹" + fprice + "\n";
        }

        if(americano_qty>0){
            int aprice = americano_qty * 80;
            coffee_summary_message += "" + americano_qty + " x Americano\n";
            coffee_summary_price += "₹" + aprice + "\n";
        }

        /**
         * Checks for extras (Chocolate Muffins)
         */
        CheckBox chocolateMuffins = (CheckBox) findViewById(R.id.chocolate_muffins_checkbox);
        chocolateMuffins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chocolateMuffins.isChecked()){
                    updateTotalPrice += 30;
                    total.setText(" ₹ " + updateTotalPrice);
                }
                else {
                    updateTotalPrice = updateTotalPrice - 30;
                    total.setText(" ₹ " + updateTotalPrice);
                }
            }
        });

        /**
         * Checks for extras (Cinnamon Cookies)
         */
        CheckBox cinnamonCookies = (CheckBox) findViewById(R.id.cinnamon_cookies_checkbox);
        cinnamonCookies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cinnamonCookies.isChecked()){
                    updateTotalPrice += 50;
                    total.setText(" ₹ " + updateTotalPrice);
                }
                else {
                    updateTotalPrice = updateTotalPrice - 50;
                    total.setText(" ₹ " + updateTotalPrice);
                }
            }
        });

        /**
         * Checks for extras (Belgian Waffles)
         */
        CheckBox belgianWaffles = (CheckBox) findViewById(R.id.belgian_wafflles_checkbox);
        belgianWaffles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(belgianWaffles.isChecked()){
                    updateTotalPrice += 100;
                    total.setText(" ₹ " + updateTotalPrice);
                }
                else {
                    updateTotalPrice = updateTotalPrice - 100;
                    total.setText(" ₹ " + updateTotalPrice);
                }
            }
        });


        coffeeorder.setText(coffee_summary_message);
        coffeeorder_prices.setText(coffee_summary_price);
        total.setText(" ₹ " + updateTotalPrice);

    }

    public void submitOrder (View view){
        EditText customerName = (EditText) findViewById(R.id.customer_name);
        String name = customerName.getText().toString();
        if(customerName.getText().toString().trim().length() <= 0){
            Toast.makeText(this,"Please enter your name",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            TextView orderMessage = (TextView) findViewById(R.id.order_message);
            orderMessage.setText("Thank You " + name + "❤" + "\nfor ordering with Koffeeco");
        }
    }


}