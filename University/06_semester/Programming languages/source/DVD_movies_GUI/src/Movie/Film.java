package Movie;

public class Film {
  public String ID;
  public String title;
  public String director;
  public String genre;
  public int year;
  public void setData(String ID, String title, String director, String genre, int year) {
    this.ID = ID;
    this.title = title;
    this.director = director;
    this.genre = genre;
    this.year = year;
  }
  public void showData() {
    System.out.println(ID + " " + title + " " + director + " " + genre + " " + year);
  }

}