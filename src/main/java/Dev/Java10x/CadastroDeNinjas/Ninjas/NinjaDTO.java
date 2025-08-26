package Dev.Java10x.CadastroDeNinjas.Ninjas;

import Dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaDTO {


    private Long id;
    private String nome;
    private String Email;
    private String imgUrl;
    private int idade;
    private MissoesModel missoesModel;
    private String rank;
}
