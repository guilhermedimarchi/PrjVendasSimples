package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Venda;

public class VendaDAO {

	public void persist(Venda venda) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prova1GuilhermeDimarchi132173");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(venda);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public List<Venda> getAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prova1GuilhermeDimarchi132173");
		EntityManager em = emf.createEntityManager();
		List <Venda> vendas = em.createQuery("SELECT a FROM Venda a", Venda.class).getResultList();
		em.close();
		emf.close();
		return vendas;
	}

	public void atualizar(Venda venda) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prova1GuilhermeDimarchi132173");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(venda);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

	public void deletar(Venda venda) {
		
		try{
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			String url = "jdbc:derby://localhost:1527/meubd;create=true";
			String user = "app";
			String pwd = "app";
			
			Connection con = DriverManager.getConnection(url,user,pwd);
			String sql = "DELETE FROM Venda where numero = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, venda.getNumero());
			stmt.executeUpdate();
			stmt.close();
			con.close();
		}catch( ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void deletar(int numero) {
			
			try{
				Class.forName("org.apache.derby.jdbc.ClientDriver");
				String url = "jdbc:derby://localhost:1527/meubd;create=true";
				String user = "app";
				String pwd = "app";
				
				Connection con = DriverManager.getConnection(url,user,pwd);
				String sql = "DELETE FROM Venda where numero = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, numero);
				stmt.executeUpdate();
				stmt.close();
				con.close();
			}catch( ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

}
