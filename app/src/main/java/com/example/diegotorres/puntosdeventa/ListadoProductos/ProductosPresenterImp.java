package com.example.diegotorres.puntosdeventa.ListadoProductos;

import com.example.diegotorres.puntosdeventa.Beans.Producto;
import com.example.diegotorres.puntosdeventa.bd.BD_OpenHelper;

import java.util.List;

/**
 * Created by Diego Torres on 13/07/2018.
 */

public class ProductosPresenterImp implements ProductosPresenter{
    private ProductosView mView;

    public ProductosPresenterImp(ProductosView mView) {
        this.mView = mView;
    }

    @Override
    public void obtenerProductos(String placeID, BD_OpenHelper openHelper) {
        List<Producto> productos= openHelper.getProductosByPlace(placeID);
        mView.listarProductos(productos);
    }

    @Override
    public void actualizarStock(String placeID, int productoID, int stock, BD_OpenHelper openHelper) {
        int res = openHelper.updateStock(placeID, productoID, stock);
        mView.actualizarStock(res);
    }
}
