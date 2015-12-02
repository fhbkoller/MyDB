package br.com.senai.ftv.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;

import br.com.senai.ftv.modelo.Produto;

public class ProdutoDAOImpl extends DefaultDAO implements ProdutoDAO {

	@Override
	public void salvar(Produto produto) {
		beginSession();
		save(produto);
		endSession();
	}

	@Override
	public void excluir(Produto produto) {
		beginSession();
		delete(produto);
		endSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> buscarTodos(Produto produto) {
		beginSession();
		List<Object> properties = Collections.emptyList();
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT produto FROM Produto produto ");
		hql.append("WHERE 1=1");
		if (produto.getIdProduto() > 0) {
			hql.append("AND produto.idProduto = ?");
			properties.add(produto.getIdProduto());
		}
		if (produto.getDescricao() != null) {
			hql.append("AND produto.descricao = ?");
			properties.add(produto.getDescricao());
		}
		if (produto.getQuantidade() > 0) {
			hql.append("AND produto.quantidade = ?");
			properties.add(produto.getQuantidade());
		}
		if (produto.getValor() != null) {
			hql.append("AND produto.valor = ?");
			properties.add(produto.getValor());
		}

		try {
			Query query = createQuery(hql.toString());
			for (int i = 1, z = properties.size(); i < z; i++) {
				query.setParameter(i, properties.get(i - 1));
			}
			return (ArrayList<Produto>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			endSession();
		}
		return null;
	}

	@Override
	public Produto buscarPorID(Produto produto) {
		return buscarTodos(produto).get(0);
	}

	@Override
	public Produto buscarPorDescricao(String descricao) {
		Produto produto = new Produto();
		produto.setDescricao(descricao);
		return buscarTodos(produto).get(0);
	}

}
