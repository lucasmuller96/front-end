package br.edu.unoesc.java.eleicao.dao.impl.jdbc;

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
public class PartidoDAOJdbc implements PartidoDAO {
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

	@Override
	public boolean salvar(final Partido partido) {
		try {
			partido.setCodigo(Conexao.getAutoInc("partido"));
			pstmt = Conexao.getConnection()
					.prepareStatement("insert into partido(codpar, nompar, sigpar) values(?,?,?)");
			// preciso desmembrar o objeto
			pstmt.setInt(1, partido.getCodigo());
			pstmt.setString(2, partido.getNome());
			pstmt.setString(3, partido.getSigla());
			pstmt.executeUpdate();
			pstmt.close();
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
