package br.com.senai.produtos.DAO;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import br.com.senai.produtos.dbhelper.ConexaoSQlite;
import br.com.senai.produtos.model.Produto;

public class ProdutoDAO {

    private final ConexaoSQlite conexaoSQlite;

    public ProdutoDAO(ConexaoSQlite conexaoSQlite) {
        this.conexaoSQlite = null;
    }

    public long salvarProdutoDAO(Produto produto) {

        // Faça uma conexão no BD que eu possa escrever
        SQLiteDatabase db = conexaoSQlite.getWritableDatabase();

        try {

            // Classe com conjunto chave/valor
            ContentValues values = new ContentValues();
            values.put("id", produto.getId());
            values.put("quantidade_em_estoque", produto.getQuantidadeEmEstoque());
            values.put("preco", produto.getPreco());

            long id = db.insert("produto", null, values);

            return id;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;

    }

}
