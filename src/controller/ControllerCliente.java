package controller;

import DAO.DaoCliente;
import java.util.ArrayList;
import model.ModelCliente;

/**
 *
 * @author crist
 */
public class ControllerCliente {
    
    private DaoCliente daoCliente = new DaoCliente();
    
    public int salvarClienteController(ModelCliente pModelCliente){
        return this.daoCliente.salvarClienteDAO(pModelCliente);
    }
    
    public boolean excluirClienteController(int pCodigo){
        return this.daoCliente.excluirClienteDAO(pCodigo);
    }
    
    public boolean alterarClienteController(ModelCliente pModelCliente){
        return this.daoCliente.alterarClienteDAO(pModelCliente);
    }
    
    public ModelCliente retornarClienteController(int pCodigo){
        return this.daoCliente.retornarClienteDAO(pCodigo);
    }
    
    public ArrayList<ModelCliente> retornarListaClienteController(){
        return this.daoCliente.retornarListaClienteDAO();
    }
    
}
