package digitalhouse.android.a0317moacns1c_01.Model.POJO;


public class Noticia {

    private String title;
    private String description;
    private String urlToImage;
    private String author;
    private String publishedAt;


    public Noticia(String title, String description, String urlToImage, String author, String publishedAt) {
        this.title = title;
        this.description = description;
        this.urlToImage = urlToImage;
        this.author = author;
        this.publishedAt = publishedAt;
    }

    public String getTitulo() {
        return title;
    }

    public String getContenido() {
        return description;
    }

    public String getImagen() {
        return urlToImage;
    }

    public String getAutor() {  return author;    }

    public String getFecha() {  return publishedAt;    }

    public void setUrl(String url) {
        this.urlToImage = urlToImage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
