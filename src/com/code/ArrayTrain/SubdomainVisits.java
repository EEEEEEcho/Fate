package com.code.ArrayTrain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();
        for(String domain : cpdomains){
            String[] tmp = domain.split(" ");
            String[] subDomain = tmp[1].split("\\.");
            for (int i = 0;i < subDomain.length;i ++ ){
                StringBuilder sb = new StringBuilder();
                for (int j = i;j < subDomain.length;j ++){
                    sb.append(subDomain[j]);
                    if (j != subDomain.length - 1){
                        sb.append(".");
                    }
                }
                if (map.containsKey(sb.toString())){
                    map.put(sb.toString(),map.get(sb.toString()) + Integer.parseInt(tmp[0]));
                }
                else{
                    map.put(sb.toString(),Integer.parseInt(tmp[0]));
                }
            }
        }
        List<String> result = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }
}
