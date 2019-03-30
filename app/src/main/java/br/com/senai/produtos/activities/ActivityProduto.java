package br.com.senai.produtos.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import br.com.senai.produtos.R;
import br.com.senai.produtos.model.Produto;

public class ActivityProduto extends AppCompatActivity {

    private EditText txtNomeProduto;
    private EditText txtQtdeProduto;
    private EditText txtPrecoProduto;

    private Button btnSalvarProduto;

    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        txtNomeProduto = (EditText) findViewById(R.id.txtNomeProduto);
        txtQtdeProduto = (EditText) findViewById(R.id.txtQtdeProduto);
        txtPrecoProduto = (EditText) findViewById(R.id.txtPrecoProduto);

        btnSalvarProduto = (Button) findViewById(R.id.btnSalvarProduto);

    }

    private Produto getDadosDoProdutoDoFormulario() {

        this.produto = new Produto();

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
