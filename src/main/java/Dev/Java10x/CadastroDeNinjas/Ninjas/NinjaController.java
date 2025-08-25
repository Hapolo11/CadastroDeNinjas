package Dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {


    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Adicionar ninja (Create)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    //Mostrar todos os ninjas(READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();

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
