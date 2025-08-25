package Dev.Java10x.CadastroDeNinjas.Missoes;

import Dev.Java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }
    //Listar todas as missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }
    //Listar missoes por id
    public MissoesModel listarMissoesPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    };
    // Criar missoes
    public MissoesModel criarMissoes(MissoesModel missoes){

        return missoesRepository.save(missoes);
    }
    // Deletar missoes por id

    public void deletarMissoesPorID(Long id){
        missoesRepository.deleteById(id);
    }

}
