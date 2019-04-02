package br.com.senai.produtos.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.senai.produtos.R;
import br.com.senai.produtos.controller.ProdutoCtrl;
import br.com.senai.produtos.dbhelper.ConexaoSQlite;
import br.com.senai.produtos.model.Produto;

public class ActivityProduto extends AppCompatActivity {

    private EditText txtIdProduto;
    private EditText txtNomeProduto;
    private EditText txtQtdeProduto;
    private EditText txtPrecoProduto;

    private Button btnSalvarProduto;

    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        txtIdProduto = (EditText) findViewById(R.id.edtIdProduto);
        txtNomeProduto = (EditText) findViewById(R.id.edtNomeProduto);
        txtQtdeProduto = (EditText) findViewById(R.id.edtQtdeProduto);
        txtPrecoProduto = (EditText) findViewById(R.id.edtPrecoProduto);

        btnSalvarProduto = (Button) findViewById(R.id.btnSalvarProduto);

        this.clickNoBotaoSalvarListener();

    }

    private void clickNoBotaoSalvarListener() {

        this.btnSalvarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Produto produtoACadastrar = getDadosDoProdutoDoFormulario();

                if (produtoACadastrar != null) {

                    ProdutoCtrl produtoCtrl = new ProdutoCtrl(ConexaoSQlite.getInstance(ActivityProduto.this));
                    long idProduto = produtoCtrl.salvarProdutoCtrl(produtoACadastrar);

                    if (idProduto > 0) {
                        Toast.makeText(ActivityProduto.this, "Produto salvo com sucesso", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ActivityProduto.this, "Produto não pode ser salvo", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(ActivityProduto.this, "Todos os campos são obrigatórios", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    private Produto getDadosDoProdutoDoFormulario() {

        this.produto = new Produto();

        if (!txtIdProduto.getText().toString().isEmpty()) {
            this.produto.setId(Long.parseLong(this.txtIdProduto.getText().toString()));
        } else {
            return null;
        }
        if (!this.txtNomeProduto.getText().toString().isEmpty()) {
            this.produto.setNome(this.txtNomeProduto.getText().toString());
        } else {
            return null;
        }
        if (!this.txtQtdeProduto.getText().toString().isEmpty()) {

            int quantidadeProduto = Integer.parseInt(this.txtQtdeProduto.getText().toString());

            this.produto.setQuantidadeEmEstoque(quantidadeProduto);
        } else {
            return null;
        }
        if (!this.txtPrecoProduto.getText().toString().isEmpty()) {

            double precoProduto = Double.parseDouble(this.txtPrecoProduto.getText().toString());

            this.produto.setPreco(precoProduto);

        } else {
            return null;
        }

        return produto;

    }

}
