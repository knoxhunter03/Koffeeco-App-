package com.beans.koffeeco;
/**
 * Koffeeco
 * Design and Developed by Mangalam Kallo - 2021
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * Coffee Quantity Variables
     */
    int Cappuccino_qty = 0;
    int Expresso_qty = 0;
    int Latte_qty = 0;
    int Mocha_qty = 0;
    int Frappuccino_qty = 0;
    int Americano_qty = 0;

    /**
     * String constants for intent pass
     */
    public static final String EXTRA_TOTAL = "com.beans.koffeco.EXTRA_TOTAL";
    public static final String EXTRA_CAPPUCCINO = "com.beans.koffeco.EXTRA_CAPPUCCINO";
    public static final String EXTRA_ESPRESSO = "com.beans.koffeco.EXTRA_ESPRESSO";
    public static final String EXTRA_LATTE = "com.beans.koffeco.EXTRA_LATTE";
    public static final String EXTRA_MOCHA = "com.beans.koffeco.EXTRA_MOCHA";
    public static final String EXTRA_FRAPPUCCINO = "com.beans.koffeco.EXTRA_FRAPPUCCINO";
    public static final String EXTRA_AMERICANO = "com.beans.koffeco.EXTRA_AMERICANO";


    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.order_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCheckout();

            }
        });
    }

    /**
     * Order Button Code
     *
     */
    public void openCheckout() {
        int total = calculatePrice(Cappuccino_qty, Expresso_qty, Latte_qty, Mocha_qty, Frappuccino_qty, Americano_qty);
        if(total==0){
            Toast.makeText(this,"Please add your coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, Checkout.class);
        intent.putExtra(EXTRA_CAPPUCCINO,Cappuccino_qty);
        intent.putExtra(EXTRA_ESPRESSO,Expresso_qty);
        intent.putExtra(EXTRA_LATTE,Latte_qty);
        intent.putExtra(EXTRA_MOCHA,Mocha_qty);
        intent.putExtra(EXTRA_FRAPPUCCINO,Frappuccino_qty);
        intent.putExtra(EXTRA_AMERICANO,Americano_qty);
        intent.putExtra(EXTRA_TOTAL,total);
        startActivity(intent);
    }

    /**
     * Cappuccino Code
     */
    private void displayCappuccino(int number){
        TextView qtyTextView = (TextView) findViewById(R.id.cappuccino_qty);
                qtyTextView.setText(""+number);
    }

    public void addCappuccino(View view){
        ++Cappuccino_qty;
        displayCappuccino(Cappuccino_qty);
    }

    public void minusCappuccino(View view){
        if(Cappuccino_qty==0){
            Toast.makeText(this,"You cannot have less than 1 coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        --Cappuccino_qty;
        displayCappuccino(Cappuccino_qty);
    }

    /**
     * Expresso Code
     */
    private void displayExpresso(int number){
        TextView qtyTextView = (TextView) findViewById(R.id.expresso_qty);
        qtyTextView.setText(""+number);
    }

    public void addExpresso(View view){
        ++Expresso_qty;
        displayExpresso(Expresso_qty);
    }

    public void minusExpresso(View view){
        if(Expresso_qty==0){
            Toast.makeText(this,"You cannot have less than 1 coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        --Expresso_qty;
        displayExpresso(Expresso_qty);
    }

    /**
     * Latte Code
     */
    private void displayLatte(int number){
        TextView qtyTextView = (TextView) findViewById(R.id.latte_qty);
        qtyTextView.setText(""+number);
    }

    public void addLatte(View view){
        ++Latte_qty;
        displayLatte(Latte_qty);
    }

    public void minusLatte(View view){
        if(Latte_qty==0){
            Toast.makeText(this,"You cannot have less than 1 coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        --Latte_qty;
        displayLatte(Latte_qty);
    }

    /**
     * Mocha Code
     */
    private void displayMocha(int number){
        TextView qtyTextView = (TextView) findViewById(R.id.mocha_qty);
        qtyTextView.setText(""+number);
    }

    public void addMocha(View view){
        ++Mocha_qty;
        displayMocha(Mocha_qty);
    }

    public void minusMocha(View view){
        if(Mocha_qty==0){
            Toast.makeText(this,"You cannot have less than 1 coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        --Mocha_qty;
        displayMocha(Mocha_qty);
    }

    /**
     * Frappuccino Code
     */
    private void displayFrappuccino(int number){
        TextView qtyTextView = (TextView) findViewById(R.id.frappuccino_qty);
        qtyTextView.setText(""+number);
    }

    public void addFrappuccino(View view){
        ++Frappuccino_qty;
        displayFrappuccino(Frappuccino_qty);
    }

    public void minusFrappuccino(View view){
        if(Frappuccino_qty==0){
            Toast.makeText(this,"You cannot have less than 1 coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        --Frappuccino_qty;
        displayFrappuccino(Frappuccino_qty);
    }

    /**
     * Amerciano Code
     */
    private void displayAmericano(int number){
        TextView qtyTextView = (TextView) findViewById(R.id.americano_qty);
        qtyTextView.setText(""+number);
    }

    public void addAmericano(View view){
        ++Americano_qty;
        displayAmericano(Americano_qty);
    }

    public void minusAmericano(View view){
        if(Americano_qty==0){
            Toast.makeText(this,"You cannot have less than 1 coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        --Americano_qty;
        displayAmericano(Americano_qty);
    }

    /**
     * Total Price
     *
     */
    private  int calculatePrice(
            int Cappuccino,
            int Espresso,
            int Latte,
            int Mocha,
            int Frappuccino,
            int Americano
    ){
        int total;
        total = (Cappuccino * 60) + (Espresso * 75) +(Latte * 90) +(Mocha * 120) +
                (Frappuccino * 120) +(Americano * 80) ;
        return total;
    }

}