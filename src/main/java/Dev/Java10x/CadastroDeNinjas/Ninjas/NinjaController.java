package Dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){

        NinjaDTO novoNinja =  ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + "(ID): " +novoNinja.getId());
    };

    //Mostrar todos os ninjas(READ)
    @GetMapping("/listar")
    public ResponseEntity<List> listarNinjas(){

        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);

    }

    //Procurar ninja por ID(READ)

    @GetMapping("/listar/{id}")
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
