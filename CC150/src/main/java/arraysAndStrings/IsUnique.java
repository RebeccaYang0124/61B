package arraysAndStrings;

//implement an algorithm to determine if a string has all unique characters.
//What if you cannot use additional data structures?

import java.util.HashSet;

public class IsUnique {

    public static void main(String[] args){

    }

    public Boolean isUnique1(String input) {
        HashSet<Character> chars = new HashSet<>();
        for (Character a : input.toCharArray()){
            if (chars.contains(a)){
                return false;
            }
            chars.add(a);
        }
        return true;
    }

    public Boolean isUnique2(String input) {
        Boolean result = null;

        return result;
    }

}
