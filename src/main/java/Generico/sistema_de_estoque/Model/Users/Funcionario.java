package Generico.sistema_de_estoque.Model.Users;

import Generico.sistema_de_estoque.Model.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Funcionarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends RepresentationModel<Funcionario> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    Cargos cargo;

    @Column
    private String nome;

    @Column
    private String cpf;

    @ManyToMany(mappedBy = "funcionarios")
    private Set<Produto> produtos = new HashSet();
}
