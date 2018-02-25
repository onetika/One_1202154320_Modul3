package android.example.com.one_1202154320_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    private ImageView WaterView; //membuat inisialisasi variabel
    private int level = 0; //inisialisasi nilai level = 0
    TextView kapasitas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WaterView = (ImageView) findViewById(R.id.WaterView); //Variabel waterview mengambil id waterview
        kapasitas = (TextView) findViewById(R.id.kapasitas);   //Variabel kapasitas mengambil id kapasitas
        kapasitas(); //manggil method kapasitas

    }

    public void kapasitas(){
        switch (level){ //buat nampilin level si battery
            case 0:kapasitas.setText("20L");break;
            case 1:kapasitas.setText("30L");break;
            case 2:kapasitas.setText("50L");break;
            case 3:kapasitas.setText("60L");break;
            case 4:kapasitas.setText("80L");break;
            case 5:kapasitas.setText("Penuh");break;

        }

    }
    public void Tambah(View view) {
        if (level < 5) { // jika kondisi <5
            level++; //level battery ditambah
            WaterView.setImageLevel(level); //mengambil image dengan sesuai level
        } else {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Air Sudah Full", Toast.LENGTH_SHORT); // nampilin toast jika air sudah penuh
            toast.show();
        }
        kapasitas(); //manggil method kapasitas
    }

    public void Kurang(View view) {
        if (level > 0) { //jika level lebih dr 0
            level--; //level air dikurang
            WaterView.setImageLevel(level); //nampilin image dengan level yang sesuai
        } else  {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Air Sedikit", Toast.LENGTH_SHORT); //nampilin toast jika level sudah terendah
            toast.show();
        }
        kapasitas();
    }
}
