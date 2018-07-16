package com.example.diegotorres.puntosdeventa.ListadoProductos;

import com.example.diegotorres.puntosdeventa.Beans.Producto;
import com.example.diegotorres.puntosdeventa.bd.BD_OpenHelper;

import java.util.List;

/**
 * Created by Diego Torres on 13/07/2018.
 */

public interface ProductosPresenter {
    public void obtenerProductos(String placeID, BD_OpenHelper openHelper);
    public void actualizarStock(String placeID, int productoID, int stock, BD_OpenHelper openHelper);
}
