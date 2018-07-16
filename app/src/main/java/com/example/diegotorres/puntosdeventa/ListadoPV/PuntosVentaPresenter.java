package com.example.diegotorres.puntosdeventa.ListadoPV;

import com.example.diegotorres.puntosdeventa.bd.BD_OpenHelper;

/**
 * Created by Diego Torres on 12/07/2018.
 */

public interface PuntosVentaPresenter {
    public void obtenerListaPVs(BD_OpenHelper openHelper);
}
