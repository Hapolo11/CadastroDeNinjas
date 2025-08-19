package Dev.Java10x.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MissoesController {

    @GetMapping("/missoes")
    public String boasVindas() {

        return "Você esta na tela de missoes";

    }
}
