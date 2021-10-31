package com.project.kalkulatorapp;
import android.support.v4.app.RemoteActionCompatParcelizer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView input1, input2, operator, result, notif;
    Button btHitung, btJumlah, btKurang, btKali, btBagi;
    private int operation = 0;
    private double HasilAkhir = 0.0;
    private String Cek1 = "";
    private String Cek2 = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input1 = (TextView) findViewById(R.id.masukan1);
        input2 = (TextView) findViewById(R.id.masukan2);
        operator = (TextView) findViewById(R.id.operan);
        result = (TextView) findViewById(R.id.hasil);
        notif = (TextView) findViewById(R.id.notifikasi);
        btHitung = (Button) findViewById(R.id.hitung);
        btJumlah = (Button) findViewById(R.id.tambah);
        btKurang = (Button) findViewById(R.id.kurang);
        btKali = (Button) findViewById(R.id.kali);
        btBagi = (Button) findViewById(R.id.bagi);
    }
    public void klikTambah(View V){
        operation = 1;
        operator.setText("+");
    }
    public void klikKurang(View V){
        operation = 2;
        operator.setText("-");
    }
    public void klikKali(View V){
        operation = 3;
        operator.setText("x");
    }
    public void klikBagi(View V){
        operation = 4;
        operator.setText(":");
    }
    public void klikHasil(View V){
        Cek1 = input1.getText().toString();
        Cek2 = input2.getText().toString();
        if((Cek1.equalsIgnoreCase("")) || (Cek2.equalsIgnoreCase(""))){
            notif.setText("Kolom tidak boleh kosong");
        }
        else{
            double inputA = Double.parseDouble(input1.getText().toString());
            double inputB = Double.parseDouble(input2.getText().toString());
            switch(operation){
                case 1:
                    HasilAkhir = inputA + inputB;
                    break;
                case 2:
                    HasilAkhir = inputA - inputB;
                    break;
                case 3:
                    HasilAkhir = inputA * inputB;
                    break;
                case 4:
                    HasilAkhir = inputA / inputB;
                    break;
                case 0:
                    notif.setText("Pilih operasi perhitungan dahulu!");
                    break;
                default:
                    notif.setText("Undescribeable Error!");
                    break;
            }
            if(operation < 1){
                result.setText("0");
            }
            else{
                String hasilString = String.valueOf(HasilAkhir);
                result.setText(hasilString);
                notif.setText("Kalkulator App");
            }
        }
    }
    public void clearInput1(View V){
        input1.setText("");
        operation = 0;
    }
    public void clearInput2(View V){
        input2.setText("");
        operation = 0;
    }
}