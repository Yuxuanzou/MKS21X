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
}