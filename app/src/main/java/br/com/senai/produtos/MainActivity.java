
package br.com.senai.produtos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.senai.produtos.activities.ActivityProduto;
import br.com.senai.produtos.activities.ListarProdutosActivity;
import br.com.senai.produtos.dbhelper.ConexaoSQlite;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastroProdutos;
    private Button btnListarProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexaoSQlite conexaoSQlite = ConexaoSQlite.getInstance(this);

        this.btnCadastroProdutos = (Button) findViewById(R.id.btnCadastroProdutos);

        this.btnListarProdutos = (Button) findViewById(R.id.btnListarProdutos);

        this.btnCadastroProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // mudando de uma tela para outra
                Intent intent = new Intent(MainActivity.this, ActivityProduto.class);
                startActivity(intent);

            }
        });

        this.btnListarProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListarProdutosActivity.class);
                startActivity(intent);
            }
        });

    }
}
