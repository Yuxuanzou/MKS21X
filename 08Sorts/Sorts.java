import java.util.Arrays;

public class Sorts{
    public static String name(){
        return "10.Zou.Yuxuan";
    }
    
    public static boolean isSorted(int[]ary){                                       
        for(int i = 0; i < ary.length - 1 ; i++){                                   
            if(ary[i] > ary[i+1]){                                                  
                return false;                                                       
            }                                                                       
        }                                                                           
        return true;                                                                
    }                                                                               
                                          

    public static void bogoSort(int[] ary){                                         
        while(!isSorted(ary)){                                                      
            for(int i = 0 ; i < ary.length; i++){                                   
                int temp = ary[i];                                                  
                int newSpot = (int)(Math.random()*ary.length);                      
                ary[i] = ary[newSpot];                                              
                ary[newSpot] = temp;                                                
            }                                                                       
        }                                                                           
    }                                                                               
                                                                                    
    private static void swap(int[]ary,int a, int b){                                
        int c =ary[a];                                                              
        ary[a] = ary[b];                                                            
        ary[b] = c;                                                                 
    }
    
    public static void selectionSort(int [] data){
        int num = 0;
        int index = 0;
        for (int i = 0; i < data.length; i++){
            num = data[i];
            index = i;
            for (int c = i; c < data.length; c++){
                if (data[c] < num){
                    index = c;
                    num = data[c];
                }
            }
            data[index] = data[i];  
            data[i] = num;
        }
    }

    public static void InsertionSort(int [] data){
       int index;
       int num;
	   for (int i = 0;i < data.length;i++){
           index = i;
           num = data[i];
           for (int c = index; c > 0; c--){
                if (num < data[c-1]){
                    data[index] = data[c - 1];
                    index = index - 1;
                    data[index] = num;
                }
           }
       }
    }

    //public static void main(String[]args){
	//int [] a = {123,213,41,33,23,55,313,1323};
	//Sorts.InsertionSort(a);
	//System.out.println(Arrays.toString(a));
    //} 
}
