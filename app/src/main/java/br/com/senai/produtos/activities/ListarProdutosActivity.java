package br.com.senai.produtos.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.produtos.R;
import br.com.senai.produtos.adapters.AdapterListaProdutos;
import br.com.senai.produtos.controller.ProdutoCtrl;
import br.com.senai.produtos.dbhelper.ConexaoSQlite;
import br.com.senai.produtos.model.Produto;

public class ListarProdutosActivity extends AppCompatActivity {

    private ListView listViewProdutos;
    private List<Produto> produtoList;
    private AdapterListaProdutos adapterListaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);

        // Buscar os produtos do banco
        ProdutoCtrl produtoCtrl = new ProdutoCtrl(ConexaoSQlite.getInstance(ListarProdutosActivity.this));
        produtoList = produtoCtrl.getListaProdutosCtrl();

        this.produtoList = new ArrayList<>();

        this.adapterListaProdutos = new AdapterListaProdutos(ListarProdutosActivity.this, this.produtoList);

        this.listViewProdutos.setAdapter(this.adapterListaProdutos);

    }
}
