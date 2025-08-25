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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    };

    //Mostrar todos os ninjas(READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();

    }

    //Procurar ninja por ID(READ)

    @GetMapping("/listar/{id}")
    public NinjaModel  listarNinjasPorId(@PathVariable Long id){
        return ninjaService.ListarNinjasPorId(id);

    }

    //Alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaModel AlterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado){

        return ninjaService.atualizarNinja(id, ninjaAtualizado);

    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletarId/{id}")
    public String DeletarNinjaPorId(@PathVariable Long id){
         ninjaService.deletarNinjaPorID(id);
         return "O ninja foi deletado";

    }






}
