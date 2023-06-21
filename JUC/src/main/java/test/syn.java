import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> results;
    StringBuffer result;

    //字段合法条件：1、单0；2、字段长度大于1，且首字母不能为0
    public List<String> restoreIpAddresses(String s) {
        results = new ArrayList<>();
        result = new StringBuffer();
        int len = s.length();
        int size = 3;
        for (int first = 0; first < size && first < len; first++) {
            if (Integer.valueOf(s.substring(0, first + 1)) <= 255 && ((first != 0 && s.charAt(0) != '0') || (first == 0))) {
                result.append(s.substring(0, first + 1) + ".");
                for (int second = first + 1; second < size * 2 && second < len; second++) {
                    if (Integer.valueOf(s.substring(first + 1)) <= 255 && ((second != first + 1 && s.charAt(second) != '0') || (second == first))) {

                        for (int third = second + 1; third < size * 3 && third < len; third++) {
                            for (int last = third + 1; last < size * 4 && last < len; last++) {

                            }
                        }
                    }
                    result.delete(result.length() - first - 2, result.length());
                }
            }
        }
        return results;
    }
}