package com.example.a19_sergio_ezquerro;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowOrder extends AppCompatActivity {

    String name;
    Boolean whippedCream;
    Boolean chocolate;
    Integer count;
    TextView tvOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_order);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            name = extras.getString("name");
            whippedCream = extras.getBoolean("whippedCream");
            chocolate = extras.getBoolean("chocolate");
            count = extras.getInt("count");
        }

        tvOrder = findViewById(R.id.textView_orderSummary);

        //Change tvOrder maxwidth
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        tvOrder.setMaxWidth(width - 150);

        changeTextView();
    }

    private void changeTextView() {
        String text = ( name.isEmpty() ? "Y" : name.toString() + ", y") + "ou have ordered " + count + " coffees" + (whippedCream || chocolate ? " with " : "") +
                (whippedCream ? "whippedCream" : "") + (whippedCream && chocolate ? " and " : "")
                + (chocolate ? "chocolate" : "") + ".\nThe total price is " + (2 * count) + "'00€";
        tvOrder.setText(text);
    }
}