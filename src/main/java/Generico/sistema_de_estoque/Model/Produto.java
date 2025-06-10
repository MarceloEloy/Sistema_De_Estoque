package Generico.sistema_de_estoque.Model;

import Generico.sistema_de_estoque.DTO.ProdutoDTO;
import Generico.sistema_de_estoque.Model.Users.Funcionario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "Produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto extends RepresentationModel<Produto> {
    public Produto(ProdutoDTO produtoDTO){
        this.nome = produtoDTO.nome();
        this.estoque = produtoDTO.estoque();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private Integer estoque;

    @Column
    private Double preco;

    @ManyToOne()
    @JoinColumn(name = "categoria")
    private Categoria categoria;

    @ManyToMany()
    @JsonBackReference
    @JoinTable(name = "produtos_funcionarios",
    joinColumns = @JoinColumn(name = "produto_id"),
    inverseJoinColumns = @JoinColumn(name = "funcionario_id")
    )
    private Set<Funcionario> funcionarios = new HashSet();
}
