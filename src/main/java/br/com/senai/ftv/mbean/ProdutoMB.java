package br.com.senai.ftv.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.senai.ftv.dao.DAOFactory;
import br.com.senai.ftv.dao.ProdutoDAO;
import br.com.senai.ftv.modelo.Produto;

@ManagedBean
@ViewScoped
public class ProdutoMB {

	private Produto produto;
	private List<Produto> listaProduto;
	private ProdutoDAO produtoDAO;

	@PostConstruct
	public void iniciaProduto() {
		produtoDAO = DAOFactory.getProdutoDAO();
		produto = new Produto();
		listaProduto = new ArrayList<Produto>();
		listaProduto = produtoDAO.buscarTodos(produto);

	}

	public String salvar() {
		produtoDAO.salvar(produto);

		produto = new Produto();
		criaProduto();
		listaProduto = produtoDAO.buscarTodos(produto);
		return "";
	}

	public void criaProduto() {
		produto = new Produto();
	}

	public String excluir() {
		produtoDAO.excluir(produto);
		criaProduto();
		listaProduto = produtoDAO.buscarTodos(produto);
		return "";
	}

	public String pesquisar() {
		produtoDAO.buscarTodos(produto);
		return "";
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

}
