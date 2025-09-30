package nb.dev.anime.anime_crud.controllers;

import nb.dev.anime.anime_crud.dtos.StudioDTO;
import nb.dev.anime.anime_crud.entities.Studio;
import nb.dev.anime.anime_crud.services.StudioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studios")
public class StudioController {
    private StudioService studioService;

    public StudioController(StudioService studioService){
        this.studioService = studioService;
    }

    @GetMapping
    public List<StudioDTO> listStudios(){
        return studioService.listStudios();

    }

    @GetMapping("/find/{id}")
    public StudioDTO findStudio(@PathVariable Long id){
        return studioService.findStudio(id);
    }

    @PostMapping("/new")
    public StudioDTO createStudio(@RequestBody Studio studio){
        return studioService.createStudio(studio);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudio(@PathVariable Long id){
        studioService.deleteStudio(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }
}
