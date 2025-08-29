package Dev.Java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {


    private final NinjaService ninjaService;


    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Adicionar ninja (Create)

    @PostMapping("/criar")
    @Operation(summary = "Criar Ninja", description = "Essa rota cria um ninja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja excluido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não foi possivel criar o ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){

        NinjaDTO novoNinja =  ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + "(ID): " +novoNinja.getId());
    };

    //Mostrar todos os ninjas(READ)
    @Operation(summary = "Listar Ninja", description = "Essa rota lista todos os ninjas")

    @GetMapping("/listar")
    public ResponseEntity<List> listarNinjas(){

        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);

    }

    //Procurar ninja por ID(READ)

    @Operation(summary = "Procurar Ninja por ID", description = "Essa rota procura um ninja por ID.")
    @GetMapping("/listar/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não foi possivel encontrar um ninja com esse ID")
    })
    public ResponseEntity<?>  listarNinjasPorId(@PathVariable Long id){

        NinjaDTO ninjaDTO = ninjaService.ListarNinjasPorId(id);
        if (ninjaDTO !=null){
            return ResponseEntity.ok(ninjaDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja "+id+" não foi encontrado");
        }


    }

    //Alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterar/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja Alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não foi possivel encontrar um ninja com esse ID")
    })
    public ResponseEntity<String> AlterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){

        NinjaDTO ninjaDTO =  ninjaService.atualizarNinja(id, ninjaAtualizado);

        if (ninjaDTO != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("O ninja "+ ninjaDTO+ " e ID "+ id+ " Foi atualizado com sucesso " );
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja de id "+ id+" Não existe");
        }

    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletarId/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja excluido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não foi possivel encontrar um ninja com esse ID")
    })
    public ResponseEntity<String> DeletarNinjaPorId(@PathVariable Long id){


         if (ninjaService.ListarNinjasPorId(id) != null)  {
             ninjaService.deletarNinjaPorID(id);
             return ResponseEntity.ok("Ninja deletado com sucesso (ID): " + id);

         }
         else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body("O nina de id: "+ id+ "Não foi encontrado");
         }




    }






}
