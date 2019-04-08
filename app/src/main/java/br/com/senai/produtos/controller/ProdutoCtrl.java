package br.com.senai.produtos.controller;

import java.util.List;

import br.com.senai.produtos.DAO.ProdutoDAO;
import br.com.senai.produtos.dbhelper.ConexaoSQlite;
import br.com.senai.produtos.model.Produto;

public class ProdutoCtrl {


    private final ProdutoDAO produtoDAO;

    public ProdutoCtrl(ConexaoSQlite conexaoSQlite) {
        produtoDAO = new ProdutoDAO(conexaoSQlite);
    }

    public long salvarProdutoCtrl(Produto produto) {
        return this.produtoDAO.salvarProdutoDAO(produto);
    }

    public List<Produto> getListaProdutosCtrl() {
        return this.produtoDAO.getListaProdutosDAO();
    }

    public boolean excluirProdutoCtrl(long idProduto) {
        return this.produtoDAO.excluirProdutoDAO(idProduto);
    }

}
