package Dev.Java10x.CadastroDeNinjas.Missoes;

import Dev.Java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import Dev.Java10x.CadastroDeNinjas.Ninjas.NinjaMapper;
import Dev.Java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {


    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper, NinjaMapper ninjaMapper)
    {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }
    //Listar todas as missoes
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }
    //Listar missoes por id
    public MissoesDTO listarMissoesPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    };
    // Criar missoes
    public MissoesDTO criarMissoes(MissoesDTO missoesDTO){
        MissoesModel missoes = missoesMapper.map(missoesDTO);
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes);
    }
    // Deletar missoes por id

    public void deletarMissoesPorID(Long id){
        missoesRepository.deleteById(id);
    }

    //Atualizar Missões

    //Atualizar o ninja
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO) {
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if (missaoExistente.isPresent()) {
            MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }

}
