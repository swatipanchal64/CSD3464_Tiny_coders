public class GeneralBook extends BookImplementation {

    private String genre;
    private String language;
    private int publishingYear;

    public GeneralBook(String genre, String language, int publishingYear) {
        this.genre = genre;
        this.language = language;
        this.publishingYear = publishingYear;
    }

    @Override
    public String toString() {
        return "General Book Details:\n" +
                displayBookDetails() + "\n\t" +
                "Genre: " + genre + "\n\t" +
                "Language: " + language + "\n\t" +
                "Publishing Year: " + publishingYear;
    }

}

