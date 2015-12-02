package br.com.senai.ftv.dao;

public class DAOFactory {

	private static ProdutoDAO produtoDAO;
	
	private DAOFactory(){}
	
	public static ProdutoDAO getProdutoDAO() {
		produtoDAO = produtoDAO != null ? produtoDAO : new ProdutoDAOImpl();
		return produtoDAO;
	}
}
