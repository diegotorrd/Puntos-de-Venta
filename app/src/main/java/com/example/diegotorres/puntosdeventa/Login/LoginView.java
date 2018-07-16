package com.example.diegotorres.puntosdeventa.Login;

import com.example.diegotorres.puntosdeventa.Beans.Usuario;

/**
 * Created by Diego Torres on 11/07/2018.
 */

public interface LoginView {
    public void setPresenter(LoginPresenter presenter);
    public void callActivity(Usuario usuario);
}
