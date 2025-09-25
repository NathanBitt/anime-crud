package nb.dev.anime.anime_crud.dtos;

import nb.dev.anime.anime_crud.entities.Anime;

public class AnimeDTO {

    private String name;
    private String synopsis;
    private String genre;
    private int episodes;
    private Double price;
    private StudioMinDTO studio;

    public AnimeDTO() {

    }

    public AnimeDTO(Anime anime) {
        this.name = anime.getName();
        this.synopsis = anime.getSynopsis();
        this.genre = anime.getGenre();
        this.episodes = anime.getEpisodes();
        this.price = anime.getPrice();
        this.studio = new StudioMinDTO(anime.getStudio());

    }

    public AnimeDTO(String name, String synopsis, String genre, int episodes, Double price, StudioMinDTO studio) {
        this.name = name;
        this.synopsis = synopsis;
        this.genre = genre;
        this.episodes = episodes;
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

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public StudioMinDTO getStudio() {
        return studio;
    }

    public void setStudio(StudioMinDTO studio) {
        this.studio = studio;
    }
}
