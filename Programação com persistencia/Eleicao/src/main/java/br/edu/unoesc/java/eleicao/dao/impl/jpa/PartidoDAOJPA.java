package br.edu.unoesc.java.eleicao.dao.impl.jpa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unoesc.java.eleicao.dao.PartidoDAO;
import br.edu.unoesc.java.eleicao.model.Partido;

/**
 * @author rober
 *
 */
public class PartidoDAOJPA extends BaseDAOJpa implements PartidoDAO {

	@Override
	public boolean salvar(final Partido partido) {
		try {
	
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean excluir(final Partido partido) {
		try {
			pstmt = Conexao.getConnection().prepareStatement("delete from cidade where codpar = ?");
			pstmt.setInt(1, partido.getCodigo());
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Partido> listar() {
		try {
			ArrayList<Partido> partidos = null;
			Partido partido = null;
			pstmt = Conexao.getConnection().prepareStatement("select * from partido order by nompar");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				partidos = new ArrayList<Partido>();
				do {
					partido = new Partido();
					// preciso construir o objeto
					partido.setCodigo(rs.getInt("codpar"));
					partido.setNome(rs.getString("nompar"));
					partido.setSigla(rs.getString("sigpar"));
					partidos.add(partido);
				} while (rs.next());
			}
			rs.close();
			pstmt.close();
			return partidos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Partido> listarPorNome(String nome) {
		try {
			ArrayList<Partido> partidos = null;
			Partido partido = null;
			pstmt = Conexao.getConnection().prepareStatement("select * from partido where nompar like ? order by nompar");
			pstmt.setString(0, '%' + nome + '%');
			rs = pstmt.executeQuery();
			if (rs.next()) {
				partidos = new ArrayList<Partido>();
				do {
					partido = new Partido();
					// preciso reconstruir o objeto
					partido.setCodigo(rs.getInt("codpar"));
					partido.setNome(rs.getString("nompar"));
					partido.setSigla(rs.getString("sigpar"));
					partidos.add(partido);
				} while (rs.next());
			}
			rs.close();
			pstmt.close();
			return partidos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
