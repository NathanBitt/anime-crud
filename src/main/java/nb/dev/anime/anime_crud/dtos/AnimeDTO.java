package nb.dev.anime.anime_crud.dtos;

import nb.dev.anime.anime_crud.entities.Anime;
import nb.dev.anime.anime_crud.entities.Studio;

public class AnimeDTO {

    private String name;
    private String synopsis;
    private String genre;
    private int volumes;
    private Double price;
    private Studio studio;

    public AnimeDTO() {

    }

    public AnimeDTO(Anime anime) {
        this.name = anime.getName();
        this.synopsis = anime.getSynopsis();
        this.genre = anime.getGenre();
        this.volumes = anime.getVolumes();
        this.price = anime.getPrice();
        this.studio = anime.getStudio();

    }

    public AnimeDTO(String name, String synopsis, String genre, int volumes, Double price, Studio studio) {
        this.name = name;
        this.synopsis = synopsis;
        this.genre = genre;
        this.volumes = volumes;
        this.price = price;
        this.studio = studio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getVolumes() {
        return volumes;
    }

    public void setVolumes(int volumes) {
        this.volumes = volumes;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
}
