package Dev.Java10x.CadastroDeNinjas.Ninjas;

import Dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

//Entity para transformar a classe Ninja em uma entidade da DB

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "missoesModel")
public class NinjaModel {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
   private Long id;


    @Column (name = "nome")
   private String nome;

   @Column(unique = true)
   private String Email;

    @Column (name = "Imagem_url")
    private String imgUrl;

    @Column (name = "idade")
   private int idade;

    @Column(name = "rank")
    private String rank;


    // Um Ninja tem varias missões
   @ManyToOne
   @JoinColumn(name = "missoes_id") // Foreing Key ou chave estrangeira
   private MissoesModel missoesModel;


}

