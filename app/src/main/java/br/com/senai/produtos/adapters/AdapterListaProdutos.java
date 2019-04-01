package br.com.senai.produtos.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import br.com.senai.produtos.R;
import br.com.senai.produtos.model.Produto;

public class AdapterListaProdutos extends BaseAdapter {

    private Context context;
    private List<Produto> listProdutos;

    public AdapterListaProdutos(Context context, List<Produto> listProdutos) {
        this.context = context;
        this.listProdutos = listProdutos;
    }

    @Override
    public int getCount() {
        return this.listProdutos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listProdutos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = View.inflate(this.context, R.layout.activity_layout_produto, null);

        return null;

    }
}
