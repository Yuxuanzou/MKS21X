public class ReferenceBook extends LibraryBook{
    private String collection;
    public ReferenceBook(String author, String title, String ISBN, String callNumber, String collection){
        setAuthor(author);
        setTitle(title);
        setISBN(ISBN);
        setCallNumber(callNumber);
        this.collection = collection;
    }
    public String getCollection(){
        return collection;
    }
    public void setCollection(String words){
        collection = words;
    }   
    public void checkout(String p, String d){
        System.out.println("Cannot checkout a reference book");
    }
    public void returned(){
        System.out.println("Reference book could not have been checked out -- return impossible");
    }
    public String circulationStatus(){
        return "non-circulating reference book";
    }
    public String toString(){
        return super.toString() + ", " + getCollection();
    }
}