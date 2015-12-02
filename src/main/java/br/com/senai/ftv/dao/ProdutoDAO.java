package br.com.senai.ftv.dao;

import java.util.List;

import br.com.senai.ftv.modelo.Produto;

public interface ProdutoDAO {

	public void salvar(Produto produto);

	public List<Produto> buscarTodos(Produto produto);

	public void excluir(Produto produto);

	public Produto buscarPorID(Produto produto);

	public Produto buscarPorDescricao(String descricao);
}
