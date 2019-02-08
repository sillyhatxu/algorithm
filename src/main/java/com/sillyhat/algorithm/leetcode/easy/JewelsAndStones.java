package com.sillyhat.algorithm.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

 The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

 Example 1:

 Input: J = "aA", S = "aAAbbbb"
 Output: 3
 Example 2:

 Input: J = "z", S = "ZZ"
 Output: 0
 Note:

 S and J will consist of letters and have length at most 50.
 The characters in J are distinct.
 */
@Slf4j
public class JewelsAndStones {

    public static int soEasyVersion(String J, String S){
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char s = S.charAt(i);
            for (int k = 0; k < J.length(); k++) {
                char j = J.charAt(k);
                if(s == j){
                    count++;
                    System.out.print(s);
                    break;
                }
            }
        }
        return count;
    }

    public static int soEasyVersion2(String J, String S){
        Set<Character> jewelSet = new HashSet<>();
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            jewelSet.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if(jewelSet.contains(S.charAt(i))){
                count++;
            }
        }
        return count;
    }

    public static int numJewelsInStones(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }

    public static void main(String[] args) {
        String J = "aAYlspnM";
        String S = "aAYlsqweRTYUIosplkjhgDbVmxNZpnM";
        log.info("soEasyVersion count : {}",soEasyVersion(J,S));
        log.info("soEasyVersion2 count : {}",soEasyVersion2(J,S));
        log.info("numJewelsInStones count : {}",numJewelsInStones(J,S));
    }
}
