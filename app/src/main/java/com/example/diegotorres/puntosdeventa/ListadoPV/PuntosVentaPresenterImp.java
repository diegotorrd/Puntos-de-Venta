package com.example.diegotorres.puntosdeventa.ListadoPV;

import com.example.diegotorres.puntosdeventa.bd.BD_OpenHelper;

import java.util.List;

/**
 * Created by Diego Torres on 12/07/2018.
 */

public class PuntosVentaPresenterImp implements PuntosVentaPresenter{
    private PuntosVentaView mView;

    public PuntosVentaPresenterImp(PuntosVentaView mView) {
        this.mView = mView;
    }

    @Override
    public void obtenerListaPVs(BD_OpenHelper openHelper) {
        List<String> ids = openHelper.getPlaceIDs();
        mView.listarPVs(ids);
    }
}
