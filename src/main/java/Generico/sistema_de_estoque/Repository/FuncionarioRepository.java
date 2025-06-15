package Generico.sistema_de_estoque.Repository;

import Generico.sistema_de_estoque.Model.Users.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>, PagingAndSortingRepository<Funcionario, Long> {

}
