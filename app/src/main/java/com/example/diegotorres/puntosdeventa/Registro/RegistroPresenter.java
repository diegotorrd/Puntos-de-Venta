package com.example.diegotorres.puntosdeventa.Registro;

import com.example.diegotorres.puntosdeventa.Beans.Usuario;
import com.example.diegotorres.puntosdeventa.bd.BD_OpenHelper;

/**
 * Created by Diego Torres on 11/07/2018.
 */

public interface RegistroPresenter {
    public void registrarUsuario(Usuario usuario, BD_OpenHelper openHelper);
}
