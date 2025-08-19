package Dev.Java10x.CadastroDeNinjas.Ninjas;

import Dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

//Entity para transformar a classe Ninja em uma entidade da DB
@Entity
@Table(name = "tb_cadastro")
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

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        Email = email;
        this.idade = idade;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
