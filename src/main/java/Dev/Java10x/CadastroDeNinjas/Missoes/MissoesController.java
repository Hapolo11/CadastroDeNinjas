package Dev.Java10x.CadastroDeNinjas.Missoes;


import Dev.Java10x.CadastroDeNinjas.Ninjas.NinjaMapper;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;


    public MissoesController(MissoesService missoesService, MissoesMapper missoesMapper) {
        this.missoesService = missoesService;

    }

    //Mandar uma Requisição para Criar as missões
    @PostMapping("/criar")
    public MissoesDTO CriarMissoes(@RequestBody MissoesDTO missoes){
        return missoesService.criarMissoes(missoes);
    }

    //Mandar uma Requisição para mostrar todas as missões
    @GetMapping("/listar")
    public List<MissoesModel> listarMissao(){
        return missoesService.listarMissoes();

    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoPorID(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);

    }

    //Mandar uma Requisisão para alterar a Missão
    @PutMapping("/alterar")
    public String  AlterarNinjaPorId(){
        return "alterar missoes por id";

    }

    //Mandar uma Requisisão para Deletar a Missão
     @DeleteMapping("/deletarID")public String  DeletarNinjaPorId(@PathVariable Long id){
        missoesService.deletarMissoesPorID(id);
        return "Missão deletada deletado";

    }
}
