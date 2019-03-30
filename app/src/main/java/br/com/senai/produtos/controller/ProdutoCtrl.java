package br.com.senai.produtos.controller;

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

}
