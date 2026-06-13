import java.math.BigInteger;
import java.sql.Array;
import java.util.*;
import java.util.Arrays.*;

public class Kata {
    public String expandedForm(int num) {
        String lenNum = Integer.toString(num);
        int ourLen = lenNum.length();
        String result = "";
        if (ourLen > 1) {
            for (int i = 0; i < ourLen; i++) {
                if (lenNum.charAt(i) != '0')
                    result = result + (lenNum.charAt(i) + Integer.toString((int) (Math.pow(10, ourLen - i - 1))).substring(1) + " + ");
            }
            if (result.endsWith(" + ")) {
                result = result.substring(0, result.length() - 3);
            }
            return result;
        }
        return lenNum;
    }

    public static double findUniq(double arr[]) {
        HashMap<Double, Integer> dict = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (dict.containsKey(arr[i]))
                dict.put(arr[i], dict.get(arr[i]) + 1);
            else
                dict.put(arr[i], 1);
        }
        for (double key : dict.keySet()) {
            if (dict.get(key) == 1)
                return key;
        }
        return 0.0;
    }

    public static Map<Character, Integer> count(String str) {
        Map<Character, Integer> countSymbol = new HashMap<>();

        for (char symbol : str.toCharArray()) {

            countSymbol.put(symbol, countSymbol.getOrDefault(symbol, 0) + 1);
        }

        return countSymbol;
    }

    public static int findIt(int[] a) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i]))
                map.put(a[i], map.get(a[i]) + 1);
            else
                map.put(a[i], 1);
        }
        for (Integer num : map.keySet()) {
            if (map.get(num) % 2 != 0)
                return num;
        }
        return 0;
    }

    public static boolean comp(int[] a, int[] b) {
        if (a.length != b.length || a == null || b == null)
            return false;
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.abs(a[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            if (a[i] * a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static String toBinaryFromString(String number) {
        int num = Integer.valueOf(number);
        if (num == 0)
            return "00000000";

        String binary = "";
        while (num > 0) {
            binary = (num % 2) + binary;
            num = num / 2;
        }
        while (binary.length() < 8) {
            binary = "0" + binary;
        }
        return binary;
    }

    public static long ipsBetween(String start, String end) {
        String[] st = start.split("\\.");
        String[] en = end.split("\\.");
        String fullStart = "";
        String fullEnd = "";
        for (int j = 0; j < 4; j++) {
            fullStart += toBinaryFromString(st[j]);
            fullEnd += toBinaryFromString(en[j]);
        }
        long startL = Long.parseLong(fullStart, 2);
        long endL = Long.parseLong(fullEnd, 2);
        System.out.print(startL + " " + endL);
        long count = endL - startL;
        return count;
    }

    public static int sumIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        for (int i = 0; i < intervals.length; i++){
            System.out.print(Arrays.toString(intervals[i]));
        }

        int totalSum = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 0; i < intervals.length - 1; i++) {
            int nextStart = intervals[i + 1][0];
            int nextEnd = intervals[i + 1][1];
            if (nextStart < end) {
                if (nextEnd > end)
                    end = nextEnd;
            } else {
                totalSum += (end - start);
                start = nextStart;
                end = nextEnd;
            }
        }
        totalSum += (end - start);
        return totalSum;
    }

    public static int maxNumberIndex(int[] array, int max) {

        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max) {
                index = i;
                break;
            }
        }
        return index;

    }

    public static int longestSlideDown(int[][] pyramid) {
        for (int i = pyramid.length - 2; i >= 0; i--) {

            for (int j = 0; j < pyramid[i].length; j++) {

                if (pyramid[i + 1][j] > pyramid[i + 1][j + 1]) {
                    pyramid[i][j] += pyramid[i + 1][j];
                } else {
                    pyramid[i][j] += pyramid[i + 1][j + 1];
                }
            }
        }
        return pyramid[0][0];
//        int total = pyramid[0][0];
//        int currentIndex = 0;
//        for (int i = 1; i < pyramid.length; i++){
//            int leftOption = pyramid[i][currentIndex];
//            int rightOption = pyramid[i][currentIndex + 1];
//            if (leftOption > rightOption) {
//                total += leftOption;
//            }
//            else {
//                total += rightOption;
//                currentIndex = currentIndex + 1;
//            }
//        }

    }

    public static int lastDigit(BigInteger n1, BigInteger n2) {
        if (n1.equals(BigInteger.ZERO))
            return 0;
        if (n2.equals(BigInteger.ZERO))
            return 1;
        return n1.modPow(n2, BigInteger.TEN).intValue();

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode current = start;
        int num = 0;

        while (l1 != null || l2 != null || num != 0) {
            int sum = num;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            num = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        return start.next;
    }

    public boolean isPalindrome(int x) {
        String num = Integer.toString(x);
        for (int i = num.length() - 1; i > 0; i--) {
            if (num.charAt(i) != num.charAt(num.length() - i - 1))
                return false;
        }
        return true;
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int current_num = map.get(s.charAt(i));
            if (i + 1 < s.length()) {
                int next_num = map.get(s.charAt(i + 1));
                if (current_num < next_num) {
                    total -= current_num;
                } else {
                    total += current_num;
                }
            } else {
                total += current_num;
            }
        }
        return total;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            // Проверяем этот символ во всех остальных словах
            for (int j = 1; j < strs.length; j++) {
                // Если текущее слово закончилось ИЛИ символ не совпал
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    // Возвращаем часть первого слова от начала до текущего индекса i
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static int removeDuplicates(int[] nums) {
        int uniq = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniq] = nums[i];
                uniq++;
            }
        }
        return uniq;
    }

    public static int strStr(String haystack, String needle) {
        int index = 0;
        String current = "";
        while (index < haystack.length()) {
            current += haystack.charAt(index);
            if (current.equals(needle))
                return index - needle.length() + 1;
            if (!needle.startsWith(current)) {
                index = index - current.length() + 1;
                current = "";
            }
            index++;
        }
        return -1;
    }

    public static int[] plusOne(int[] digits) {
        int plus = 1;
        int[] result_massive = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; i--) {
            int current = digits[i] + plus;
            result_massive[i + 1] = current % 10;
            plus = current / 10;
        }
        if (plus > 0) {
            result_massive[0] = plus;
            return result_massive;
        }
        return Arrays.copyOfRange(result_massive, 1, result_massive.length);
    }

    public static String addBinary(String a, String b) {
        while (a.length() != b.length()) {
            if (a.length() < b.length())
                a = "0" + a;
            else
                b = "0" + b;
        }
        String result = "";
        String ost = "0";
        for (int i = a.length() - 1; i >= 0; i--) {
            char x = a.charAt(i);
            char y = b.charAt(i);

            if (x == '0' && y == '0') {
                if (ost.equals("1")) {
                    result = "1" + result;
                    ost = "0";
                } else {
                    result = "0" + result;
                }
            } else if (x == '1' && y == '1') {
                if (ost.equals("1")) {
                    result = "1" + result;
                } else {
                    result = "0" + result;
                }
                ost = "1";
            } else {
                if (ost.equals("1")) {
                    result = "0" + result;
                    ost = "1";
                } else {
                    result = "1" + result;
                }
            }
        }
        if (ost.equals("1"))
            result = "1" + result;
        return result;

    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next!= null){
            if (current.val == current.next.val){
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }
        }
        return head;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;        // последний реальный элемент nums1
        int j = n - 1;        // последний элемент nums2
        int k = m + n - 1;    // конец nums1

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        System.out.print(Arrays.toString(nums1));
    }
//        int index1 = 0;
//        int index2 = 0;
//        while (index1 < (m+n) && index2 < n){
//
//            if (nums1[index1] == 0){
//                nums1[index1] = nums2[index2];
//                index2++;
//            } else if (nums1[index1] > nums2[index2]) {
//                int current = nums1[index1];
//                nums1[index1] = nums2[index2];
//                nums2[index2] = current;
//                Arrays.sort(nums2);
//            }
//            index1++;

    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max_val = -1;
        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i])+1);
            }
            if (map.get(nums[i]) > max_val)
                max_val = map.get(nums[i]);
        }
        for (int n: map.keySet()){
            if(map.get(n) == max_val){
                return n;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        merge(nums1, 3, new int[]{2,5,6}, 3);
//        ListNode test = new ListNode(1);
//        test.next = new ListNode(1);
//        test.next.next = new ListNode(1);
//        test.next.next.next = new ListNode(2);
//        test.next.next.next.next = new ListNode(3);
//        ListNode result = deleteDuplicates(test);
//        printList(result);
 //       System.out.print(addBinary("1010", "1011"));
//        int[] result = plusOne(new int[]{1,9,9});
//        System.out.print(Arrays.toString(result));


        //System.out.print(strStr("aASAADAS","sad"));
        //System.out.print(removeDuplicates(new int[]{1,1,2}));
//        System.out.print(longestSlideDown(new int[][]
//                {
//                        {3},
//                        {7,4},
//                        {2,4,6},
//                        {8,5,9,3},
//
//                }));
//        System.out.print(sumIntervals(new int [][]
//                {
//                        {20,30},
//                        {1, 5},
//                        {7,10},
//                        {3,6}
//                }));
//        System.out.print(Kata.ipsBetween("10.0.0.0", "10.0.0.50"));
//        System.out.print(comp(new int[]{121, 144, 19, 161, 19, 144, 19, 11},
//                new int[]{121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19, 11*11}));
//      System.out.print(Kata.findIt(new int[]{1,2,3}));
//        System.out.print(Kata.count("aabb"));
//        System.out.print(Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }));
//        Kata kata = new Kata();
//        System.out.print(kata.expandedForm(45));
    }

}
