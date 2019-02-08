package com.sillyhat.algorithm.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

/**
 Given two lists A and B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.

 We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.

 These lists A and B may contain duplicates. If there are multiple answers, output any of them.

 For example, given

 A = [12, 28, 46, 32, 50]
 B = [50, 12, 32, 46, 28]
 We should return
 [1, 4, 3, 2, 0]
 as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
 Note:

 A, B have equal lengths in range [1, 100].
 A[i], B[i] are integers in range [0, 10^5].
 */
@Slf4j
public class FindAnagramMappings {

    public static void getRandomNumberArray(){
        Set<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            int number = getRandomNumber();
            while (!numberSet.contains(number)){
                numberSet.add(getRandomNumber());
                break;
            }
        }
        Iterator<Integer> iterator = numberSet.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + ",");
        }
    }

    public static int getRandomNumber(){
        int max = 99;
        int min = 10;
        return new Random().nextInt((max - min) + 1) + min;
//        return min + (int)(Math.random() * (max-min+1));
    }


    public static int[] easyVersion(int[] A, int[] B) {
        int [] result = new int[B.length];
        Map<Integer,Integer> indexBMap = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            indexBMap.put(B[i],i);
        }
        for (int i = 0; i < A.length; i++) {
            result[i] = indexBMap.get(A[i]);
        }
        return result;
    }

    public static int[] anagramMappings(int[] A, int[] B) {
        return null;
    }

    public static void main(String[] args) {
//        FindAnagramMappings.getRandomNumberArray();
//        List<Integer> list = new ArrayList<>();
//        for(Integer a : A){
//            list.add(a);
//        }
//        Collections.shuffle(list);
//        for(Integer i : list){
//            System.out.print(i + ",");
//        }
        int [] A = {66,68,75,12,13,79,15,16,83,19,20,22,89,25,92,29,94,34,37,40,42,44,45,51,53,56,57,58,63};
        int [] B = {42,22,89,13,44,25,63,45,34,58,53,19,20,29,66,12,92,68,79,75,37,15,83,40,56,57,16,94,51};
        int [] result = easyVersion(A,B);
        log.info("easyVersion : {}",result);
        log.info("A      : {}",A);
        log.info("result : {}",result);
    }
}
