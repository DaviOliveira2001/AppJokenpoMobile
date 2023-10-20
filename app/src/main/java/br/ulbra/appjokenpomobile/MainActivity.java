package br.ulbra.appjokenpomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnPedra, btnPapel, btnTes, btnReiniciar;
    ImageView imagemResultado;
    TextView txtResultado, txtPlacar;
    int pontuacaoApp = 0, pontuacaoJogador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagemResultado = (ImageView)findViewById(R.id.imgApp);
        btnPapel = (Button)findViewById(R.id.btnPapel);
        btnPedra = (Button) findViewById(R.id.btnPedra);
        btnTes = (Button) findViewById(R.id.btnTesoura);
        txtResultado = (TextView) findViewById(R.id.txtResposta);
        btnReiniciar = (Button) findViewById(R.id.btnReiniciar);
        txtPlacar = (TextView)findViewById(R.id.txtPlacar);
    }
    public void atualizarPlacar() {
        TextView txtPlacar = findViewById(R.id.txtPlacar);
        txtPlacar.setText("Jogador: " + pontuacaoJogador + " - App: " +
                pontuacaoApp);
    }
    public void selecionadoPedra(View view){
        this.opcaoSelecionado("pedra");
    }
    public void selecionadoPapel(View view) {
        this.opcaoSelecionado("papel");
    }
    public void selecionadoTesoura(View view) {
        this.opcaoSelecionado("tesoura");
    }
    public void reiniciarJogo(View view) {
        TextView txtResultado = findViewById(R.id.txtResposta);
        txtResultado.setText("");
        pontuacaoJogador = 0;
        pontuacaoApp = 0;
        atualizarPlacar();
        ImageView imagemResultado = findViewById(R.id.imgApp);
        imagemResultado.setImageResource(android.R.color.transparent);
    }
    public void opcaoSelecionado(String opcaoSelecionada){
        ImageView imageResultado = findViewById(R.id.imgApp);
        TextView txtResultado = findViewById(R.id.txtResposta);

        String opcoes[] = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[new Random().nextInt(3)];
        switch (opcaoApp){
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if((opcaoApp.equals("tesoura") && opcaoSelecionada.equals("papel")) ||
                (opcaoApp.equals("papel") && opcaoSelecionada.equals("pedra")) ||
                (opcaoApp.equals("pedra") && opcaoSelecionada.equals("tesoura"))){
            pontuacaoApp += 1;
            atualizarPlacar();
            if(pontuacaoApp == 2){
                txtResultado.setText("Resultado: Você PERDEU...");

            }
        } else if ((opcaoSelecionada.equals("tesoura") && opcaoApp.equals("papel") ||
                opcaoSelecionada.equals("papel") && opcaoApp.equals("pedra")) ||
         opcaoApp.equals("tesoura")) {
            pontuacaoJogador += 1;
            atualizarPlacar();
            if(pontuacaoJogador == 2){
                txtResultado.setText("Resultado: Você GANHOU!!!!!");

            }
        }else{
                txtResultado.setText("Resultado: Vocês EMPATARAM...");
        }
    }

}