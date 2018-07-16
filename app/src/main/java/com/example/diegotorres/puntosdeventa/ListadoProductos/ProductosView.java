package com.example.diegotorres.puntosdeventa.ListadoProductos;

import com.example.diegotorres.puntosdeventa.Beans.Producto;

import java.util.List;

/**
 * Created by Diego Torres on 13/07/2018.
 */

public interface ProductosView {
    public void setPresenter(ProductosPresenter presenter);
    public void listarProductos(List<Producto> productos);
    public void actualizarStock(int rows);
}
