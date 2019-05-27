package epi;

public class BuyAndSellStock6_6 {
	public int maxProfit(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;
		
		int maxProfit = 0, minPrice = arr[0];		
		for (int i = 1; i < arr.length; i++) {
			minPrice = Math.min(minPrice, arr[i]);
			maxProfit = Math.max(maxProfit, arr[i] - minPrice);
		}
		
		return maxProfit;
	}
	
	public static void main(String args[]) {
		BuyAndSellStock6_6 obj = new BuyAndSellStock6_6();
		int[] arr = {310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
		
		System.out.println(obj.maxProfit(arr));
	}
}
