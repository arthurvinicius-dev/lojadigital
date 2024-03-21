package br.com.lojadigital.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.lojadigital.domain.ProdutoDAOInterface;
import br.com.lojadigital.entities.Produto;

public class ProdutoDAO implements ProdutoDAOInterface {

    List<Produto> listaDeProdutos = new ArrayList<>();
    private int proximoIdP = 1;

    public ProdutoDAO() {
        this.listaDeProdutos = new ArrayList<>();
        this.proximoIdP = 1;
    }

    @Override
    public void addProduto(Produto produto) {
        produto.setIdP(proximoIdP);
        listaDeProdutos.add(produto);
        proximoIdP++;
    }

    @Override
    public void alteraProduto(Produto produto) {
        for (int i = 0; i <listaDeProdutos.size(); i++){
            if (listaDeProdutos.get(i).getIdP() == produto.getIdP()) {
                listaDeProdutos.set(i, produto);
                return;
            }
        }
    }

    @Override
    public Optional<Produto> buscaProduto(int idP) {
       return listaDeProdutos.stream().filter(produto -> produto.getIdP() == idP).findFirst();
    }

    @Override
    public boolean removeProduto(int idP) {
        Optional<Produto> produtoOptional = buscaProduto(idP);
        if (produtoOptional.isPresent()) {
            listaDeProdutos.remove(produtoOptional.get());
            return true; // Produto removido com sucesso
        }
        return false;
    }

    public List<Produto> getProdutos (){
        return listaDeProdutos;
    }
}
