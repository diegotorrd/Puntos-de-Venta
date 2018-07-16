package com.example.diegotorres.puntosdeventa.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.diegotorres.puntosdeventa.Beans.Producto;
import com.example.diegotorres.puntosdeventa.R;

import java.util.List;

/**
 * Created by Diego Torres on 11/07/2018.
 */

public class ProductosAdapter extends BaseAdapter {

    private List<Producto> mProductos;
    private Context mContext;
    private LayoutInflater mInflater;
    private ViewHolder viewHolder;

    public ProductosAdapter(List<Producto> mProductos, Context mContext) {
        this.mProductos = mProductos;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mProductos.size();
    }

    @Override
    public Object getItem(int i) {
        return mProductos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mProductos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            viewHolder = new ViewHolder();
            view = mInflater.inflate(R.layout.producto_item, null);

            viewHolder.txt_desc = (TextView) view.findViewById(R.id.txt_desc_producto);
            viewHolder.txt_stock = (TextView) view.findViewById(R.id.txt_stock_producto);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Producto producto = mProductos.get(i);

        viewHolder.txt_desc.setText(producto.getDescripcion());
        viewHolder.txt_stock.setText("Stock: " + producto.getStock());

        return view;
    }


    class ViewHolder{
        TextView txt_desc;
        TextView txt_stock;
    }
}
