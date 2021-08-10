package Strings;

import com.sun.security.jgss.GSSUtil;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(compression("aabccccaaa"));
        System.out.println(compression("abbbbbbbbbc"));
        System.out.println(Arrays.deepToString(zMatrix(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 0, 1, 2}
        })));
        stringRot("12345", 3);
    }

    public static boolean isUnique(String s){
        boolean u = false;
        // O(n^2)
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < s.length(); j++){
                if (j != i){
                    if (s.charAt(i) == s.charAt(j)) u = true;
                }
            }
        }
        return u;
    }

    public static boolean permu(String s1, String s2){
        // O(2n)
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (Arrays.toString(c1).equals(Arrays.toString(c2))) return true;
        else return false;
    }

    public static String URLify(String s, int size){
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            }
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static String compression(String s){
        HashMap<Character, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
            }
            else {
                hm.put(s.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : hm.entrySet()){
            Character c = entry.getKey();
            Integer j = entry.getValue();
            sb.append(c.toString()).append(j);
        }
        if (sb.toString().length() >= s.length()) return s;
        else return sb.toString();
    }

    public static int[][] zMatrix(int[][] matrix){
        // works but is really inefficient...
        int[][] temp = matrix;
        int[] index = new int[2];
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[row].length; col++){
                if (matrix[row][col] == 0){
                    index[0] = row;
                    index[1] = col;
                }
            }
        }
        for (int row = 0; row < temp.length; row++){
            for (int col = 0; col < matrix[row].length; col++){
                if (row == index[0]) temp[row][col] = 0;
                if (col == index[1]) temp[row][col] = 0;
            }
        }
        return temp;
    }

    // String/array rotation
    public static boolean stringRot(String s1, int n){
        char[] temp = s1.toCharArray();
        char[] t2 = new char[temp.length];

        for (int j = 0; j < n;j++){
            for (int i = 0; i < temp.length; i++){
                if (i == temp.length-1)t2[i] = temp[0];
                else t2[i] = temp[i+1];
            }
            System.out.println(t2);
            temp = t2;
            t2 = new char[temp.length];
        }
        return false;
    }
}
