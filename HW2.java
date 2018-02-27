import java.util.Scanner;

public class HW2 {
  
  //checks to see if the input string is in alphabetical order
  public static boolean isAlphabeticalOrder(String s) {
    
    //is the boolean checking whether it will work or not
    boolean output = false;
    //checks if its alphabetical ignoring nonletters
    for (int i = 0; i < s.length(); i = i + 0) {
      if (i == s.length()-1)
        return output = true;        
      if (Character.getNumericValue(s.charAt(i)) > 9 && Character.getNumericValue(s.charAt(i)) < 36 && Character.getNumericValue(s.charAt(i + 1)) > 9 && Character.getNumericValue(s.charAt(i + 1)) < 36) {                    
        
        if (Character.getNumericValue(s.charAt(i)) <= Character.getNumericValue(s.charAt(i + 1)) || Character.getNumericValue(s.charAt(i + 1)) <= 9 && Character.getNumericValue(s.charAt(i + 1)) >= 36) {
          i++;
        }  
        else 
          return output = false;
      } 
      else 
        i++;
    }
    return false;
  }
  
  //takes a string and returns the same string with the specific character removed
  public static String removeNchars(String s, int x, char c) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (Character.getNumericValue(s.charAt(i)) == Character.getNumericValue(c) && x > 0)  {
        x--;
      }
      else if (Character.getNumericValue(s.charAt(i)) != Character.getNumericValue(c) || x == 0) {
        builder.append(s.charAt(i));
        
      }
    }
    return builder.toString();
  }
  
  //takes a string and moves the first specific character to the right one time and returns the string
  public static String moveXright(String s, char c) {
    StringBuilder builder = new StringBuilder();
    //if one has already been moved it becomes true and stops moving others
    boolean finished = false;
    for (int i = 0; i < s.length(); i++) {
      
      if (s.charAt(i) == c && i + 1 != s.length() && finished == false) {
        builder.append(s.charAt(i + 1));
        builder.append(s.charAt(i));  
        i = i + 1;
        finished = true;
      }
      else if (s.charAt(i) != c || i + 1 == s.length() || finished == true) {
        builder.append(s.charAt(i));
      }
    }
    return builder.toString();
  }
  
  //searches through a string for a smaller string and if it is found puts it in brackets
  public static String bracketString(String s, String w) {
    
    //the StringBuilder that will return the new string at the end
    StringBuilder builder = new StringBuilder();
    
    //counts to make sure the loops never search a value outside of the smaller string's length
    int substringcount = 0;
    
    //variable that stores the length of the smaller string
    int sublength = w.length();
    
    //count is used to increment another integer when appending characters ahead of the loop
    //and represents the length of w in the code at times
    int count = 0;
    
    //temp is used to temporarily represent smaller string s's length
    int temp;
    
    //keeps track of the length of the main string s
    int stringcount;
    
    //match will only be true if an entire match is found for a substring so brackets will be appended
    boolean match = false;
    
    for (int i = 0; i < s.length() && substringcount < w.length(); i++) {
      count = 0;
      temp = i;
      if (s.charAt(i) == w.charAt(substringcount)) {
        //this while loop checks for a full match of string w in string s
        while (count < w.length() && temp < s.length() && s.charAt(temp) == w.charAt(count)) {
          if (count == w.length() - 1) {
            match = true;
          }
          else {
            match = false;
          }
          count++;
          temp++;
        }
        count = 0;
        //this only happens when the whole substring is matched
        if (match == true) {
          builder.append("[");
          while (count < w.length()) {
            builder.append(w.charAt(count)); 
            count++;
          }
          builder.append("]");
          count = 0;
          match = false;
          substringcount = 0;
          i = i + w.length() - 1;
        }
        else if (match == false)
          builder.append(s.charAt(i));
      }
      else if (s.charAt(i) != w.charAt(substringcount)) {
        builder.append(s.charAt(i));
      }
    }
    return builder.toString();
  }
  
//moves all of a specified character to the right
  public static String moveAllXsRight(char c, String s) {
    StringBuilder builder = new StringBuilder();
    
    //keeps track of how many times a loop has occurred
    int counter = 0;
    //saves the counter temporarily
    int countsave = 0;
    
    for (int i = 0; i < s.length(); i++) {
      //this is used to see if there are multiple char c in a row
      if (s.charAt(i) == c && i + 1 != s.length()) {
        if (s.charAt(i) == s.charAt(i + 1)) {
          while (s.charAt(i) == c && i + 1 != s.length()) {
            counter++;
            i++;
          }
          i = i - counter;
          countsave = counter;
          while (counter >= 0) {
            builder.append(s.charAt(i + counter));
            counter--;
          }
          i = i + countsave;
          counter = 0;    
        }
        else{
          builder.append(s.charAt(i + 1));
          builder.append(s.charAt(i));  
          i = i + 1;
        }
      }
      else if (s.charAt(i) != c || i + 1 == s.length()) {
        builder.append(s.charAt(i));
      }
    }
    return builder.toString();
  }
//moves x down in the columns of letters input by string s
  public static String moveXdown(char c, String s) {
    
    //StringBuilder for the new string at the end
    StringBuilder total = new StringBuilder();
    
    //the \n to the left of the target
    int Ln = -27;
    
    //the \n to the right
    int Rn = -27;
    
    //the \n to the right of that
    int RRn = -27;
    
    //location of char c
    int target = 0;
    
    //variable used to search through s
    int i = 0;
    total.append(s);
    
    while (i < s.length()) {
      if (s.charAt(i) == c)
        target = i;     
      i++;
    }
    i = target;
    while (i >=0 && Ln == -27) {
      if (s.charAt(i) == '\n')
        Ln = i;
      if (i == 0 && Ln == -27)
        Ln = 0;
      i--;
    }
    i = target;
    while (i < s.length() && Rn == -27){
      if (s.charAt(i) == '\n')
        Rn = i;
      
      i++;
    }
    if (Rn == -27)
      Rn = s.length() - 1;
    if (Rn == s.length() - 1)
      return s;
    
    i = Rn + 1;
    //-27 is a random number picked to error test if the loop was functioning properly
    while (i < s.length() && Rn != s.length() - 1 && RRn == -27){
      if (s.charAt(i) == '\n'){
        RRn = i;
      }
      else if (s.charAt(i) != c && i == s.length() - 1 && RRn == -27)
        RRn = s.length() - 2;
      i++;
    }
    
    if (target - Ln <= (RRn - Rn) || i > -257){
      if (Ln > 0){
        total.setCharAt(target + (Rn - Ln), c);
        total.setCharAt(target, s.charAt(target + (Rn - Ln)));
      }
      else
        total.setCharAt(target + (Rn - Ln) + 1, c);
      total.setCharAt(target, s.charAt(target + (Rn - Ln)));
    }
    
    return 
      total.toString();
  }
  
  public static String moveXleft(String s, char c) {
    StringBuilder builder = new StringBuilder();
    //if one has already been moved it becomes true and stops moving others
    boolean finished = false;
    for (int i = 0; i < s.length(); i++) {
      
      if (s.charAt(i) == c && i != s.length() && finished == false && i - 1 > -1) {
        builder.append(s.charAt(i - 1)); 
        builder.setCharAt(i-1, s.charAt(i));
        finished = true;
      }
      else if (s.charAt(i) == c && i - 1 <= -1) {
        builder.append(s.charAt(i));
      }
      else if (s.charAt(i) != c || i + 1 == s.length() || finished == true) {
        builder.append(s.charAt(i));
      }
    }
    return builder.toString();
  }
  public static String moveXup(char c, String s) {
    //StringBuilder for the new string at the end
    StringBuilder total = new StringBuilder();
    //the \n to the left of the target
    int Ln = -27;
    //the \n to the right
    int Rn = -27;
    //the \n to the left of left
    int LLn = -27;
    //location of char c
    int target = 0;
    //variable used to search through s
    int i = 0;
    total.append(s);
    
    //finds char c's location
    while (i < s.length()) {
      if (s.charAt(i) == c)
        target = i;     
      i++;
    }
    i = target;
    //now 3 relevant \n characters are found for the method to function properly
    //one to the right and two to the left
    while (i >0) {
      if (s.charAt(i) == '\n' && Ln == -27)
        Ln = i;
      i--;
    }
    if (s.charAt(i) != '\n' && Ln == -27)
      Ln = 0;
    i = target;
    while (i < s.length()){
      if (s.charAt(i) == '\n' && Rn == -27)
        Rn = i;
      i++;
    }
    if (Rn == s.length() - 1)
      return s;
    
    i = Ln - 1;
    
    while (i > 0 && Ln != 0 && LLn == -27){
      if (s.charAt(i) == '\n'){
        LLn = i;
      }
      i--;
    }
    if (LLn == -27)
      LLn = 0;
    
    if (Rn - target <= (Ln - LLn) - 1 || i > -575){
      if (Ln > 0){
        total.setCharAt(target, s.charAt(LLn + (target - Ln)));
        total.setCharAt(LLn + target - Ln, c);
      }
      else if (Ln <= 0){
        total.setCharAt(target, s.charAt(LLn + (target - Ln)));
        total.setCharAt(LLn + target - Ln, c);
      }
    }
    
    return 
      total.toString();
  }
  //Method for playing a puzzle game that combines the move x up, down, left, and right methods
  public static void fifteenPuzzle(char c, String s) {
    //String set to equal the scanners input
    String in;
    //scanner for user input for the game
    Scanner input = new Scanner(System.in);
    //trivial initial setting so the loop starts
    in = "asdfasasdf";
    while (!in.equals("q")){
      in = input.nextLine(); 
      if (in.equals("l")){
        s = moveXleft(s, c);
        System.out.print(s);
      }
      else if (in.equals("r")){
        s = moveXright(s, c);
        System.out.print(s);
      }
      else if (in.equals("u")){
        s = moveXup(c, s);
        System.out.print(s);
      }
      else if (in.equals("d")){
        s = moveXdown(c, s);
        System.out.print(s);
      }
      else if (input.next() != "l" &&  input.next() != "r" && input.next() != "u" && input.next() != "d")
        System.out.print("Please enter u, d, l, or r");
      
    }
  }
}
