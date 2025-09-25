package nb.dev.anime.anime_crud.enums;

public enum AnimeStatus {
    IN_PRODUCTION("Anime em produção"),
    IN_RELEASE("Anime em lançamento"),
    COMPLETE("Anime já publicado");

    private final String description;

    AnimeStatus(String description) {
        this.description = description;
    }
}
