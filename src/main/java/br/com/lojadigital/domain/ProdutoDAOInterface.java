package br.com.lojadigital.domain;

import java.util.Optional;

import br.com.lojadigital.entities.Produto;

public interface ProdutoDAOInterface {

    void addProduto(Produto produto);

    void alteraProduto(Produto produto);

    Optional<Produto> buscaProduto(int idP);

    boolean removeProduto(int idP);

}
