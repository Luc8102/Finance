import java.util.*;
public class SpendingTracker
{
    private double value;
    private String phoneNumber;
    private String category;
    private ArrayList<String> categories;
    
    public static void main(String[] args) { //to test values
    }
    public SpendingTracker(String n) { //setter
      phoneNumber = n;
      categories = new ArrayList<String>(); // or we can do preset
    }
    public void addCategories(String c) {
      categories.add(c);
    }
    public double getValue(String s) {
      int i = s.indexOf(" ");
      value = Double.parseDouble(s.substring(0,i));
      return value;
    } //ends getValue
    public String getPhoneNumber() {
      return phoneNumber;
    } //ends getPhoneNumber
    
}//ends class