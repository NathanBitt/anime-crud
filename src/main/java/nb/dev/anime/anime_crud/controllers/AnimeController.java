package nb.dev.anime.anime_crud.controllers;

import nb.dev.anime.anime_crud.dtos.AnimeDTO;
import nb.dev.anime.anime_crud.entities.Anime;
import nb.dev.anime.anime_crud.services.AnimeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animes")
public class AnimeController {
    AnimeService animeService;

    public AnimeController(AnimeService animeService){
        this.animeService = animeService;
    }
    @PostMapping("/new")
    public AnimeDTO saveAnime(@RequestBody Anime anime){
        return animeService.saveAnime(anime);
    }

    @GetMapping
    public List<AnimeDTO> animeList(){
        return animeService.animeList();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAnime(@PathVariable Long id){
        animeService.deleteAnime(id);
    }

    @GetMapping("find/{id}")
    public AnimeDTO findAnime(@PathVariable Long id){
       return animeService.findAnime(id);
    }

    @PutMapping("/edit/{id}")
    public AnimeDTO deleteAnime(@PathVariable Long id, @RequestBody Anime animeUpdated){
        return animeService.editAnime(id, animeUpdated);
    }
}
