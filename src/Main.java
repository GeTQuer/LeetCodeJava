import java.util.*;
import java.util.HashMap;

class MySolution {

    public static int[] TwoSum(int[] nums, int target)
    {
        HashMap<Integer,Integer >list = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            int second_num = target - nums[i];

            if (list.containsKey(second_num))
            {
                return new int[]{list.get(second_num),i};
            }
            list.put(nums[i],i);
        }
        return null;
    }
    public static void rotate(int[] nums, int k) {
        int count_rotate = 0;
        for (int start = 0; count_rotate < nums.length; start++){
            int current = nums[start];
            int index = start;
            while(true){

                int next = (index+k)%nums.length;
                int prev = nums[next];
                nums[next] = current;
                current = prev;
                index = next;
                count_rotate++;

                if (index == start)
                    break;
            }
        }
    }


    public static void main(String[] args) {
        System.out.print(Arrays.toString(TwoSum(new int[]{1,2,3,4},6)));
 //       rotate(new int[]{1,2,3,4,5,6},2);
//        MySolution obj = new MySolution();
//        System.out.println(Arrays.toString(obj.TwoSum(new int[] {2,7,4,5}, 9)));
//        List<Integer> list = new ArrayList<>();
//
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//
//        for (Integer i : list) {
//            if (i == 2) {
//                list.remove(i);
//            }
//        }
    }
//    public Character solution(String input)
//    {
//        HashMap<Character, Integer> list = new HashMap<>();
//
//        for (int i = 0;i < input.length(); i++)
//        {
//            char target = input.charAt(i);
//            int count = input.length() - input.replace(String.valueOf(target),"").length();
//            list.put(target,count);
//            if (count == 1)
//            {
//                return target;
//            }
//        }
//        return null;




//        int count = 0;
//        int ind = 0;
//        while (ind < input.length())
//        {
//            char el = input.charAt(ind);
//            for (int i = 0;i < input.length();i++)
//            {
//                if (input.charAt(i) == el)
//                {
//                    count++;
//                }
//            }
//            if (count > 1)
//            {
//                ind++;
//                count = 0;
//            }
//            else
//                return el;
//        }
//        return null;


    }


//        MySolution obj = new MySolution();
//        System.out.print(obj.solution("aabbc"));
//        Integer a = 128;
//        Integer b = 128;
//
//        System.out.println(a == b);
//        Scanner sc = new Scanner(System.in);
//        String[] input = sc.nextLine().split(" ");
//        int min = 100000000;
//        for (int i = 0; i < input.length-2; i+=2)
//        {
//            int num1 = Integer.parseInt(input[i]);
//            int num2 = Integer.parseInt(input[i+1]);
//            int num3 = Integer.parseInt(input[i+2]);
//            if (num1 + num2 < num1 + num3 && num1+num2 < min)
//                min = num1 + num2;
//            else if (num1 + num3 < num1 + num2 && num1 + num3 < min)
//                min = num1 + num3;
//
//        }
//        System.out.print(min);
//    }
//}