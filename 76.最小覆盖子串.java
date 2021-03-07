class Solution {
    public String minWindow(String s, String t) {
        if("".equals(s) || "".equals(t)){
            return "";
        }
        int findWindow = 0, start = 0, minWindow = -1, minStart = 0, minEnd = 0;
        int[] hasChar = new int[t.length()];
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){    // 转换为 Map，因为自带的时间复杂度太高了，不适合经常使用
            tMap.put(t.charAt(i), i);
        }
        while(start < s.length() && !tMap.containsKey(s.charAt(start))){
            start++;
        }
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(tMap.containsKey(temp)){   // 记录到数组中
                hasChar[tMap.get(temp)]++;
                if(hasChar[tMap.get(temp)] == 1){   // 第一次出现的字符
                    findWindow++;
                    if(findWindow == t.length()){   // 找到之后
                        int window = i - start + 1;
                        if(minWindow == -1 || window < minWindow){
                            minWindow = window;
                            minStart = start;
                            minEnd = i;
                        }
                        if(start + 1 < i){
                            findWindow--;
                            hasChar[tMap.get(s.charAt(start))]--;
                            temp = s.charAt(start+1);
                            while(start < i && !tMap.containsKey(temp)){
                                start++;
                                temp = s.charAt(start);
                            }
                        }
                    }
                }else{  // 检查
                    temp = s.charAt(start);
                    while(!tMap.containsKey(temp) || (tMap.containsKey(temp) && hasChar[tMap.get(temp)] > 1)){   // 向右收缩
                        if(tMap.containsKey(temp)){
                            hasChar[tMap.get(temp)]--;
                        }
                        start++;
                        temp = s.charAt(start);
                    }
                }
            }
        }
        return minWindow == -1 ? "" : s.substring(minStart, minEnd + 1);
    }
}