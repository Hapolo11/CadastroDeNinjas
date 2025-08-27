package Dev.Java10x.CadastroDeNinjas.Missoes;


import Dev.Java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Entity
@Table(name = "tb_missoes")

// Lombok para implementar Contructors, Getters e setters
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class MissoesModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "dificuldade")
    private  String dificuldade;

    // Uma missão tem varios ninjas
    @OneToMany(mappedBy = "missoesModel")
    @JsonIgnore
    private List<NinjaModel> ninja;


}
