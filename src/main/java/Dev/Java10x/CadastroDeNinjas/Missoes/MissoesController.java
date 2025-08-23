package Dev.Java10x.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@RestController
@RequestMapping("/missoes")
public class MissoesController {


    //Mandar uma Requisição para Criar as missões
    @PostMapping("/criar")
    public String CriarMissoes(){
        return "Missao Criada";
    }

    //Mandar uma Requisição para mostrar todas as missões
    @GetMapping("/listar")
    public String  listarMissao(){
        return "Mostrando todos os ninjas";

    }

    //Mandar uma Requisisão para alterar a Missão
    @PutMapping("/alterar")
    public String  AlterarNinjaPorId(){
        return "alterar ninjas por id";

    }

    //Mandar uma Requisisão para Deletar a Missão
     @DeleteMapping("/deletarID")public String  DeletarNinjaPorId(){
        return "Deletar ninjas por id";

    }
}
