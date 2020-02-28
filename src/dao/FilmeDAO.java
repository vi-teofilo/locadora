package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import model.Filme;

public class FilmeDAO {

	private Connection bd;

	public FilmeDAO(Connection bd) {
		this.bd = bd;
	}

	public void inserir(Filme Filme) throws SQLException {
//		responsavel por inserir os dados 
//		prepareSta ele puxa as info
		String sql = "INSERT INTO Filme (codigo,nome,gereno,valor,disponivel,promocao,valor_promocao)VALUES (?,?,?,?,?,?,?)";
		PreparedStatement comando = bd.prepareStatement(sql);
		comando.setInt(1, Filme.getCodigo());
		comando.setString(2, Filme.getNome());
		comando.setString(3, Filme.getGenero());
		comando.setDouble(4, Filme.getValor());
		comando.setBoolean(5, Filme.isDisponivel());
		comando.setBoolean(6, Filme.isPromocao());
		comando.setDouble(7, Filme.getValorPromocao());
		comando.execute();

	}
//metodo para alterar do banco de dados
	public void alterar(Filme filme) throws SQLException {
		String sql = "UPDATE Filme SET idade=?, cidade=? WHERE nome=?";
		PreparedStatement comando = bd.prepareStatement(sql);
		comando.setInt(1, filme.getIdade());
		comando.setString(2, filme.getCidade());
		comando.setString(3, filme.getNome());
		comando.execute();

	}
//metodo para excluir do banco de dados 
	public void excluir(Filme filme) throws SQLException {
		String sql = "DELETE FROM Filme WHERE nome=?";
		PreparedStatement comando = bd.prepareStatement(sql);
		comando.setString(1, Filme.getNome());
		comando.execute();

	}
//listar todos os Filmes
	public List<Filme> buscarTodos() throws SQLException {
		String sql= "SELECT * FROM Filme ORDER BY nome";
		PreparedStatement comando = bd.prepareStatement(sql);
		ResultSet cursor = comando.executeQuery();
		List<Filme> listaFilmes = new ArrayList<Filme>();
		
		while (cursor.next()) {
			Filme Filme = new Filme();
			Filme.setNome(cursor.getString("nome"));
			Filme.setCidade(cursor.getString("cidade"));
			Filme.setIdade(cursor.getInt("idade"));
			listaFilmes.add(Filme);
					
		}
					
		return listaFilmes;
		
	}
	
	
	
	
	
	
	
}
