package Generico.sistema_de_estoque.Repository;

import Generico.sistema_de_estoque.Model.Categoria;
import Generico.sistema_de_estoque.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>, PagingAndSortingRepository<Categoria, Long> {
}
