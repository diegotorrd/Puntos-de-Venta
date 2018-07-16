package com.example.diegotorres.puntosdeventa.Login;

import com.example.diegotorres.puntosdeventa.Beans.Usuario;
import com.example.diegotorres.puntosdeventa.bd.BD_OpenHelper;

/**
 * Created by Diego Torres on 11/07/2018.
 */

public interface LoginPresenter {
    public void obtenerLogin(String usuario, String contraseña, BD_OpenHelper openHelper);
}
