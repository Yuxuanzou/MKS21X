public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String author, String title, String ISBN, String callNumber){
	super.setAuthor(author);
	super.setTitle(title);
	super.setISBN(ISBN);
	this.callNumber = callNumber;
    }

    public getCallNumber(){
	return callNumber;
    }

    public setCallNumber(String words){
	callNumber = words; 
    }

    public abstract void checkout(String patron, String due){
	
    }

    public abstract void returned(){
	
    }

    public abstract String circulationStatus(){
	
    }

    public String toString(){
	return (super.toString() + circulationStatus + callNumber);
    }
}

							  
