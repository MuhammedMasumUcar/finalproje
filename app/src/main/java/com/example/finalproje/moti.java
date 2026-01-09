package com.example.finalproje;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class moti extends AppCompatActivity {
    TextView karsilama,puan;
    Button buton;
    Button buton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_moti);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        karsilama=findViewById(R.id.textView);
        puan=findViewById(R.id.textView2);
        buton=findViewById(R.id.button);
        buton1=findViewById(R.id.button3);
        Intent intent = getIntent();
        String isim = intent.getStringExtra("isim");
        String yas = intent.getStringExtra("yas");
        String boy = intent.getStringExtra("boy");
        String kilo = intent.getStringExtra("kilo");
        int gunlukas = intent.getIntExtra("Gunlukas",0);
        int sayfas = intent.getIntExtra("sayfas",0);
        int spor = intent.getIntExtra("spor",0);
        int yas1=Integer.parseInt(yas);
        karsilama.setText("Merhaba "+isim+" Puanın Görmek İçin Butona Dokun");
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calculate target steps based on age
                int hedefAdim;
                if (yas1 <= 25) {
                    hedefAdim = 10000;
                } else if (yas1 <= 40) {
                    hedefAdim = 6000;
                } else if (yas1 <= 55) {
                    hedefAdim = 4000;
                } else {
                    hedefAdim = 3000;
                }
                int adimPuani = (gunlukas * 40) / hedefAdim;
                if (adimPuani > 60) adimPuani = 60;
                if (adimPuani < 0) adimPuani = 0;
                int sporPuani = 0;
                if (spor >= 120) {
                    sporPuani = 30;
                } else if (spor >= 100) {
                    sporPuani = 25;
                } else if (spor >= 80) {
                    sporPuani = 20;
                } else if (spor >= 50) {
                    sporPuani = 10;
                } else if (spor > 0) {
                    sporPuani = 5;
                }
                int kitapPuani = 0;
                if (sayfas >= 30) {
                    kitapPuani = 30;
                } else if (sayfas>= 20) {
                    kitapPuani = 20;
                } else if (sayfas > 0) {
                    kitapPuani = 10;
                }
                int toplamPuan = adimPuani + sporPuani + kitapPuani;
                if (toplamPuan > 100) toplamPuan = 100;
                if (toplamPuan < 0) toplamPuan = 0;
                puan.setText("Puanın\n" + toplamPuan);
            }
        });
        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(moti.this, MainActivity.class);
                startActivity(i2);
            }
        });
    }
}