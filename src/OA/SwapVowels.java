package OA;

import java.util.HashSet;
import java.util.Set;

/*
* This question was asked in VMWare 1st round phone interview.
* Question: Interchange vowels in a string, i.e vowel from the start of string with its corresponding vowel from last.
* E.g: "meeting" -> "mieteng", "aeiu" -> "uiea", "apqrhs" -> "apqrhs", "pqrhsa" -> "pqrhsa"
* https://leetcode.com/problems/reverse-vowels-of-a-string/ 
 * */
public class SwapVowels {
    public static void main(String[] args) {
        System.out.println(swapVowels("pqrhsa"));
    }
    public static String swapVowels(String str) {
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        char[] strChars = str.toCharArray();
        int left = 0, right = strChars.length - 1;

        while(left < right) {
            // Moving from left to right till find a vowel
            while(left < right && !vowelSet.contains(strChars[left])) {
                left++;
            }
            // Moving from right to left till find a vowel
            while(left < right && !vowelSet.contains(strChars[right])) {
                right--;
            }

            //Swap the vowels
            char temp = strChars[left];
            strChars[left] = strChars[right];
            strChars[right] = temp;

            // Move the pointers.
            left++;
            right--;
        }
        return String.valueOf(strChars);
    }
}
