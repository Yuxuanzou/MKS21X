import java.util.*;

public class Barcode implements Comparable<Barcode>{
    private String zip;
    
    public Barcode(String zip){
        this.zip = zip;
    }
    
    public String getZip(){
        return zip;
    }
    
    public String getCode(){
        return "|" + convertToCode(this.zip) + "|";
    }
    
    public String toString(){
        return "|" + getCode() + "|" + " " + getZip();
    }
    
    public int compareTo(Barcode other){
        return zip.compareTo(other.getZip());
    }
    
    public boolean equals(Barcode other){
        return zip.equals(other.getZip());
    }

    private String singleConvert(int a){
        String[] s = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
        return s[a];
    }
    
    public String convertToCode(String zip){
        String code = "";
        for (int i = 0;i < zip.length();i++){
            code += singleConvert(Integer.parseInt(zip.substring(i,i + 1)));
        }
        code += singleConvert(checkSum(zip));
        return code;
    }
    
    public int checkSum(String zip){
        int sum = 0;
        String stringSum;
        for (int i = 0;i < zip.length();i++){
            sum += Integer.parseInt(zip.substring(i,i + 1));
        }
        return sum % 10;
    }
}