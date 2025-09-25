package nb.dev.anime.anime_crud.services;

import nb.dev.anime.anime_crud.dtos.StudioDTO;
import nb.dev.anime.anime_crud.entities.Studio;
import nb.dev.anime.anime_crud.repository.StudioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  StudioService {
    private StudioRepository studioRepository;

    public StudioService(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    public StudioDTO createStudio(Studio studio){
       Studio stdSaved = studioRepository.save(studio);

       return new StudioDTO(stdSaved);

    }

    public void deleteStudio(Long id){
        studioRepository.deleteById(id);
    }

    public StudioDTO findStudio(Long id){
        Studio stdFound = studioRepository
                .findById(id).orElseThrow(
                () -> new RuntimeException("Studio não encontrado"));
        return new StudioDTO(stdFound);
    }

    public List<StudioDTO> listStudios(){
        List<StudioDTO> stdList = studioRepository
                .findAll()
                .stream()
                .map(StudioDTO::new)
                .toList();
        return stdList;
    }


}
