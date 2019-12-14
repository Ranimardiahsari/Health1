package com.example.health;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class pertolongann extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertolongann);

        listView= (ListView) findViewById(R.id.listview1);
        final String [] values = new String[]{"1. langkah menolong orang yang pingsan", "2. Langkah Penanganan Mimisan","3. Cara Menolong Orang yang Keracunan","4. Mengobati Luka Lecet","5. Cara Mengatasi Luka Bakar Ringan","6. Penanganan Luka Bakar Sedang","7. Langkah Pertolongan Luka Bakar Berat", "8. Pertolongan Pertama pada orang Asma","9. Pertolongan untuk Lemah Jantung","10. Langkah Pertolongan untuk Mual-Mual","11. Pertolongan untuk Memar"};

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.activity_list_item, android.R.id.text1, values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent myintent = new Intent(view.getContext(), materi1.class);
                    startActivityForResult(myintent,0);
                }
                if (position==1){
                    Intent myintent = new Intent(view.getContext(), materi2.class);
                    startActivityForResult(myintent,1);
                }
                if (position==2){
                    Intent myintent = new Intent(view.getContext(), materi3.class);
                    startActivityForResult(myintent,2);
                }
                if (position==3){
                    Intent myintent = new Intent(view.getContext(), materi4.class);
                    startActivityForResult(myintent,3);
                }
                if (position==4){
                    Intent myintent = new Intent(view.getContext(), materi5.class);
                    startActivityForResult(myintent,4);
                }
                if (position==5){
                    Intent myintent = new Intent(view.getContext(), materi6.class);
                    startActivityForResult(myintent,5);
                }
                if (position==6){
                    Intent myintent = new Intent(view.getContext(), materi7.class);
                    startActivityForResult(myintent,6);
                }
                if (position==7){
                    Intent myintent = new Intent(view.getContext(), materi8.class);
                    startActivityForResult(myintent,7);
                }
                if (position==8){
                    Intent myintent = new Intent(view.getContext(), materi9.class);
                    startActivityForResult(myintent,8);
                }
                if (position==9){
                    Intent myintent = new Intent(view.getContext(), materi10.class);
                    startActivityForResult(myintent,9);
                }
                if (position==10){
                    Intent myintent = new Intent(view.getContext(), materi11.class);
                    startActivityForResult(myintent,10);
                }

            }

        });

    }
}
