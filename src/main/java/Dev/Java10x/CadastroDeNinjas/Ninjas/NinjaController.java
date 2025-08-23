package Dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Ninjas")
public class NinjaController {


    // Adicionar ninja (Create)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    //Mostrar todos os ninjas(READ)
    @GetMapping("/todos")
    public String  mostrarTodosOsNinjas(){
        return "Mostrando todos os ninjas";

    }

    //Procurar ninja por ID(READ)

    @GetMapping("/todosID")
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
