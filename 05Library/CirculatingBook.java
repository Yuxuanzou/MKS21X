public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String author, String title, String ISBN, String callNumber){
        super.setAuthor(author);
	super.setTitle(title);
	super.setISBN(ISBN);
	super.setCallNumber(callNumber);
    }
    public String getCurrentHolder(){
        return currentHolder;
    }
    public String getDueDate(){
        return dueDate;
    }
    public void setCurrentHolder(String words){
        currentHolder = words;
    }
    public void setDueDate(String words){
        dueDate = words; 
    } 
    
    public void checkout(String patron, String dueDate){
        setCurrentHolder(patron);
        setDueDate(dueDate);
    }
    
    public void returned() {
        setCurrentHolder(null);
        setDueDate(null);
    }
    
    public String circulationStatus(){
        if (currentHolder.equals(null)){
            return "book available on shelf";
        }
        else {
            return getCurrentHolder() + getDueDate(); 
        }
    }
    public String toString() {
        return super.toString() + ", " + circulationStatus();
    }
}
