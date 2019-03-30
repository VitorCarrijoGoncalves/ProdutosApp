
package br.com.senai.produtos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.senai.produtos.activities.ActivityProduto;
import br.com.senai.produtos.controller.ProdutoCtrl;
import br.com.senai.produtos.dbhelper.ConexaoSQlite;
import br.com.senai.produtos.model.Produto;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastroProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexaoSQlite conexaoSQlite = ConexaoSQlite.getInstance(this);

        Produto produto = new Produto();
        produto.setId(123456);
        produto.setNome("Computador");
        produto.setQuantidadeEmEstoque(100);
        produto.setPreco(1500);

        ProdutoCtrl produtoCtrl = new ProdutoCtrl(conexaoSQlite);
        long resultado = produtoCtrl.salvarProdutoCtrl(produto);

        System.out.println("Resultado = " + resultado);

        this.btnCadastroProdutos = (Button) findViewById(R.id.btnCadastroProdutos);

        this.btnCadastroProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // mudando de uma tela para outra
                Intent intent = new Intent(MainActivity.this, ActivityProduto.class);
                startActivity(intent);

            }
        });

    }
}
