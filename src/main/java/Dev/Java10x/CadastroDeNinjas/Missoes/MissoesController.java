package Dev.Java10x.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

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
    public List<MissoesDTO> listarMissao(){
        return missoesService.listarMissoes();

    }

    @GetMapping("/listar/{id}")
    public MissoesDTO listarMissaoPorID(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);

    }

    //Mandar uma Requisisão para alterar a Missão
    @PutMapping("/alterar/{id}")
    public MissoesDTO AlterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){

        return missoesService.atualizarMissao(id,missaoAtualizada);

    }

    //Mandar uma Requisisão para Deletar a Missão
     @DeleteMapping("/deletarID")public String DeletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissoesPorID(id);
        return "Missão deletada deletado";

    }
}
