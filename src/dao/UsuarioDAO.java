package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.ConnectFactory;
import model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    //PRA CADA TABELA DO BD VAI TER QUE TER UMA CLASSE DAO
    private Connection con;

    public UsuarioDAO() {
        //O ATRIBUTO CON VAI RECEBER UMA NOVA CONEXÃO COM O BD
        this.con = new ConnectFactory().getConnection();
    }

    //CADASTRAR USUARIO
    public void cadastrarUsuario(Usuario a) {
        //CRIAR O COMANDO SQL
        String sql = "insert into cadUsuarios(nome,senha) "
                + "values(?,?)";

        try ( //CONECTAR O BD E ORGANIZAR O COMANDO SQL
                 PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, a.getUsuario());
            ps.setString(2, a.getSenha());

            //EXECUTAR O COMANDO SQL
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados: " + e);
        }
    }

    //Procurar usuario
    public List<Usuario> procurarUsuario(String nome) {
        try {
            List<Usuario> lista = new ArrayList<>();
            String sql = "select nome from cadUsuarios where nome like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setUsuario(sql);
                lista.add(user);
            }
            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o usuario no BD: " + e);
            return null;
        }
    }

    //Validar usuario e senha
    public List<Usuario> validarUsuarioSenha(String nome, String senha) {
        try {
            List<Usuario> lista = new ArrayList<>();
            String sql = "select nome, senha from cadUsuarios where nome = ? and senha = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, md5(senha)); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setUsuario(rs.getString("nome"));
                user.setSenha(rs.getString("senha"));
                lista.add(user);
            }
            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o usuario no BD: " + e);
            return null;
        }
    }

    //Criptografar uma senha para compara-la no BD
    public static String md5(String senha) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(senha.getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

}
