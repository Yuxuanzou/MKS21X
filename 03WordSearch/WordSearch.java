import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class WordSearch {
    private char [][] data;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private Random randgen;

    public WordSearch(int rows,int cols){
	data = new char[rows][cols];
    }
    
    public WordSearch(int rows, int cols, String fileName){
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	data = new char[rows][cols];
	randgen = new Random();
	try {
	    File f = new File(fileName);
	    Scanner in = new Scanner(f);
	    while (in.hasNext()){
		String line = in.next();
		wordsToAdd.add(line);
	    }
	}catch (FileNotFoundException e){
	    System.out.println("File not found:" + fileName);
	    System.exit(1);
	}
	addAllWords();
    }
    public WordSearch(int rows, int cols, String fileName, int randSeed){
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	data = new char[rows][cols];
	randgen = new Random(randSeed);
	try {
	    File f = new File(fileName);
	    Scanner in = new Scanner(f);
	    while (in.hasNext()){
		String line = in.next();
		wordsToAdd.add(line);
	    }
	} catch (FileNotFoundException e){
	    System.out.println("File not found:" + fileName);
	    System.exit(1);
	}
	addAllWords();
    }

    public WordSearch(int rows ,int cols, String fileName, int randSeed, String key){
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	data = new char[rows][cols];
	randgen = new Random(randSeed);
	try {
	    File f = new File(fileName);
	    Scanner in = new Scanner(f);
	    while (in.hasNext()){
		String line = in.next();
		wordsToAdd.add(line);
	    }
	} catch (FileNotFoundException e){
	    System.out.println("File not found:" + fileName);
	    System.exit(1);
	}
	addAllWords();
    }
    
    private void clear(){
	for (int i = 0;i < data.length;i++){
	    for (int c = 0;c < data[i].length;c++){
		data[i][c] = '_';
	    }
	}
    }

    public String getKeys(){
	String keys = "";
	for (int i = 0;i < data.length;i++){
	    for (int c = 0;c < data[i].length;c++){
		if (Character.isLetter(data[i][c])){
		    keys += data[i][c] + " ";
		}
		else {
		    keys += "  ";
		}
	    }
	    keys += "\n";
	}
	return keys;
    }
    
    public String toString(){
	String words = "";
	char letter;
	for (int i = 0;i < data.length;i++){
	    for (int c = 0;c < data[i].length;c++){
		letter = (char)(randgen.nextInt(26) + 97);
		if (Character.isLetter(data[i][c])){
		    words += data[i][c] + " ";
		}
		else {
		    words +=  (letter + "") + " ";
		}
	    }
	    words += "\n";
	}
	return words;
    }

    public boolean addWordHorizontal(String word,int rol,int col){
	if (col + word.length() >= data[rol].length){
	    return false;
	}
	for (int i = 0;i < word.length();i++){
	    if (Character.isLetter(data[rol][col + i]) && data[rol][col + i] != word.charAt(i)){
		return false;
	    }
	}
	for (int b = 0;b < word.length();b++){
	    try {
		data[rol][col + b] = word.charAt(b);
	    } catch (IndexOutOfBoundsException e){
		return false;
	    }
	}
	    return true;
    }
    
    public boolean addWordVertical(String word,int rol,int col){
	if (word.length() + rol >= data.length){
	    return false;
	}
	for (int i = 0;i < word.length();i++){
	    if (Character.isLetter(data[rol + i][col]) && data[rol + i][col] != word.charAt(i)){
		return false;
	    }
	}
	for (int b = 0;b < word.length();b++){
	    try {
		data[rol + b][col] = word.charAt(b);
	    } catch (IndexOutOfBoundsException e){
		return false;
	    }
	}
	return true;
    }
    
    public boolean addWordDiagnol(String word,int rol,int col){
	if ((rol + word.length()) >= data.length || (col + word.length()) >= data[rol].length){
	    return false;
	}
	for (int i = 0;i < word.length();i++){
	    if (Character.isLetter(data[rol + i][col + i]) && data[rol + i][col + i] != word.charAt(i)){
		return false;
	    }
	}
	for (int c = 0;c < word.length();c++){
	    try {
		data[rol + c][col + c] = word.charAt(c);
	    } catch (IndexOutOfBoundsException e){
		return false;
	    }
	}
	return true;
    }
    
    public boolean addWord(int r, int c, String word,int rowIncrement,int colIncrement){
	if (rowIncrement == 0 & colIncrement == 0){
	    return false;
	}
        try {
	    for (int i = 0;i < word.length();i++){
		if (Character.isLetter(data[r + (i * rowIncrement)][c + (i * colIncrement)]) && data[r + (i * rowIncrement)][c + (i * colIncrement)] != word.charAt(i)){
		    return false;
		}
	    }
	    for (int b = 0;b < word.length();b++){
		data[r + (b * rowIncrement)][c + (b * colIncrement)] = word.charAt(b);
	    }
	}catch (IndexOutOfBoundsException e){
	    return false;
	}
	wordsToAdd.remove(word);
	wordsAdded.add(word);
	return true;
    }
    
    public boolean addAllWords() {
	int sizeOfAry = 0;
	int tick = 0;
	int row = 0;
	int col = 0;
	int r = 0;
	int c = 0;
	while (wordsToAdd.size() != 0) {
	    sizeOfAry = randgen.nextInt(wordsToAdd.size());
	    row = randgen.nextInt(data.length);
	    col = randgen.nextInt(data[0].length);
	    r = randgen.nextInt()%2;
	    c = randgen.nextInt()%2;
	    if (r == 0 && c == 0){
		r = -1;
		c = -1;
	    }
	    addWord(row,col,wordsToAdd.get(sizeOfAry), r, c);
	    tick++;
	    if (tick > 1000) {
		break;
	    }
	}
	return true;
    }


    public static void main(String[]args){
	int r = 0;
	int c = 0;
	int randseed = 0;
	try {
	    if (args.length == 3){
		r = Integer.parseInt(args[0]);
		c = Integer.parseInt(args[1]);
	        if (r < 0 || c < 0){
		  System.out.println("Error: Cannot have negative rows or columns");
		  System.exit(1);		
		}
	    }
	    if (args.length == 4){
		r = Integer.parseInt(args[0]);
		c = Integer.parseInt(args[1]);
		randseed = Integer.parseInt(args[3]);
		if (r < 0 || c < 0){
		  System.out.println("Error: Cannot have negative rows or columns");	
		  System.exit(1);
		}
	    }
	    if (args.length == 5){
		r = Integer.parseInt(args[0]);
		c = Integer.parseInt(args[1]);
		randseed = Integer.parseInt(args[3]);
		if (r < 0 || c < 0){
		  System.out.println("Error: Cannot have negative rows or columns");
		  System.exit(1);		
		}
	    }
	} catch (IllegalArgumentException e){
	    System.out.println("Error!:args are in wrong format. Plz follow the following    	directions : arg 1 is an int, arg 2 is an int, arg 3 is a String, if you have arg 4 it should be a int, arg 5 is a String");
	    System.exit(1);
	}
	if (args.length == 3){
	    WordSearch ey = new WordSearch(r,c,args[2]);
	    System.out.println(ey);
	    System.out.println(ey.wordsAdded);
	}
	else if (args.length == 4){
	    WordSearch f = new WordSearch(r,c,args[2],randseed);
	    System.out.println(f);
	    System.out.println(f.wordsAdded);
	}
	else if (args.length == 5){
	    WordSearch ok = new WordSearch(r,c,args[2],randseed,args[4]);
	    if (args[4].equals("key")){
		System.out.println(ok.getKeys());
	    }
	    else {
		System.out.println(ok);
		System.out.println(ok.wordsAdded);
	    }
	}
	else {
	    System.out.println("require minimum of 3 args and not greater than 5. Requirements:row,col,textfile");
	}
    }
}
    
