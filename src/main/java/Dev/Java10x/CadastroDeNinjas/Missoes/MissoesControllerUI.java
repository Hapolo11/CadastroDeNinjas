package Dev.Java10x.CadastroDeNinjas.Missoes;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUI {

    private final MissoesService missoesService;

    public MissoesControllerUI(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarMissao(Model model) {
        model.addAttribute("missao", new MissoesDTO());
        return "adicionarMissao";
    }

    @PostMapping("/salvar")
    public String salvarMissao(@ModelAttribute MissoesDTO missao, RedirectAttributes redirectAttributes) {
        missoesService.criarMissoes(missao);
        redirectAttributes.addFlashAttribute("mensagem", "Missao cadastrada com sucesso!");
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/listar")
    public String listarMissao(Model model){

        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes",missoes);
        return "listarMissoes";
    }

    @GetMapping("/listar/{id}")
    public String listarMissaoPorID(@PathVariable Long id, Model model){
        MissoesDTO missoes = missoesService.listarMissoesPorId(id);
        if (missoes != null){
            model.addAttribute("missoes", missoes);
            return "detalhesMissoes";
        }
        else {
            model.addAttribute("Mensagem", "Missao não encontrada");
            return "listarMissoes";
        }

}
    @GetMapping("/deletarId/{id}")
    public String deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissoesPorID(id);
        return "redirect:/missoes/ui/listar";
    }
}

