
package model;

/**
 *
 * @author crist
 */
public class ModelProduto {
    
    private int idProduto;
    private String prodNome;
    private double prodValor;
    private int prodEstoque;

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the prodNome
     */
    public String getProdNome() {
        return prodNome;
    }

    /**
     * @param prodNome the prodNome to set
     */
    public void setProdNome(String prodNome) {
        this.prodNome = prodNome;
    }

    /**
     * @return the prodValor
     */
    public double getProdValor() {
        return prodValor;
    }

    /**
     * @param prodValor the prodValor to set
     */
    public void setProdValor(double prodValor) {
        this.prodValor = prodValor;
    }

    /**
     * @return the prodEstoque
     */
    public int getProdEstoque() {
        return prodEstoque;
    }

    /**
     * @param prodEstoque the prodEstoque to set
     */
    public void setProdEstoque(int prodEstoque) {
        this.prodEstoque = prodEstoque;
    }
    
    
}
