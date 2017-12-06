import java.util.Arrays;

public class Sorts{
    public static String name(){
        return "10.Zou.Yuxuan";
    }
    
    public static void selectionSort(int [] data){
        int num = 0;
        int currentIndex = 0;
        for (int i = 0; i < data.length; i++){
            num = data[i];
            currentIndex = i;
            for (int c = i; c < data.length; c++){
                if (data[c] < num){
                    currentIndex = c;
                    num = data[c];
                }
            }
            data[currentIndex] = data[i];  
            data[i] = num;
        }
    }

    private static boolean helpMe(int i, int k){
	return i < k;
    }

    public static void InsertionSort(int [] data){
	int temp;
	for (int i = 1;i < data.length;i++){
	    while (helpMe(data[tick],data[tick - 1])){
		int tick = i; 
		temp = data[tick - 1];
		data[tick - 1] = data[tick];
		data[tick] = temp;
	    }
	}
    }

    public static void main(String[]args){
	int [] a = {123,213,41,33,23,55,313,1323};
	InsertionSort(a);
	System.out.println(Arrays.toString(a));
    } 
}
