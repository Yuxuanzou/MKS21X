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
	    add(i,ary[i]);
	}
    }
    
    public void add(int index, String value){
        super.add(value);
    }
    /*Write this method and any
    appropriate helper methods.*/

    public boolean add(String value){
	int i = findIndex(value);
	if (i != -1){
	    super.add(i,value);
	    return true;
	}
	else{
	    super.add(value);
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
}
