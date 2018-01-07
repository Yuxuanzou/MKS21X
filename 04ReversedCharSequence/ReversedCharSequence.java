public class ReversedCharSequence implements CharSequence{
    private String data = "";

    public ReversedCharSequence(String stuff){
	String reverse = "";
	for (int i = stuff.length() - 1;i >= 0;i--){
	    reverse += stuff.substring(i,i+1);
	}
	data = reverse; 
    }
    
    public char charAt(int index){
	return data.charAt(index);
    }

    public int length(){
	return data.length();
    }

    public CharSequence subSequence(int start, int end){
        return data.substring(start,end);
    }

    public String toString(){
	String str = "";
        for (int i = 0;i < data.length();i++){
	    str += data.substring(i,i+1);
	}
	return str;
    }
}
