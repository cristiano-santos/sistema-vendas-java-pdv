package DAO;

import conexao.ConexaoMySql;
import java.util.ArrayList;
import model.ModelCliente;

/**
 *
 * @author cristiano santos
 */
public class DaoCliente extends ConexaoMySql{
    
    public int salvarClienteDAO(ModelCliente pModelCliente){
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_cliente ("
                    + "cli_nome,"
                    + "cli_endereco,"
                    + "cli_bairro,"
                    + "cli_cidade,"
                    + "cli_uf,"
                    + "cli_cep,"
                    + "cli_telefone"
                    + ") VALUES ("
                    + "'" + pModelCliente.getCliNome() + "',"
                    + "'" + pModelCliente.getCliEndereco() + "',"
                    + "'" + pModelCliente.getCliBairro() + "',"
                    + "'" + pModelCliente.getCliCidade() + "',"
                    + "'" + pModelCliente.getCliUf() + "',"
                    + "'" + pModelCliente.getCliCep() + "',"
                    + "'" + pModelCliente.getCliTelefone() + "'"
                    + ")"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }
    
    public boolean excluirClienteDAO(int pIdCliente){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_cliente WHERE pk_id_cliente = '" + pIdCliente + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    
    public boolean alterarClienteDAO(ModelCliente pModelCliente){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_cliente SET "
                    + "cli_nome = '" + pModelCliente.getCliNome() + "',"
                    + "cli_endereco = '" + pModelCliente.getCliEndereco() + "',"
                    + "cli_bairro = '" + pModelCliente.getCliBairro() + "',"
                    + "cli_cidade = '" + pModelCliente.getCliCidade() + "',"
                    + "cli_uf = '" + pModelCliente.getCliUf() + "',"
                    + "cli_cep = '" + pModelCliente.getCliCep() + "',"
                    + "cli_telefone = '" + pModelCliente.getCliTelefone() + "'"
                    + "WHERE pk_id_cliente = '" + pModelCliente.getIdCliente() + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    
    public ModelCliente retornarClienteDAO(int pIdCliente){
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_cliente, "
                    + "cli_nome, "
                    + "cli_endereco, "
                    + "cli_bairro, "
                    + "cli_cidade, "
                    + "cli_uf, "
                    + "cli_cep, "
                    + "cli_telefone "
                    + "FROM tbl_cliente WHERE pk_id_cliente = '" + pIdCliente + "'"
            );
            
            while (this.getResultSet().next()) {
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                modelCliente.setCliEndereco(this.getResultSet().getString(3));
                modelCliente.setCliBairro(this.getResultSet().getString(4));
                modelCliente.setCliCidade(this.getResultSet().getString(5));
                modelCliente.setCliUf(this.getResultSet().getString(6));
                modelCliente.setCliCep(this.getResultSet().getString(7));
                modelCliente.setCliTelefone(this.getResultSet().getString(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCliente;
    }
    
    public ArrayList<ModelCliente> retornarListaClienteDAO(){
        ArrayList<ModelCliente> listaModelCliente = new ArrayList<>();
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_cliente, "
                    + "cli_nome, "
                    + "cli_endereco, "
                    + "cli_bairro, "
                    + "cli_cidade, "
                    + "cli_uf, "
                    + "cli_cep, "
                    + "cli_telefone "
                    + "FROM tbl_cliente"
            );
            
            while (this.getResultSet().next()) {
                modelCliente = new ModelCliente();
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                modelCliente.setCliEndereco(this.getResultSet().getString(3));
                modelCliente.setCliBairro(this.getResultSet().getString(4));
                modelCliente.setCliCidade(this.getResultSet().getString(5));
                modelCliente.setCliUf(this.getResultSet().getString(6));
                modelCliente.setCliCep(this.getResultSet().getString(7));
                modelCliente.setCliTelefone(this.getResultSet().getString(8));
                listaModelCliente.add(modelCliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listaModelCliente;
    }
}
