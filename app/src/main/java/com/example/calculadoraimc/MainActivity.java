package com.example.calculadoraimc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.calculadoraimc.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView resultado = findViewById(R.id.resultadoIMC);

        TextView classificacao = findViewById(R.id.classificacaoIMC);

        Button botaoIMC = findViewById(R.id.botaoCalculaIMC);
        botaoIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculaIMC();
            }
            private void calculaIMC(){
                EditText valorAltura = findViewById(R.id.inputAltura);

                EditText valorPeso = findViewById(R.id.inputPeso);

                double IMCCalculado =  Double.parseDouble(valorPeso.getText().toString())/ (Double.parseDouble(valorAltura.getText().toString()) * Double.parseDouble(valorAltura.getText().toString()));

                if(IMCCalculado <= 18.5){
                    classificacao.setText(String.valueOf("Abaixo do peso"));
                }else if(IMCCalculado <= 24.9){
                    classificacao.setText(String.valueOf("Peso ideal"));
                }else if(IMCCalculado <= 29.9){
                    classificacao.setText(String.valueOf("Levemente acima do peso"));
                }else if(IMCCalculado <= 34.9){
                    classificacao.setText(String.valueOf("Obesidade grau I"));
                }else if(IMCCalculado <= 39.9){
                    classificacao.setText(String.valueOf("Obesidade grau II (severa)"));
                }else{
                    classificacao.setText(String.valueOf("Obesidade grau III (morbida)"));
                }
                classificacao.setVisibility(View.VISIBLE);

                resultado.setText(String.valueOf(IMCCalculado));
                resultado.setVisibility(View.VISIBLE);
            }

        });
    }
}