import java.util.Arrays;

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

    public static void main(String[] args){
        //System.out.print(maxProfit(new int[]{7,1,2,3,6,4}));
        //System.out.print(canJump(new int[]{0,2,1,0,4}));
        System.out.print(hIndex(new int[]{0,0,2}));
    }

}
