package Generico.sistema_de_estoque.DTO;

import Generico.sistema_de_estoque.Model.Produto;

public record ProdutoDTO(
        String nome,
        Integer estoque,
        Double preco,
        Long categoriaID
) {
    public ProdutoDTO(Produto produto){
        this(produto.getNome(), produto.getEstoque(), produto.getPreco(), produto.getCategoria().getId());
    }
}
