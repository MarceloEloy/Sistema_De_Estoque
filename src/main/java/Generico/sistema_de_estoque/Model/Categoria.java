package Generico.sistema_de_estoque.Model;

import Generico.sistema_de_estoque.DTO.CategoriaDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Categoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    public Categoria(CategoriaDTO categoriaDTO){
        this.nome = categoriaDTO.nome();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @JsonBackReference
    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;
}
