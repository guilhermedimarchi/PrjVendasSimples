package negocio;

import java.util.List;

import persistencia.VendaDAO;
import modelo.Venda;

public class VendaBusiness {

	public void salvar(Venda venda) {
		VendaDAO vd = new VendaDAO();
		vd.persist(venda);
	}
	public void atualizar(Venda venda) {
		VendaDAO vd = new VendaDAO();
		vd.atualizar(venda);
	}
	public List <Venda> getVendas() {
		VendaDAO vd = new VendaDAO();
		return vd.getAll();
	}

	public void deletar(Venda venda) {
		VendaDAO vd = new VendaDAO();
		vd.deletar(venda);
	}
	public void deletar(int numero) {
		VendaDAO vd = new VendaDAO();
		vd.deletar(numero);
	}

}
