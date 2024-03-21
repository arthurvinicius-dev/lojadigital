package br.com.lojadigital.domain;

import java.math.BigDecimal;
import java.util.Optional;

import br.com.lojadigital.entities.Produto;

public interface ProdutoServiceInterface {

    boolean addProduto(String nomeP, String descricaoP, BigDecimal preco, int quantidadeEstoque);

    boolean alteraProduto(int idP, String nomeP, String descricaoP, BigDecimal preco, int quantidadeEstoque);

    Optional<Produto> buscaProduto(int idP);

    boolean removeProduto(int idP);
}
