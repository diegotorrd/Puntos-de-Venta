package com.example.diegotorres.puntosdeventa.Login;

import com.example.diegotorres.puntosdeventa.Beans.Usuario;
import com.example.diegotorres.puntosdeventa.bd.BD_OpenHelper;

/**
 * Created by Diego Torres on 11/07/2018.
 */

public class LoginPresenterImp implements LoginPresenter {
    private LoginView mView;

    public LoginPresenterImp(LoginView mView) {
        this.mView = mView;
    }

    @Override
    public void obtenerLogin(String usuario, String contraseña, BD_OpenHelper openHelper) {
        Usuario usu = new Usuario();
        usu = openHelper.consultarUsuario(usuario, contraseña);

        mView.callActivity(usu);
    }
}
