package Generico.sistema_de_estoque.DTO;

import Generico.sistema_de_estoque.Model.Produto;
import Generico.sistema_de_estoque.Model.Users.Funcionario;

import java.util.Set;
import java.util.stream.Collectors;

public record ProdutoDTO(
        String nome,
        Integer estoque,
        Double preco,
        Long categoriaID,
        Set<Long> funcionariosID
) {
    public ProdutoDTO(Produto produto){
        this(produto.getNome(), produto.getEstoque(), produto.getPreco(), produto.getCategoria().getId(), produto.getFuncionarios().stream().map(Funcionario::getId).collect(Collectors.toSet()));
    }
}
