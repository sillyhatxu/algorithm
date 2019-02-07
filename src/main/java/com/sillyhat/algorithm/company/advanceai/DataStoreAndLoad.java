package com.sillyhat.algorithm.company.advanceai;

import java.util.*;

public class DataStoreAndLoad {

    public static void main(String[] args){
        String input = "key1:value1;key2:value2\nkey3:value3\nkey4:value4\nkey5:value5\n";
        Map[] outputMap = load(input);//O(n)
        for(Map map : outputMap){
            System.out.println(map);
        }
        String output = store(outputMap);//O(n)^2
        System.out.println(output);
    }

    private static String store(Map<String,String> [] mapArray){
        StringBuilder result = new StringBuilder();
        for (Map<String,String> map : mapArray) {
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                String key = entry.getKey().toString();
                String val = entry.getValue().toString();
                result.append(key).append("=").append(val).append(";");
            }
            result.deleteCharAt(result.length() - 1);
            result.append("\n");
        }
        return result.toString();
    }

    public static Map[] load(String input){
        List<Map<String,String>> result = new ArrayList<>();
        boolean flag = false;
        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();
        Map<String, String> tmpMap = new HashMap<>();
        for(int i =0; i< input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '='){
                flag = true;
                continue;
            }
            if(ch == ';'){
                tmpMap.put(key.toString(),value.toString());
                flag=false;
                key.setLength(0);
                value.setLength(0);
                continue;
            }
            if(ch == '\n'){
                tmpMap.put(key.toString(),value.toString());
                flag=false;
                key.setLength(0);
                value.setLength(0);
                result.add(tmpMap);
                tmpMap = new HashMap<>();
                continue;
            }
            if(flag){
                value.append(ch);
            } else {
                key.append(ch);
            }
        }
        return result.toArray(new Map[0]);
    }


}
