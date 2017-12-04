import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{
    private int start;
    private SuperArray a;
    private int end;
    
    public SuperArrayIterator(SuperArray a){
        this.start = start;
        this.a = a;
        end = a.size();
    }
    
    public boolean hasNext(){
        if (start < end){
            return true;
        }
        else {
            return false;
        }
    }
    
    public String next(){
        if (hasNext() == true){
            start ++;
        }
        else {
            System.exit(0);
        }
        return a.get(start - 1);
    }
    
    public void remove(){
        throw new UnsupportedOperationException();
    }
}