package Dev.Java10x.CadastroDeNinjas.Ninjas;

import Dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Entity para transformar a classe Ninja em uma entidade da DB

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nome;
   private String Email;
   private int idade;
    // Um Ninja tem varias missões
   @ManyToOne
   @JoinColumn(name = "missoes_id") // Foreing Key ou chave estrangeira
   private MissoesModel missoesModel;

}
