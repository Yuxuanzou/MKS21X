import java.util.ArrayList;
import java.util.*;

public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(){
	super();
    }

    public OrderedSuperArray(int capacity){
	super(capacity);
    }

    public OrderedSuperArray(String[]ary){
	super();
	for (int i = 0;i < ary.length;i++){
	    add(ary[i]);
	}
    }
    
    public void add(int index, String value){
        add(value);
    }
    /*Write this method and any
    appropriate helper methods.*/

    public boolean add(String value){
	int i = findIndex(value);
	if (i != -1){
	    super.add(i,value);
	    return false;
	}
	else{
        if (i < super.size()){
           super.add(value);
        }
	}
	return true;
    }

    private int findIndex(String value){
	for (int i = 0;i < super.size();i++){
	    if (value.compareTo(super.get(i)) < 0){
		return i;
	    }
	}
	return -1;
    }

    private int findIndexBinary(String value){
        if (super.size() == 0){
	    return -1;
	}
	int start = 0;
	int end = super.size();
	int between = 0;
	while (start != end){
	    between = (start + end) / 2;
	    if (value.compareTo(super.get(between)) == 0){
		start = between;
		end = between;
	    }
	    else if (value.compareTo(super.get(between)) > 0){
		start = between + 1;
	    }
            else if (value.compareTo(super.get(between)) < 0){
		end = between - 1;
	    }
	}
	return end;
    }
    //add to the correct spot.
    //you may still use super.add(index,value)

    public String set(int index,String element){
	throw new UnsupportedOperationException();
    }

    public int indexOf(String element){
	int start = 0;
	int end = super.size() - 1;
	int between = 0;
	while (start != end){
	    between = (start + end) / 2;
	    if (super.get(between).compareTo(element) == 0){
	        end = between;
	    }
	    else if (super.get(between).compareTo(element) > 0){
		end = between;
	    }
	    else if (super.get(between).compareTo(element) < 0){
		start = between + 1;
	    }
	}
	return end; 
    }

    public int lastIndexOf(String element){
	int start = 0;
	int end = super.size() - 1;
	int between = 0;
	while (start != end){
	    between = (start + end) / 2;
	    if (super.get(between).compareTo(element) <= 0){
	   	start = between + 1; 
	    }
	    else {
		end = between;
	    }
	}
	if (super.get(super.size() - 1).compareTo(element) == 0){
	    return super.size() - 1;
	}
	return (end - 1);
    }
    
     public static void runTest02(int testID){
  
  if(testID<0){
    System.out.println("Error in driver usage!");
    System.exit(0);
  }
  
  OrderedSuperArray s1 = new OrderedSuperArray();
  ArrayList<String> s2 = new ArrayList<>();
  
  try{
    if(testID == 0 ){
    }
    
    if(testID == 1 ){
      s1.add("4");
      s2.add("4");
      s1.add("1");
      s2.add("1");
      s1.add("0");
      s2.add("0");
    }
    
    if(testID == 2 ){
      s1.add("3");
      s2.add("3");
      s1.add("1");
      s2.add("1");
      s1.add("5");
      s2.add("5");
      s1.add("0");
      s2.add("0");
    }
    
    if(testID == 3 ){
      s1.add("1");
      s2.add("1");
      for(int i = 0; i < 10; i ++){
        String v = ""+(int)(Math.random()*1000);
        int in = (int)(Math.random()*s2.size());
        s1.add(in,v);
        s2.add(in,v);
      }
    }
    
    if(testID == 4 ){
      s1.add("1");
      s2.add("1");
      try{
        s1.set(0,"");
      } catch(UnsupportedOperationException e){
        
      }
    }
    
    if(testID == 5 ){
      try{
        s1.set(0,"");
      } catch(UnsupportedOperationException e){
        
      }
    }
    
    if(testID == 6 ){
      String[] x= {"adsf","b","X","C","fish","cat","Abby","break","romp"};
      s1 = new OrderedSuperArray(x);
      s2.addAll(Arrays.asList(x));
    }
      
    if(testID == 7 ){
      s1.add("1");
      s2.add("1");
      
      for(int i = 0; i < 1000;   i ++){
        String v = ""+(int)(Math.random()*1000);
        s1.add(v);
        s2.add(v);
      }
    }
    
    
  }catch(Exception f){
    s2.add("0");
    //f.printStackTrace();
  }
  
  Collections.sort(s2);
  if(equals(s1,s2)){
    System.out.println("Test "+testID+",PASS");
  }else{
    System.out.println("Test "+testID+",FAIL!");// "+s1+"!="+s2);
  }
     }
    
  public static boolean equals(OrderedSuperArray s, ArrayList<String> a){
    if(s.size() == a.size()){
      for(int i = 0; i < s.size(); i++){
        if(!s.get(i).equals( a.get(i))){
          return false;
        }
      }
      return true;
    }
    return false;
  }

  public static void main(String[] args){
      runTest02(0);
      runTest02(1);
      runTest02(2);
      runTest02(3);
      runTest02(4);
      runTest02(5);
      runTest02(6);
      runTest02(7);
  }
}
