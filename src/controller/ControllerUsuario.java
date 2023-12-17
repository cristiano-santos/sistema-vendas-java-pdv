package controller;

import DAO.DaoUsuario;
import java.util.ArrayList;
import model.ModelUsuario;

/**
 *
 * @author cristiano santos
 */
public class ControllerUsuario {

    private DaoUsuario daoUsuario = new DaoUsuario();

    public int salvarUsuarioController(ModelUsuario pModelUsuario) {
        return this.daoUsuario.salvarUsuarioDAO(pModelUsuario);
    }

    public boolean excluirUsuarioController(int pCodigo) {
        return this.daoUsuario.excluirUsuarioDAO(pCodigo);
    }

    public boolean alterarUsuarioController(ModelUsuario pModelUsuario) {
        return this.daoUsuario.alterarUsuarioDAO(pModelUsuario);
    }

    public ModelUsuario retornarUsuarioController(int pCodigo) {
        return this.daoUsuario.retornarUsuarioDAO(pCodigo);
    }

    public ArrayList<ModelUsuario> retornarListaUsuarioController() {
        return this.daoUsuario.retornarListaUsuarioDAO();
    }

    public boolean getValidarUsuarioController(ModelUsuario pModelUsuario) {
        return this.daoUsuario.getValidarUsuarioDAO(pModelUsuario);
    }

}
