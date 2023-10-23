package DAO;

import conexao.ConexaoMySql;
import java.util.ArrayList;
import model.ModelProduto;

/**
 *
 * @author cristiano santos
 */
public class DaoProduto extends ConexaoMySql {

    public int salvarProdutoDAO(ModelProduto pModelProduto) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_produto ("
                    + "prod_nome,"
                    + "prod_valor,"
                    + "prod_estoque"
                    + ") VALUES ("
                    + "'" + pModelProduto.getProdNome() + "',"
                    + "'" + pModelProduto.getProdValor() + "',"
                    + "'" + pModelProduto.getProdEstoque() + "'"
                    + ")"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean excluirProdutoDAO(int pIdProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_produto WHERE pk_id_produto = '" + pIdProduto + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean alterarProdutoDAO(ModelProduto pModelProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_produto SET "
                    + "prod_nome = '" + pModelProduto.getProdNome() + "',"
                    + "prod_valor = '" + pModelProduto.getProdValor() + "',"
                    + "prod_estoque = '" + pModelProduto.getProdEstoque() + "'"
                    + "WHERE pk_id_produto = '" + pModelProduto.getIdProduto() + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ModelProduto retornarProdutoDAO(int pIdProduto) {
        ModelProduto modelProduto = new ModelProduto();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_produto, "
                    + "prod_nome, "
                    + "prod_valor, "
                    + "prod_estoque "
                    + "FROM tbl_produto WHERE pk_id_produto = '" + pIdProduto + "'"
            );

            while (this.getResultSet().next()) {
                modelProduto.setIdProduto(this.getResultSet().getInt(1));
                modelProduto.setProdNome(this.getResultSet().getString(2));
                modelProduto.setProdValor(this.getResultSet().getDouble(3));
                modelProduto.setProdEstoque(this.getResultSet().getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProduto;
    }

    public ArrayList<ModelProduto> retornarListaProdutoDAO() {
        ArrayList<ModelProduto> listaModelProduto = new ArrayList<>();
        ModelProduto modelProduto = new ModelProduto();

        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_produto, "
                    + "prod_nome, "
                    + "prod_valor, "
                    + "prod_estoque "
                    + "FROM tbl_produto"
            );

            while (this.getResultSet().next()) {
                modelProduto = new ModelProduto();
                modelProduto.setIdProduto(this.getResultSet().getInt(1));
                modelProduto.setProdNome(this.getResultSet().getString(2));
                modelProduto.setProdValor(this.getResultSet().getDouble(3));
                modelProduto.setProdEstoque(this.getResultSet().getInt(4));
                listaModelProduto.add(modelProduto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelProduto;
    }

}
