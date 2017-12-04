import java.util.Iterator;

public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;
    
    public SuperArray(){
        data = new String[10];
        size = 0;
    }

    public SuperArray(int n){
	data = new String[n];
    }

    public void clear(){
	size = 0;
        data = new String[data.length];
    }
    public int size(){
	   return size;
    }
    
    public boolean isEmpty(){
	if (size == 0){
	    return true;
	}
	return false;
    }
    
    public boolean add(String element){
	if (size ==  data.length){
	    resize();
	}
        data[size] = element;
	size++;
	return true;	
    }
    
    public String get(int index){
	if (index < 0 || index >= size()){
	    return null;
	}
	return data[index];
    }

    public String set(int index,String element){
	if (index < 0 || index >= size()){
	    return null;
	}
        String old = "";
	old = data[index];
	data[index] = element;
	return old;
    }
    
    public String toString(){
	String s = "[";
	for (int i = 0;i < size();i++){
	    s += data[i];
	    s += ",";
	}
	return s + "]";
    }

    private void resize(){
	String[] ary = new String[size() * 2];
	for (int index = 0;index < size();index++){
	     ary[index] = data[index];
	}
	data = ary; 
    }

    public boolean contains(String target){
	for (int i = 0;i < size();i++){
	    if (data[i].equals(target)){
		return true;
	    }
	}
	return false;
    }

    public int indexOf(String target){
	for (int i = 0;i < size();i++){
	    if (data[i].equals(target)){
		return i;
	    }
	}
	return -1;
    }

    public int lastIndexOf(String target){
	for (int i = size() - 1;i >= 0;i--){
	    if (data[i].equals(target)){
		return i;
	    }
	}
	return -1;
    }

    public void add(int index,String target){
	if (index < 0 || index >= size()){
	    return;
	}
	if (size == data.length){
	    resize();
	}	
    	for (int i = data.length-2; i >= index; i--){
    	    data[i+1]=data[i];
    	}
    	data[index]=target;
    	size ++;	
    	}

    public String remove(int index){
        if (index < 0 || index >= size()){
	    return null;
	}
    	String removed = data[index];
    	for (int i = index; i < size-1; i++){
		data[i]=data[i+1];
	}
    	set(data.length-1,null);
    	size--;
	return removed;
    }

    public boolean remove(String target){
	for (int i = 0;i < size() - 1;i++){
	    if (data[i].equals(target)){
		remove(i);
		return true;
	    }
	}
	return false;
    }
    
    public Iterator<String> iterator(){
        return new SuperArrayIterator(this);
    }
}
