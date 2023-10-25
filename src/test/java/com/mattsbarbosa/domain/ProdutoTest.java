package com.mattsbarbosa.domain;

import com.mattsbarbosa.dao.IProdutoDAO;
import com.mattsbarbosa.dao.ProdutoDAO;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProdutoTest {
    private IProdutoDAO produtoDAO;

    public ProdutoTest() {
        produtoDAO = new ProdutoDAO();
    }

    @Test
    public void cadastrarBuscarExcluir() {
        Produto produto = criarProduto();
        assertNotNull(produto);

        Produto produtoDB = produtoDAO.buscarPorId(produto.getId());
        assertNotNull(produtoDB);
        assertEquals("Play3", produtoDB.getNome());

        produtoDAO.excluir(produtoDB);
        Produto produtoDBExcluido = produtoDAO.buscarPorId(produtoDB.getId());
        assertNull(produtoDBExcluido);
    }

    private Produto criarProduto() {
        Produto produto = new Produto();
        produto.setNome("Play3");
        produto.setValor(1.0000d);
        produto = produtoDAO.cadastrar(produto);
        return produto;
    }
}