package Dev.Java10x.CadastroDeNinjas.Missoes;


import Dev.Java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity
@Table(name = "tb_missoes")

// Lombok para implementar Contructors, Getters e setters
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;

    private  String descricao;

    // Uma missão tem varios ninjas
    @OneToMany(mappedBy = "missoesModel")
    private List<NinjaModel> ninja;


}
