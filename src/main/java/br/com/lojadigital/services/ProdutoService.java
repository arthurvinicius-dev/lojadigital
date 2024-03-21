package br.com.lojadigital.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.lojadigital.dao.ProdutoDAO;
import br.com.lojadigital.domain.ProdutoServiceInterface;
import br.com.lojadigital.entities.Produto;

public class ProdutoService implements ProdutoServiceInterface {

    private ProdutoDAO produtoDAO;

    public ProdutoService() {
        this.produtoDAO = new ProdutoDAO();
    }

    @Override
    public boolean addProduto(String nomeP, String descricaoP, BigDecimal preco, int quantidadeEstoque) {

        try {
            if (nomeP == null || nomeP.isEmpty() || descricaoP == null || descricaoP.isEmpty() || preco == null
                    || preco.compareTo(BigDecimal.ZERO) <= 0) {
                return false;
            }
            List<Produto> produtosAtributosIguais = produtoDAO.getProdutos().stream()
                    .filter(produto -> produto.getNomeP().equals(nomeP)).collect(Collectors.toList());

            if (!produtosAtributosIguais.isEmpty()) {
                throw new IllegalArgumentException("Já existe um produto com mesmos nome");
            }

            Produto produto = new Produto(0, nomeP, descricaoP, preco, quantidadeEstoque);
            produtoDAO.addProduto(produto);
            return true;
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao adicionar produto: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean alteraProduto(int idP, String nomeP, String descricaoP, BigDecimal preco, int quantidadeEstoque) {

        Optional<Produto> produtoOptional = produtoDAO.buscaProduto(idP);
        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            try {
                if (nomeP == null || nomeP.isEmpty() || descricaoP == null || descricaoP.isEmpty() || preco == null
                        || preco.compareTo(BigDecimal.ZERO) <= 0) {
                    return false;
                }
                List<Produto> produtosAtributosIguais = produtoDAO.getProdutos().stream()
                        .filter(p -> p.getIdP() != produto.getIdP())
                        .filter(p -> p.getNomeP().equals(nomeP)).collect(Collectors.toList());
                if (!produtosAtributosIguais.isEmpty()) {
                    throw new IllegalArgumentException("Já existe um produto com mesmos nome");
                }

                produto.setNomeP(nomeP);
                produto.setDescricaoP(descricaoP);
                produto.setPreco(preco);
                produto.setQuantidadeEstoque(quantidadeEstoque);
                produtoDAO.alteraProduto(produto);
                return true;
            } catch (IllegalArgumentException e) {
                System.err.println("Erro ao adicionar produto: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public Optional<Produto> buscaProduto(int idP) {
        return produtoDAO.buscaProduto(idP);
    }

    @Override
    public boolean removeProduto(int idP) {
        boolean produtoRemovido = produtoDAO.removeProduto(idP);
        return produtoRemovido;
    }

}
