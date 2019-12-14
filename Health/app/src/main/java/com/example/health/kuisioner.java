package com.example.health;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class kuisioner extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuisioner);

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

        CheckBox whippedCreamCheckbox1 = (CheckBox) findViewById(R.id.whipped_cream_checkbox1);
        boolean hasWhippedCream1 = whippedCreamCheckbox1.isChecked();

        CheckBox chocolateCheckBox1 = (CheckBox) findViewById(R.id.chocolate_checkbox1);
        boolean hasChocolate1 = chocolateCheckBox1.isChecked();

        CheckBox whippedCreamCheckbox2 = (CheckBox) findViewById(R.id.whipped_cream_checkbox2);
        boolean hasWhippedCream2 = whippedCreamCheckbox2.isChecked();

        CheckBox chocolateCheckBox2 = (CheckBox) findViewById(R.id.chocolate_checkbox2);
        boolean hasChocolate2 = chocolateCheckBox2.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate, hasWhippedCream1,  hasChocolate1, hasWhippedCream2,  hasChocolate2);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, hasWhippedCream1, hasChocolate1, hasWhippedCream2, hasChocolate2);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); //agar hanya aplikasi email yg handle ini
        intent.putExtra(Intent.EXTRA_SUBJECT,"Health Kuisioner" + nameField);
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

    private String createOrderSummary (int price, boolean addWhippedCream, boolean addChocolate, boolean addWhippedCream1, boolean addChocolate1, boolean addWhippedCream2, boolean addChocolate2){
        String priceMessage = "Kuisioner";
        priceMessage += "\n1.Manakah yang sering kamu konsumsi di pagi hari?";
        priceMessage += "\n*Air Putih/ Air Mineral: " + addWhippedCream;
        priceMessage += "\n*Buah-buahan: " + addChocolate;

        priceMessage += "\n2. Manakah menu sehat yang kamu sukai?";
        priceMessage += "\n*susu sapi: " + addWhippedCream1;
        priceMessage += "\n*susu kedelai: " + addChocolate1;

        priceMessage += "\n3. Manakah menu sehat yang kamu sukai untuk di konsumsi?";
        priceMessage += "\n*sayuran: " + addWhippedCream2;
        priceMessage += "\n*buah-buahan: " + addChocolate2;

        priceMessage += "\nBeri Rate Untuk Aplikasi Ini(1-10): " + quantity;
        priceMessage += "\nPersentase(%): " + price;
        priceMessage += "\nThank You :)";
        return priceMessage;
    }
    /**
     * Calculates the price of the order.
     * @return total price
     **/
    private int calculatePrice(boolean whippedCream, boolean chocolate, boolean hasWhippedCream, boolean hasChocolate, boolean addWhippedCream1, boolean addChocolate1) {
        int basePrice = 10;


        return quantity * basePrice;
    }


    //nambah kuantiti
    //pemanggilan method
    public void Increment(View view) {
        if (quantity == 10) {
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