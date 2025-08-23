package Dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {


    // Adicionar ninja (Create)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    //Mostrar todos os ninjas(READ)
    @GetMapping("/listar")
    public String  mostrarTodosOsNinjas(){
        return "Mostrando todos os ninjas";

    }

    //Procurar ninja por ID(READ)

    @GetMapping("/listarID")
    public String  mostrarTodosOsNinjasPorId(){
        return "Mostrando todos os ninjas por id";

    }

    //Alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterar")
    public String  AlterarNinjaPorId(){
        return "alterar ninjas por id";

    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")public String  DeletarNinjaPorId(){
        return "Deletar ninjas por id";

    }




}
