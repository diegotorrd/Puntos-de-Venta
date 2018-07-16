package com.example.diegotorres.puntosdeventa.ListadoProductos;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diegotorres.puntosdeventa.Adapter.ProductosAdapter;
import com.example.diegotorres.puntosdeventa.Beans.Producto;
import com.example.diegotorres.puntosdeventa.R;
import com.example.diegotorres.puntosdeventa.bd.BD_OpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ProductosActivity extends AppCompatActivity implements ProductosView {
    private ProductosPresenter mPresenter;
    private ProductosAdapter mAdapter;
    private BD_OpenHelper mOpenHelper;
    private String mPlaceId;
    private ListView mListViewProductos;
    private List<Producto> mProductos;
    private Context mContext;
    private AlertDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        mListViewProductos = (ListView) findViewById(R.id.list_productos);
        mPlaceId = getIntent().getStringExtra("placeId").toString();
        mProductos = new ArrayList<>();
        mContext = this;

        mOpenHelper = new BD_OpenHelper(this);
        setPresenter(new ProductosPresenterImp(this));
        mPresenter.obtenerProductos(mPlaceId, mOpenHelper);

        mListViewProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(mContext);
                View mView = getLayoutInflater().inflate(R.layout.dialog_stock, null);
                TextView txtProducto = (TextView) mView.findViewById(R.id.dlg_producto);
                TextView txtStock = (TextView) mView.findViewById(R.id.dlg_stock);
                final EditText eteStock = (EditText) mView.findViewById(R.id.dlg_edit_stock);
                Button btnStock = (Button) mView.findViewById(R.id.btn_confirmar_stock);

                txtProducto.setText("Producto: "+ mProductos.get(i).getDescripcion());
                txtStock.setText("Stok: " + mProductos.get(i).getStock());
                final int productoId = mProductos.get(i).getId();

                btnStock.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(eteStock.getText()==null){
                            mPresenter.actualizarStock(mPlaceId, productoId, 0, mOpenHelper);
                        }else{
                            mPresenter.actualizarStock(mPlaceId, productoId, Integer.parseInt(eteStock.getText().toString()), mOpenHelper);
                        }
                    }
                });

                mBuilder.setView(mView);
                mDialog = mBuilder.create();
                mDialog.show();
            }
        });

    }

    @Override
    public void setPresenter(ProductosPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void listarProductos(List<Producto> productos) {
        mProductos = productos;
        mAdapter = new ProductosAdapter(mProductos, this);
        mListViewProductos.setAdapter(mAdapter);
    }

    @Override
    public void actualizarStock(int rows) {
        if(rows>0){
            Toast.makeText(this, "Se actualizó el stock", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "No se realizó la actualización del stock", Toast.LENGTH_LONG).show();
        }
        mDialog.dismiss();
        mPresenter.obtenerProductos(mPlaceId, mOpenHelper);
    }
}
