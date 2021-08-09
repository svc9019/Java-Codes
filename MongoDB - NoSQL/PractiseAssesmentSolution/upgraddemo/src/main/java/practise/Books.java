package practise;
import org.bson.Document;

public class Books {

    private int id;
    private String author ;
    private int pages;
    private int price;
    private String genre ;

    public Books(int id, String author, int pages, int price, String genre) {
        this.id = id;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.genre = genre;
    }


    public Document createDBObject(){
        Document book  = new Document();
        book.append("_id", this.getId());
        book.append("author", this.getAuthor());
        book.append("pages", this.getPages());
        book.append("price", this.getPrice());
        book.append("genre", this.getGenre());

        return book;
    }


    @Override
    public String toString() {
        return "Books{" + "id=" + id + ", author='" + author + '\'' + ", pages=" + pages + ", price=" + price + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String name) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int courseId) {
        this.pages = courseId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String name) {
        this.genre = genre;
    }

}
