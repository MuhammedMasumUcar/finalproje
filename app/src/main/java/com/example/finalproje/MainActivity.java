package com.example.finalproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView text1,text2,text3,text4,text5,text6,text7;
    EditText et1,et2,et3,et4,et5,et6,et7;
    Button buton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        et1=findViewById(R.id.edittext1);
        et2=findViewById(R.id.edittext2);
        et3=findViewById(R.id.edittext3);
        et4=findViewById(R.id.edittext4);
        et5=findViewById(R.id.edittext5);
        et6=findViewById(R.id.edittext6);
        et7=findViewById(R.id.edittext7);
        buton=findViewById(R.id.button4);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this, moti.class);
                String getet1=et1.getText().toString();
                String getet2=et2.getText().toString();
                String getet3=et3.getText().toString();
                String getet4=et4.getText().toString();
                int getet5 =Integer.parseInt(et5.getText().toString());
                int getet6 =Integer.parseInt(et6.getText().toString());
                int getet7=Integer.parseInt(et7.getText().toString());
                i1.putExtra("isim",getet1);
                i1.putExtra("yas",getet2);
                i1.putExtra("boy",getet3);
                i1.putExtra("kilo",getet4);
                i1.putExtra("Gunlukas",getet5);
                i1.putExtra("sayfas",getet6);
                i1.putExtra("spor",getet7);
                startActivity(i1);
            }
        });



    }
}