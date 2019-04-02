package br.com.senai.produtos.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.produtos.R;
import br.com.senai.produtos.adapters.AdapterListaProdutos;
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

        Produto produto = new Produto();
        produto.setId(3552);
        produto.setNome("Guaraná");
        produto.setPreco(2);
        produto.setQuantidadeEmEstoque(100);

        this.produtoList = new ArrayList<>();

        this.produtoList.add(produto);
        this.produtoList.add(produto);
        this.produtoList.add(produto);
        this.produtoList.add(produto);
        this.produtoList.add(produto);
        this.produtoList.add(produto);
        this.produtoList.add(produto);
        this.produtoList.add(produto);

        this.listViewProdutos = (ListView) findViewById(R.id.listViewProdutos);

        this.adapterListaProdutos = new AdapterListaProdutos(ListarProdutosActivity.this, this.produtoList);

        this.listViewProdutos.setAdapter(this.adapterListaProdutos);

    }
}
