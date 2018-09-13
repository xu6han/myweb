package br.com.restful.resource;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Test {

	public static void main(String[] args){
        String chars = "aabbccddddddda";
        String result = FindUtil.findMax(chars);
        System.out.println(result);
    }
	
	public Test() {
		String s = "adfoweyirlkbasgxalueralsdhg"; // 待统计字符串
		int max = 0; // 记录最大出现次数
		int[] cnt = new int[127]; // 临时计数用的数组
		for (int i = 0; i < s.length(); i++) { // 循环字符以做统计
			char c = s.charAt(i); // 取出单个字母
			max = (++cnt[c] > max) ? cnt[c] : max; // 计数并检测最大出现次数
		}
		System.out.println(max);
	}
}


class FindUtil {
    public static String findMax(String str){
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char i : chars){
            if(map.get(i)==null){
                map.put(i, 1);
            } else {
                int num =map.get(i);
                num++;
                map.put(i, num);
            }
        }
        LinkedList<Object[]> list =new LinkedList<Object[]>();
        for(Iterator<Character> iterator = map.keySet().iterator();iterator.hasNext();){
            Object[] arr = new Object[2];
            char charac = iterator.next();
            int num = map.get(charac);
            arr[0] = charac;
            arr[1] = num;
            list.add(arr);
        }

        int first = (Integer)list.get(0)[1];
        for(int j=1;j<list.size();j++){
            int second = (Integer)list.get(j)[1];
            if(first < second){
                Object[] bb = list.get(j);
                list.remove(0);
                list.add(0, bb);
            }
        }
        String ss = "出现次数最多的字母是：" + list.get(0)[0].toString() + ",出现次数是：" + list.get(0)[1].toString();
        return ss;
    }
    
    
    
}
