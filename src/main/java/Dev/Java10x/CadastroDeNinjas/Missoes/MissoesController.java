package Dev.Java10x.CadastroDeNinjas.Missoes;


import Dev.Java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;


    public MissoesController(MissoesService missoesService, MissoesMapper missoesMapper) {
        this.missoesService = missoesService;

    }

    //Mandar uma Requisição para Criar as missões
    @PostMapping("/criar")
    @Operation(summary = "Criar Missao", description = "Essa rota cria uma missao")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Misssao criada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não foi possivel criar o ninja")
    })
    public ResponseEntity<String> CriarMissoes(@RequestBody MissoesDTO missoes){
        MissoesDTO novaMissao  = missoesService.criarMissoes(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("A missão "+novaMissao.getNome()+"Foi criada com id: "+ novaMissao.getId());
    }

    //Mandar uma Requisição para mostrar todas as missões
    @GetMapping("/listar")
    @Operation(summary = "Listar Missoes", description = "Essa rota lista todas as missoes")
    public
    ResponseEntity<List> listarMissao(){

        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);

    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Listar missao por id", description = "Essa rota lista uma missão por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não foi possivel encontrar a missao")
    })
    public ResponseEntity<?> listarMissaoPorID(@PathVariable Long id){
        MissoesDTO missoesDTO  = missoesService.listarMissoesPorId(id);
        if (missoesDTO != null ){
            return ResponseEntity.ok(missoesDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A Missão de id "+id+" Não existe em nossa base de dados");
        }



    }

    //Mandar uma Requisisão para alterar a Missão
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Aleterar missao por id", description = "Essa rota altera uma missão por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao alterada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não foi possivel encontrar a missao")}
    )
    public ResponseEntity<String> AlterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        MissoesDTO missoesDTO  = missoesService.listarMissoesPorId(id);
        if (missoesDTO != null){
            return ResponseEntity.ok("A Missão foi atualizado com suce");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão de id: "+id+" Não foi encontrada");
        }
    }

    //Mandar uma Requisisão para Deletar a Missão
     @DeleteMapping("/deletarID/{id}")
     @Operation(summary = "Deletar missao", description = "Essa rota deleta uma missão por id")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "200", description = "Missao deletada com sucesso"),
             @ApiResponse(responseCode = "404", description = "Não foi possivel encontrar a missao")})
     public ResponseEntity<?> DeletarMissaoPorId(@PathVariable Long id){

        if (missoesService.listarMissoesPorId(id) != null){
            missoesService.deletarMissoesPorID(id);
            return ResponseEntity.ok("a Missão de id: "+id+" foi deletada com sucesso");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("a Missão de ID: "+ id+" não foi encontrado");
        }


    }
}
