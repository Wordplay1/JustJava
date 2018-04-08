package com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;
/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox isWhippedCreamChecked = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhipCream = isWhippedCreamChecked.isChecked();

        CheckBox isChocolateToppingChecked = (CheckBox) findViewById(R.id.chocolate_topping_checkbox);
        boolean hasChocTopping = isChocolateToppingChecked.isChecked();

        EditText nInput = (EditText) findViewById(R.id.name_input_view);
        Editable name = nInput.getText();

        int priceDue = calculatePrice();
        String orderSummary = createOrderSummary(priceDue,hasWhipCream,hasChocTopping,name);
        displayMessage(orderSummary);
    }
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    private int calculatePrice(){
        int price = quantity * 5;
        return price;
    }
    private String createOrderSummary(int number,boolean hasWhipCream, boolean hasChocTopping, Editable name){
        String orderSummary = "";
        orderSummary += "Name: "+name+"\n";
        orderSummary += "Add whipped cream? "+hasWhipCream+"\n";
        orderSummary += "Add chocolate topping? "+hasChocTopping+"\n";
        orderSummary += "Quantity: "+quantity+"\n";
        orderSummary += "Total: $"+number+"\n";
        orderSummary += "Thank you!";
        return orderSummary;
    }
}