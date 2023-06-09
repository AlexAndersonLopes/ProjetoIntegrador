package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.ConnectFactory;
import model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.Mensagens;

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
        String sql = "insert into cadUsuarios(nome, cpf, email, senha) "
                + "values(?,?,?,?)";

        try ( //CONECTAR O BD E ORGANIZAR O COMANDO SQL
                 PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, a.getUsuario());
            ps.setString(2, a.getCpf());
            ps.setString(3, a.getEmail());
            ps.setString(4, a.getSenha());

            //EXECUTAR O COMANDO SQL
            ps.execute();
            ps.close();
            Mensagens.mensagemExito("Usuario cadastrado com sucesso!!!");
        } catch (SQLException e) {
            Mensagens.mensagemErro("Erro ao salvar no banco de dados");
        }
    }

    //Procurar usuario
    public List<Usuario> procurarUsuarios(String cpf, String nome) {
        try {
            List<Usuario> lista = new ArrayList<>();
            String sql = "SELECT * FROM cadUsuarios WHERE cpf LIKE ? OR nome LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + cpf + "%");
            ps.setString(2, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setCpf(rs.getString("cpf"));
                user.setUsuario(rs.getString("nome"));
                lista.add(user);
            }
            return lista;
        } catch (SQLException e) {
            Mensagens.mensagemErro("Erro ao buscar os usuários no BD");
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
                if (rs.getString("nome").equals(nome) && rs.getString("senha").equals(md5(senha))) {
                    user.setUsuario(rs.getString("nome"));
                    user.setSenha(rs.getString("senha"));
                    lista.add(user);
                }
            }
            return lista;

        } catch (NoSuchAlgorithmException | SQLException e) {
            Mensagens.mensagemErro("Erro ao buscar o usuario no BD");
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

    //Procurar usuario
    public Usuario mostrarFuncionario(String nome) {
        try {
            Usuario usuario = new Usuario();
            String sql = "select * from cadUsuarios where nome like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
            }
            return usuario;

        } catch (SQLException e) {
            Mensagens.mensagemErro("Erro ao encontrar o usuario no BD");
            return null;
        }
    }
    
    //Mostrar todos usuarios cadastrados
    public List<Usuario> procurarTodosUsuarios() {
    try {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM cadUsuarios";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Usuario user = new Usuario();
            user.setUsuario(rs.getString("nome"));
            lista.add(user);
        }
        return lista;
    } catch (SQLException e) {
        Mensagens.mensagemErro("Erro ao buscar os usuários no BD");
        return null;
    }
}

}
