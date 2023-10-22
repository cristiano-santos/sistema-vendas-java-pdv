package controller;

import DAO.DaoProduto;
import java.util.ArrayList;
import model.ModelProduto;

/**
 *
 * @author crist
 */
public class ControllerProduto {
    
    private DaoProduto daoProduto = new DaoProduto();
    
    public int salvarProdutoController(ModelProduto pModelProduto){
        return this.daoProduto.salvarProdutoDAO(pModelProduto);
    }
    
    public boolean excluirProdutoController(int pCodigo){
        return this.daoProduto.excluirProdutoDAO(pCodigo);
    }
    
    public boolean alterarProdutoController(ModelProduto pModelProduto){
        return this.daoProduto.alterarProdutoDAO(pModelProduto);
    }
    
    public ModelProduto retornarProdutoController(int pCodigo){
        return this.daoProduto.retornarProdutoDAO(pCodigo);
    }
    
    public ArrayList<ModelProduto> retornarListaProdutoController(){
        return this.daoProduto.retornarListaProdutoDAO();
    }
}
