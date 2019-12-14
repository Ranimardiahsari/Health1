/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.just_java;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;
import android.content.Intent;
import android.net.Uri;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import com.example.just_java.R;

import static com.example.just_java.R.id.message;
import static com.example.just_java.R.id.quantity_text_view;

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
     * Public void adalah method dan akan menghasilkan 1 apabila ditekan order
     Call the method
     calling method
     */
    public void submitOrder(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String value = nameField.getText().toString();

        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); //agar hanya aplikasi email yg handle ini
        intent.putExtra(Intent.EXTRA_SUBJECT,"Just Java Order for" + nameField);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager())!=null) {
            startActivity(intent);
        }

    }
    /*
    create summary of order
    @param price of the order
    @param addWhippedCream is whether or not the user wants whipped cream topping
    return text Summary */

    private String createOrderSummary (int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name : Rani Mardiah Sari";
        priceMessage += "\nAdd Whipped Cream? " + addWhippedCream;
        priceMessage += "\nAdd Chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: Rp" + price;
        priceMessage += "\nThank You";
        return priceMessage;
    }
    /**
     * Calculates the price of the order.
     * @return total price
     **/
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 7000;

        if (addWhippedCream) {
            basePrice = basePrice + 1000;
        }
        if (addChocolate) {
            basePrice = basePrice + 2000;
        }

        return quantity * basePrice;
    }


    //nambah kuantiti
    //pemanggilan method
    public void Increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this, "MAXIMUM", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    //kurang kuantiti
    //pemanggilan method
    public void Decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "MINIMUM", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }


    /**
     * This method displays the given quantity value on the screen.
     * Declare the method
     * penjelasan method
     */
    private void displayQuantity (int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}