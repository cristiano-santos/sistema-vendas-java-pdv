package DAO;

import conexao.ConexaoMySql;
import java.util.ArrayList;
import model.ModelUsuario;

/**
 *
 * @author cristiano santos
 */
public class DaoUsuario extends ConexaoMySql {

    /**
     *
     * @param pModelUsuario
     * @return
     */
    public int salvarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_usuario("
                    + "usu_nome,"
                    + "usu_login,"
                    + "usu_senha"
                    + ") VALUES ("
                    + "'" + pModelUsuario.getUsuNome() + "',"
                    + "'" + pModelUsuario.getUsuLogin() + "',"
                    + "'" + pModelUsuario.getUsuSenha() + "'"
                    + ")"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     *
     * @param pIdUsuario
     * @return
     */
    public boolean excluirUsuarioDAO(int pIdUsuario) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_usuario WHERE pk_id_usuario = '" + pIdUsuario + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     *
     * @param pModelUsuario
     * @return
     */
    public boolean alterarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbl_usuario SET "
                    + "usu_nome = '" + pModelUsuario.getUsuNome() + "',"
                    + "usu_login = '" + pModelUsuario.getUsuLogin() + "',"
                    + "usu_senha = '" + pModelUsuario.getUsuSenha() + "'"
                    + "WHERE pk_id_usuario = '" + pModelUsuario.getIdUsuario() + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     *
     * @param pIdUsuario
     * @return
     */
    public ModelUsuario retornarUsuarioDAO(int pIdUsuario) {
        ModelUsuario modelUsuario = new ModelUsuario();

        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_usuario, "
                    + "usu_nome, "
                    + "usu_login, "
                    + "usu_senha "
                    + "FROM tbl_usuario WHERE pk_id_usuario = '" + pIdUsuario + "'"
            );

            while (this.getResultSet().next()) {
                modelUsuario.setIdUsuario(this.getResultSet().getInt(1));
                modelUsuario.setUsuNome(this.getResultSet().getString(2));
                modelUsuario.setUsuLogin(this.getResultSet().getString(3));
                modelUsuario.setUsuSenha(this.getResultSet().getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelUsuario;
    }

    /**
     *
     * @return
     */
    public ArrayList<ModelUsuario> retornarListaUsuarioDAO() {
        ArrayList<ModelUsuario> listaModelUsuario = new ArrayList<>();
        ModelUsuario modelUsuario = new ModelUsuario();

        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_usuario, "
                    + "usu_nome, "
                    + "usu_login, "
                    + "usu_senha "
                    + "FROM tbl_usuario"
            );

            while (this.getResultSet().next()) {
                modelUsuario = new ModelUsuario();
                modelUsuario.setIdUsuario(this.getResultSet().getInt(1));
                modelUsuario.setUsuNome(this.getResultSet().getString(2));
                modelUsuario.setUsuLogin(this.getResultSet().getString(3));
                modelUsuario.setUsuSenha(this.getResultSet().getString(4));
                listaModelUsuario.add(modelUsuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelUsuario;
    }

    /**
     *
     * @param pModelUsuario
     * @return
     */
    public boolean getValidarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_usuario, "
                    + "usu_nome, "
                    + "usu_login, "
                    + "usu_senha "
                    + "FROM tbl_usuario WHERE usu_login = '" + pModelUsuario.getUsuLogin() + "' AND usu_senha = '" + pModelUsuario.getUsuSenha() + "'"
            );
            if (getResultSet().next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }
}
