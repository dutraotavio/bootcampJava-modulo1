package br.com.otavio.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;
import com.mysql.cj.xdevapi.Statement;

import br.com.otavio.livraria.model.Cadastro;

public class CadastroDao {

	private Connection conexao;

	public CadastroDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void cadastrar(Cadastro cadastro) {
		try {
			String sql = "insert into registros(nome, email, dataDeNascimento, curriculo) values(?, ?, ?, ?)";

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, cadastro.getNome());
			ps.setString(2, cadastro.getEmail());
			ps.setString(3, cadastro.getDataDeNascimento());
			ps.setString(4, cadastro.getCurriculo());

			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Cadastro> listar() {
		try {
			String sql = "select * from registros";

			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			List<Cadastro> cadastros = new ArrayList<>();

			while (rs.next()) {
				Cadastro c = new Cadastro();

				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setDataDeNascimento(rs.getString("dataDeNascimento"));
				c.setCurriculo(rs.getString("curriculo"));

				cadastros.add(c);
			}
			return cadastros;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
