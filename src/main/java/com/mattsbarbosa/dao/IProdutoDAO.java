package com.mattsbarbosa.dao;

import com.mattsbarbosa.domain.Produto;

public interface IProdutoDAO {
    Produto cadastrar(Produto produto);

    Produto buscarPorId(Long id);

    void excluir(Produto produto);
}
