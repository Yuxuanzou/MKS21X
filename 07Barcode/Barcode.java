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
        if (zip.length() != 5){
            throw new IllegalArgumentException();
        }
        try {
            return toCode(this.zip);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }
    
    public String toString(){
        return "|" + getCode() + "|" + " (" + getZip() + ")";
    }
    
    public int compareTo(Barcode other){
        return zip.compareTo(other.getZip());
    }
    
    public boolean equals(Barcode other){
        return zip.equals(other.getZip());
    }

    public static String singleConvert(int a){
        String[] s = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
        return s[a];
    }
    
    public int codeToZipSingle(String code){
        String[] s = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
        for (int i = 0;i < s.length;i++){
            if (code.equals(s[i])){
                return i;
            }
        }
        return -1;
    }
    
    public static String toCode(String zip){
        String code = "";
        for (int i = 0;i < zip.length();i++){
            code += singleConvert(Integer.parseInt(zip.substring(i,i + 1)));
        }
        code += singleConvert(checkSum(zip));
        return code;
    }
    
    public String toZip(String code){
        String zip = "";
        if (code.length() != 32){
            throw new IllegalArgumentException();
        }
        else if (code.charAt(0) != '|' || code.charAt(code.length() - 1) != '|'){
            throw new IllegalArgumentException();
        }
        String codeNeeded = code.substring(1,31);
        for (int i = 1;i < 31; i+=5){
            if (codeToZipSingle(codeNeeded.substring(i,i+5)) == -1){
                throw new IllegalArgumentException();
            }
            else {
                zip += codeToZipSingle(codeNeeded.substring(i,i+5));
            }
        }
        if (zip.charAt(5) != checkSum(zip)){
            throw new IllegalArgumentException();
        }
        return zip.substring(0,5);
    }
    
    public static int checkSum(String zip){
        int sum = 0;
        String stringSum;
        for (int i = 0;i < zip.length();i++){
            sum += Integer.parseInt(zip.substring(i,i + 1));
        }
        return sum % 10;
    }
}