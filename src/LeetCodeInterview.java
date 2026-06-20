import java.util.*;

public class LeetCodeInterview {
    public static boolean canJump(int[] nums) {
        int max = 0;
        if (nums.length == 1)
            return true;
        for (int i = 0; i < nums.length-1;i ++){
            if (i > max)
                return false;
            max = Math.max(max,i + nums[i]);
            if (max >= nums.length-1)
                return true;
        }

//        for (int i = 0; i <= nums.length-1; i = i + jump){
//            jump = nums[i];
//            if (i == nums.length-1)
//                return true;
//            if (jump ==0){
//                if (jump < nums.length-1)
//                    return false;
//            }
//        }
        return false;
    }
    public static int maxProfit(int[] prices){
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length;i++){
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
//        int max = 0;
//        for (int start = 0; start < prices.length;start++){
//            int current_price = prices[start];
//            int count = start+1;
//            while(count<prices.length){
//                int temp = prices[count];
//                if (current_price < temp){
//                    if (max < (temp-current_price)){
//                        max = temp-current_price;
//                        count++;
//                    }
//                }
//                else{
//                    count++;
//                    }
//                }
//            }
//         return max;
    }
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;
        int h = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] > h) {
                h++;
            } else {
                break;
            }
        }
        return h;
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> intervals = new ArrayList<>();
        int start= 0;

        String currentString = "";
        for (int i = 0; i < nums.length; i++){
            if (i + 1 < nums.length){
                if (nums[i+1] - nums[i] == 1){
                    if (currentString.isEmpty()) {
                        currentString = nums[i] + "->";
                    }
                }
                else{
                    currentString = (currentString  + Integer.toString(nums[i]));
                    intervals.add(currentString);
                    currentString = "";
                    start = i + 1;
                }
            }
        }
        if (start == nums.length-1){
            intervals.add(Integer.toString(nums[start]));
        }
        else{
            intervals.add(nums[start] + "->" + nums[nums.length-1]);
        }
        return intervals;
    }
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        String str = s.toLowerCase();
        while(start<end){
            char elSt = str.charAt(start);
            char elEn = str.charAt(end);
            if (Character.isLetterOrDigit(elSt)){
                if (Character.isLetterOrDigit(elEn)){
                    if (elSt == elEn){
                        end--;
                        start++;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    end--;
                }
            }
            else{
                start++;
            }
        }
        return true;
    }
    public static boolean isSubsequence(String s, String t) {
        int index = 0;
        for (int i = 0; i < t.length(); i++){
            if (t.charAt(i) == s.charAt(index)){
                index++;
                if (index == s.length())
                    return true;
            }
            if (s.isEmpty())
                return true;
        }
        return false;
    }
    //        int count = t.length();
//        if (s.equals("")){
//            return true;
//        }
//        String result = "";
//        for (int i = 0;i < count; i++){
//            if (s.indexOf(Character.toString(t.charAt(i)))!=-1){
//                result = result + Character.toString(t.charAt(i));
//                System.out.println(result);
//                if (result.contains(s)){
//                    return true;
//                }
//            }
//        }
//        return false;
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <magazine.length(); i++){
            char current = magazine.charAt(i);
            if (!map.containsKey(current)){
                map.put(current,1);
            }
            else{
                map.put(current, map.get(current)+1);
            }
        }
        for (int i = 0; i < ransomNote.length();i++){
            char current = ransomNote.charAt(i);
            if (!map.containsKey(current) || map.get(current) <= 0){
                return false;
            }
            map.put(current,map.get(current)-1);
        }
        return true;
//        // Заменяем HashMap на массив из 26 счетчиков
//        int[] alphabet = new int[26];
//
//        // 1. Наполняем наш склад буквами из журнала
//        for (int i = 0; i < magazine.length(); i++) {
//            int index = magazine.charAt(i) - 'a';
//            alphabet[index]++; // Просто увеличиваем ячейку нужной буквы
//        }
//
//        // 2. Тратим буквы на записку
//        for (int i = 0; i < ransomNote.length(); i++) {
//            int index = ransomNote.charAt(i) - 'a';
//
//            // Если буква закончилась (равна 0), значит её не хватает
//            if (alphabet[index] == 0) {
//                return false;
//            }
//
//            alphabet[index]--; // Забираем одну букву со склада
//        }
//
//        return true;
    }
    }

    public static void main(String[] args){
        System.out.print(canConstruct("aa","aab"));
  //      System.out.print(isSubsequence("ab","baabdsa"));
 //       System.out.print(isPalindrome("A man, a plan, a canal: Panama"));
//        List<String> test = summaryRanges(new int[]{0,2,3,4,5,7,8});
//        System.out.print(test);
        //System.out.print(maxProfit(new int[]{7,1,2,3,6,4}));
        //System.out.print(canJump(new int[]{0,2,1,0,4}));
       // System.out.print(hIndex(new int[]{0,0,2}));
    }

}
