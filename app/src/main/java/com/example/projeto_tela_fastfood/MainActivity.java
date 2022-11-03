package com.example.projeto_tela_fastfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Atributos



    // Métodos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtTotal= findViewById(R.id.txtTatol);
        TextView txtThanks = findViewById(R.id.txtThanks);
        EditText etNome = findViewById(R.id.edtNome);

        txtThanks.setVisibility(View.INVISIBLE);
        txtTotal.setVisibility(View.INVISIBLE);


        actionBtnOrder(txtThanks, etNome);
        actionBtnMoreLess(txtTotal);
    }

    protected void actionBtnMoreLess(TextView txtTotal){

        Button btnMais = findViewById(R.id.btnMais);
        Button btnMenos = findViewById(R.id.btnMenos);
        EditText edtQuantidade = findViewById(R.id.edtQuantidade);



        btnMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String amountString = String.valueOf(edtQuantidade.getText());
                if(amountString.equals("")){
                    amountString = "0";
                }
                int amount = Integer.parseInt(amountString) + 1;
                edtQuantidade.setText(String.valueOf(amount));
                setTotal(txtTotal, amount);

            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amountString = String.valueOf(edtQuantidade.getText());
                if(amountString.equals("") || amountString.equals("0")){
                    return;
                }
                int amount = Integer.parseInt(amountString) - 1;
                edtQuantidade.setText(String.valueOf(amount));
                setTotal(txtTotal, amount);
            }
        });

    }

    public void actionBtnOrder(TextView txtThank, EditText etNome){
        Button btnOrder = findViewById(R.id.btnOrder);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtThank.setText("Thanks for your preference, " + etNome.getText() + "!");
                txtThank.setVisibility(View.VISIBLE);
            }
        });
    }

    public void setTotal(TextView txtTotal, int amount){

        txtTotal.setText("You total is $" + amount*15);
        txtTotal.setVisibility(View.VISIBLE);
    }
}