package br.com.senai.produtos.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

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
        final ProdutoCtrl produtoCtrl = new ProdutoCtrl(ConexaoSQlite.getInstance(ListarProdutosActivity.this));
        produtoList = produtoCtrl.getListaProdutosCtrl();

        this.produtoList = new ArrayList<>();

        this.adapterListaProdutos = new AdapterListaProdutos(ListarProdutosActivity.this, this.produtoList);

        this.listViewProdutos.setAdapter(this.adapterListaProdutos);

        this.listViewProdutos.setOnClickListener(new OnItemClickListener() {

            // Método que implementa um modal de escolhas para o usuário
            // Com os botôes editar, excluir e cancelar
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                final Produto produtoSelecionado = (Produto) adapterListaProdutos.getItem(position);

                AlertDialog.Builder janelaDeEscolha = new AlertDialog.Builder(ListarProdutosActivity.this);

                janelaDeEscolha.setTitle("Escolha: ");
                janelaDeEscolha.setMessage("O que deseja fazer com o produto selecionado? ");

                janelaDeEscolha.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                janelaDeEscolha.setNegativeButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        boolean excluiu = produtoCtrl.excluirProdutoCtrl(produtoSelecionado.getId());

                        dialog.cancel();

                        if (excluiu) {
                            Toast.makeText(ListarProdutosActivity.this,"Produto excluído com sucesso", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(ListarProdutosActivity.this,"Erro ao excluir o produto", Toast.LENGTH_LONG).show();
                        }

                    }
                });

                janelaDeEscolha.setPositiveButton("Editar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                janelaDeEscolha.create().show();

                //Toast.makeText(ListarProdutosActivity.this, "Produto: " + produtoSelecionado.getNome(), Toast.LENGTH_LONG).show();

            }
        });

    }
}
