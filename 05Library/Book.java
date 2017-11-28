public class Book{
    private String author;
    private String title;
    private String ISBN;

    public Book(){
	
    }

    public Book(String author, String title, String ISBN){
	this.author = author;
	this.title = title;
	this.ISBN = ISBN;
    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public String getISBN(){
	return ISBN; 
    }

    public void setAuthor(String words){
	author = words; 
    }

    public void setTitle(String words){
	title = words; 
    }

    public void setISBN(String words){
	ISBN = words; 
    }

    public String toString(){
	String words = "";
	words += title;
	words += author;
	words += ISBN;
	return words;
    }
}
