package com.example.zar_uygulamas;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity {
    Button button1;
    ListView ListView1;
    TextView textView1,textView2,textView3;
    ImageView imageView1,imageView2;
    int sayi1,sayi2,zarToplam = 0,toplamHak = 7;
    Random a,b;
    List<String> liste = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        a = new Random();
        b = new Random();

        button1.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {


                sayi1 = 1+a.nextInt(6);
                sayi2 = 1+b.nextInt(6);
                zarToplam = sayi1 + sayi2;
                textView1.setText("Toplam: "+zarToplam);

                if (toplamHak >=1) {

                    toplamHak--;
                    textView2.setText("Hakkınız:  " + toplamHak);

                    //Zarların görsel kontrolü
                    if (sayi1 == 1)
                        imageView1.setImageResource(R.drawable.zar1);
                     else if (sayi1 == 2)
                        imageView1.setImageResource(R.drawable.zar2);
                     else if (sayi1 == 3)
                        imageView1.setImageResource(R.drawable.zar3);
                     else if (sayi1 == 4)
                        imageView1.setImageResource(R.drawable.zar4);
                     else if (sayi1 == 5)
                        imageView1.setImageResource(R.drawable.zar5);
                     else if (sayi1 == 6)
                        imageView1.setImageResource(R.drawable.zar6);

                    if (sayi2 == 1)
                        imageView2.setImageResource(R.drawable.zar1);
                     else if (sayi2 == 2)
                        imageView2.setImageResource(R.drawable.zar2);
                     else if (sayi2 == 3)
                        imageView2.setImageResource(R.drawable.zar3);
                    else if (sayi2 == 4)
                        imageView2.setImageResource(R.drawable.zar4);
                    else if (sayi2 == 5)
                        imageView2.setImageResource(R.drawable.zar5);
                     else if (sayi2 == 6)
                        imageView2.setImageResource(R.drawable.zar6);


                    //Listenin ekrana yazımı
                    Integer zarToplam1 = Integer.valueOf(zarToplam);

                    liste.add("İlk: " + sayi1 + " İkinci: " + sayi2 + " Toplam: " + zarToplam1);
                    ArrayAdapter<String> adaptor = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, liste);
                    ListView1.setAdapter(adaptor);


                    //Toplam Kontrol
                    if (zarToplam1 == 7 || zarToplam1 == 11) {
                        Toast.makeText(MainActivity.this, "KAZANDINIZ", Toast.LENGTH_LONG).show();
                        button1.setEnabled(false);
                    } else if (zarToplam1 == 2 || zarToplam1 == 3 || zarToplam1 == 12) {
                        Toast.makeText(MainActivity.this, "KAYBETTİNİZ", Toast.LENGTH_LONG).show();
                        button1.setEnabled(false);
                    } else {
                        Toast.makeText(MainActivity.this, "TEKRAR AT", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void init(){
        button1 = findViewById(R.id.button1);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        ListView1 = findViewById(R.id.ListView1);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
    }
        }


