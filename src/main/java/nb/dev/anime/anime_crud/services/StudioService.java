package nb.dev.anime.anime_crud.services;

import nb.dev.anime.anime_crud.dtos.StudioDTO;
import nb.dev.anime.anime_crud.entities.Studio;
import nb.dev.anime.anime_crud.exceptions.ResourceNotFoundException;
import nb.dev.anime.anime_crud.repository.StudioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  StudioService {
    private final StudioRepository studioRepository;

    public StudioService(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    public StudioDTO createStudio(Studio studio){
       Studio stdSaved = studioRepository.save(studio);
       return new StudioDTO(stdSaved);

    }

    public void deleteStudio(Long id){
        if(!studioRepository.existsById(id)) throw new ResourceNotFoundException("Studio de id " +id+ " não encontrado");
        else studioRepository.deleteById(id);
    }

    public StudioDTO findStudio(Long id){
        Studio stdFound = studioRepository
                .findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Studio com id " +id+ " não encontrado"));
        return new StudioDTO(stdFound);
    }

    public List<StudioDTO> listStudios(){
        return studioRepository
                .findAll()
                .stream()
                .map(StudioDTO::new)
                .toList();
    }


}
