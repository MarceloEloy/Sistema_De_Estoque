package Generico.sistema_de_estoque.DTO;

import Generico.sistema_de_estoque.Model.Categoria;

public record CategoriaDTO(String nome) {
    public CategoriaDTO(Categoria categoria){
        this(categoria.getNome());
    }
}
