package com.example.diegotorres.puntosdeventa.Registro;

import android.content.ContentValues;

import com.example.diegotorres.puntosdeventa.Beans.Usuario;
import com.example.diegotorres.puntosdeventa.bd.BD_OpenHelper;
import com.example.diegotorres.puntosdeventa.bd.BD_contract;

/**
 * Created by Diego Torres on 11/07/2018.
 */

public class RegistroPresenterImpl implements RegistroPresenter{
    private RegistroView mView;

    public RegistroPresenterImpl(RegistroView mView) {
        this.mView = mView;
    }


    @Override
    public void registrarUsuario(Usuario usuario, BD_OpenHelper openHelper) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BD_contract.UsuarioEntry.COLUMN_USUARIO, usuario.getUsuario());
        contentValues.put(BD_contract.UsuarioEntry.COLUMN_CONTRASEÑA, usuario.getContraseña());
        contentValues.put(BD_contract.UsuarioEntry.COLUMN_NOMBRE, usuario.getNombre());
        contentValues.put(BD_contract.UsuarioEntry.COLUMN_AP_PATERNO, usuario.getAp_paterno());
        contentValues.put(BD_contract.UsuarioEntry.COLUMN_AP_MATERNO, usuario.getAp_materno());
        contentValues.put(BD_contract.UsuarioEntry.COLUMN_EMAIL, usuario.getEmail());

        long resp= openHelper.insertarRegistro(BD_contract.UsuarioEntry.TABLE_NAME, contentValues);

        mView.callActivity(resp);
    }
}
