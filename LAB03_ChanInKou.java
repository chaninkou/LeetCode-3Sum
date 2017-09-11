package lab03;


public class LAB03_ChanInKou {

	public static void main(String[] args) 
	{
		int[] array = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};

		int buy = 0;
		int sell = 0;
		int min = 0;
		int max = 0;
		int startDay = 0;
		int EndDay = 0;
		int profit = 0;
		int temp = 0;
		int sum = 0;
		
		for (buy = 0; buy < array.length; buy++){
			for(sell = buy + 1; sell < array.length; sell++){
				if(array[buy] > 0){
					sum += array[buy];
				if(sum < array[sell]){
					temp = array[sell] - array[buy];
					startDay = buy;
					EndDay = sell;
					max = array[buy];
					min = array[sell];
				}
				if(temp > profit){
					profit = temp;
				}
				temp = 0;
				}
			}
			sum = 0;
		}
		System.out.println("Buy at Day " + startDay + " at " + max + " and sell at Day " + EndDay + " at " 
		+ min + " so the profit will be " + profit + ".");
	}
}
