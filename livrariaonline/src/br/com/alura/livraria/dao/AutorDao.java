package br.com.alura.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.result.LocalDateTimeValueFactory;
import com.mysql.cj.result.LocalDateValueFactory;

import br.com.alura.livraria.modelo.Autor;

public class AutorDao {
	
	private Connection conexao;
	
	public AutorDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void cadastrar(Autor autor) {
		
		try {
			
			String sql = "insert into autores (nome, email, dtnascimento, minicurriculo) values(?, ? ,?, ?)";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, autor.getNome());
			ps.setString(2, autor.getEmail());
			ps.setDate(3, Date.valueOf(autor.getData()));
			ps.setString(4, autor.getCurriculo());
			
			ps.execute();
			
					
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	@SuppressWarnings("static-access")
	public List<Autor> listar(){
		
		try {
			
			SimpleDateFormat dtfm = new SimpleDateFormat("dd/MM/yyyy");
			
			String sql = "select * from autores";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<Autor>autores = new ArrayList<>();
			
			while(rs.next()) {
				Autor a = new Autor();
				
				a.setNome(rs.getString("nome"));
				a.setEmail(rs.getString("email"));
				a.setData(rs.getDate("dtnascimento").toLocalDate());
				
				autores.add(a);
			}
			return autores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
