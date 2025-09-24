package nb.dev.anime.anime_crud.dtos;

import nb.dev.anime.anime_crud.entities.Anime;
import nb.dev.anime.anime_crud.entities.Studio;

import java.util.ArrayList;
import java.util.List;

public class StudioDTO {
    private String name;
    private List<AnimeMinDTO> animeList;

    public StudioDTO(){}

    public StudioDTO(String name) {
        this.name = name;
    }

    public StudioDTO(Studio studio){
       this.name = studio.getName();
       this.animeList = studio.getAnimeList().stream().map(AnimeMinDTO::new).toList();
    }

    public StudioDTO(String name, List<AnimeMinDTO> animeList) {
        this.name = name;
        this.animeList = animeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AnimeMinDTO> getAnimeList() {
        return animeList;
    }

    public void setAnimeList(List<AnimeMinDTO> animeList) {
        this.animeList = animeList;
    }


}
