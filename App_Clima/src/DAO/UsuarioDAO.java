package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection conn;

    public ResultSet autenticacaoUsuario(UsuarioDTO objusuariodto) {
        conn = new ConecSQL().conectaBD();

        try {
            String sql = "select * from usuario where nome_usuario = ? and senha_usuario = ?";

            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome_usuario());
            pstm.setString(2, objusuariodto.getSenha_usuario());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO (autenticação): " + error);
            return null;
        }

    }

    public void cadastrarUsuario(UsuarioDTO objusuariodto) {
        PreparedStatement pstm;
        String sql = "insert into usuario (nome_usuario,senha_usuario) values (?,?)";

        conn = new ConecSQL().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getCriar_nome_usuario());
            pstm.setString(2, objusuariodto.getCriar_senha_usuario());

            pstm.execute();
            pstm.close();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO (cadastrar)" + error);
        }
    }
    
    
    public ResultSet checarUsuarioExistente(UsuarioDTO objusuariodto) {
        conn = new ConecSQL().conectaBD();
        
        try {
            String sql = "select * from usuario where nome_usuario = ?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getCriar_nome_usuario());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO (checagem): " + error);
            return null;
        }
    }
}
