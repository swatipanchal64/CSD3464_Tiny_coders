public class ReferenceBook  extends BookImplementation {
    private String topic;
    private int edition;
    private String publisher;
    public ReferenceBook(String topic, int edition, String publisher) {
        this.topic = topic;
        this.edition = edition;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Reference Book Details:\n" +
                displayBookDetails() + "\n\t" +
                "Topic: " + topic + "\n\t" +
                "Edition: " + edition + "\n\t" +
                "Publisher: " + publisher;
    }

}