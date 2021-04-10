package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 4/10/21
 * Time: 9:10 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Utilities {
    /*
    * Returns a char array containing every nth char. When sourceArray.length < n, returns
    * */

    public char[] everyNthChar(char[] sourceArray, int n){
        if (sourceArray == null || sourceArray.length < n){
            return sourceArray;
        }
        int returnedLength = sourceArray.length / n;
        char[] result = new char[returnedLength];
        int index = 0;

        for (int i = n-1; i < sourceArray.length; i+= n){
            result[index++] = sourceArray[i];
        }
        return result;
    }

    /*
    * Remove pairs of the same character that are next to each other, by removing one occurrence of the character
    * ABBCDEEF -> ABCDEF
    * */
    public String removePairs(String source){
        if (source.length() < 2){
            return source;
        }
        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();

        for (int i = 0; i < string.length; i++){
            if (string[i] != string[i++]){
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public int converter(int a, int b){
        return (a / b) + (a * 30) - 2;
    }

    public String nullIfOddLength(String source){
        if (source.length() % 2 == 0){
            return source;
        }
        return null;
    }
}
