import java.util.ArrayList; 

public class SuperArray{
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
	if (index < 0 || index > size()){
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
    
    public static void runTest01(int testID){
  if(testID<0){
    System.out.println("Error in driver usage!");
    System.exit(0);
  }
  
  SuperArray s1 = new SuperArray();
  ArrayList<String> s2 = new ArrayList<>();
  
  try{
    if(testID == 0 ){
    }
    
    if(testID == 1 ){
      s1.add("0");
      s2.add("0");
      s1.add("1");
      s2.add("1");
    }
    
    if(testID == 2 ){
      
      s1.add("0");
      s2.add("0");
      s1.add("1");
      s2.add("1");
      s1.add(1,"5");
      s2.add(1,"5");
      s1.add(0,"6");
      s2.add(0,"6");
      s1.add(s1.size()-1,"4");
      s2.add(s2.size()-1,"4");
    }
    
    if(testID == 3 ){
      s1.add("0");
      s2.add("0");
      s1.add("1");
      s2.add("1");
      s1.add(1,"5");
      s2.add(1,"5");
      s1.add(0,"6");
      s2.add(0,"6");
      s1.add(s1.size(),"4");
      s2.add(s2.size(),"4");
    }
    
    if(testID == 4 ){
      s1.add(0,"0");
      s2.add(0,"0");
    }
    
    if(testID == 5 ){
      s1.add("1");
      s2.add("1");
      for(int i = 0; i < 10; i ++){
        String v = ""+(int)(Math.random()*1000);
        int in = (int)(Math.random()*s2.size());
        s1.add(in,v);
        s2.add(in,v);
      }
    }
    
    if(testID == 6 ){
      try{
        s1.get(0);
      } catch(IndexOutOfBoundsException e){
        
      }
    }
    
    if(testID == 7 ){
      try{
        s1.set(0,"");
      } catch(IndexOutOfBoundsException e){
        
      }
    }
    
    if(testID == 8 ){
      try{
        s1.add(1,"");
      } catch(IndexOutOfBoundsException e){
        
      }
    }
    if(testID == 9 ){
      s1.add("1");
      s2.add("1");
      
      for(int i = 0; i < 1000;   i ++){
        String v = ""+(int)(Math.random()*1000);
        int in = (int)(Math.random()*s2.size());
        s1.add(in,v);
        s2.add(in,v);
      }
    }
    
    
  }catch(Exception f){
    s2.add("0");
    //f.printStackTrace();
  }
  
  if(equals(s1,s2)){
    System.out.println("Test "+testID+",PASS");
  }else{
    System.out.println("Test "+testID+",FAIL");
  }
    }
  
  public static boolean equals(SuperArray s, ArrayList<String> a){
    if(s.size() == a.size()){
      for(int i = 0; i < s.size(); i++){
        if(! s.get(i).equals( a.get(i))){
          return false;
        }
      }
      return true;
    }
    return false;
  }
    
  public static void main(String[] args){
      runTest01(1);
      runTest01(2);
      runTest01(3);
      runTest01(4);
      runTest01(5);
      runTest01(6);
      runTest01(7);
      runTest01(8);
      runTest01(9);
      runTest01(10);
  }
}
