package br.com.senai.produtos.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

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
        } finally {
            if (db != null) {
                db.close();
            }
        }

        return 0;

    }

    public List<Produto> getListaProdutosDAO() {
        List<Produto> listProdutos = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String query = "SELECT * FROM produto";

        try {

            // Leitura do BD
            db = this.conexaoSQlite.getReadableDatabase();

            cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()) {

                Produto produtoTemporario = null;

                do {

                    produtoTemporario = new Produto();
                    produtoTemporario.setId(cursor.getLong(0));
                    produtoTemporario.setNome(cursor.getString(1));
                    produtoTemporario.setQuantidadeEmEstoque(cursor.getInt(2));
                    produtoTemporario.setPreco(cursor.getDouble(3));

                    listProdutos.add(produtoTemporario);

                } while (cursor.moveToNext());

            }

        } catch (Exception e) {

            Log.d("Erro Lista de Produtos", "Erro ao retornar os produtos");
            return null;

        } finally {
            if (db != null) {
                db.close();
            }
        }

        return listProdutos;

    }

    public boolean excluirProdutoDAO(long idProduto) {
        SQLiteDatabase db = null;

        try {

            db = this.conexaoSQlite.getWritableDatabase();

            db.delete(
                    "produto",
                    "id = ?",
                    new String[]{String.valueOf(idProduto)}
            );

        }catch (Exception e) {

            Log.d("ProdutoDAO", "Nâo foi possível deletar o produto");
            return false;

        } finally {
            if (db != null) {
                db.close();
            }
        }

        return true;
    }

}
