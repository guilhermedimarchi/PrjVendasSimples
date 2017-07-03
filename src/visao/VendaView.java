package visao;

import java.util.List;

import javax.faces.bean.ManagedBean;

import negocio.VendaBusiness;
import modelo.Venda;


@ManagedBean
public class VendaView {
	
	private Venda venda = new Venda();
	private double total=0;
	

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public void salvar()
	{
		VendaBusiness vb = new VendaBusiness();
		total = total + venda.getValor();
		vb.salvar(venda);
	}
	public void atualizar()
	{
		VendaBusiness vb = new VendaBusiness();
		vb.atualizar(venda);
	}
	public List <Venda> getAllVendas()
	{
		VendaBusiness vb = new VendaBusiness();
		return vb.getVendas();
	}
	public void deletar()
	{
		VendaBusiness vb = new VendaBusiness();
		total -= venda.getValor();
		vb.deletar(venda);
	}
	
	public void deletar(int numero)
	{
		VendaBusiness vb = new VendaBusiness();
		total -= venda.getValor();
		vb.deletar(numero);
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	

}
