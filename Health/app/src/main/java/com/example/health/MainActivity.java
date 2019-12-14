package com.example.health;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn4;
    TextView teks, teks2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.btn1:
//                Intent i = new Intent(MainActivity.this, pertolongann.class); //MainActivity adalah aktivity awal ,praktikum1Activity activity yang akan di tuju
//                startActivity(i);
//                break;
//            case R.id.btn2:
//                Intent n = new Intent(MainActivity.this, kesehatann.class); //MainActivity adalah aktivity awal ,praktikum1Activity activity yang akan di tuju
//                startActivity(n);
//                break;
//            case R.id.btn3:
//                Intent k = new Intent(MainActivity.this, kotakk.class); //MainActivity adalah aktivity awal ,praktikum1Activity activity yang akan di tuju
//                startActivity(k);
//                break;
//            case R.id.btn4:
//                Intent l = new Intent(MainActivity.this, kuisioner.class); //MainActivity adalah aktivity awal ,praktikum1Activity activity yang akan di tuju
//                startActivity(l);
//                break;
//
//        }
    public void pertolongan (View view){
        Intent intent = new Intent(MainActivity.this, pertolongann.class);
        startActivity(intent);
    }
    public void berita (View view){
        Intent intent = new Intent(MainActivity.this, kesehatann.class);
        startActivity(intent);
    }
    public void kuis (View view){
        Intent intent = new Intent(MainActivity.this, kuisioner.class);
        startActivity(intent);
    }
}
