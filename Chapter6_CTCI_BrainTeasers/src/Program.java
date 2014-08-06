
public class Program {
	public static void main(String args[])
	{
		System.out.println("Ddsad");
		Integer[] nums = {3,1,3,8};
		System.out.println(IsExpressionPossible(nums, 0, nums.length - 1, 8, ""));		
	}
	
	private static boolean IsExpressionPossible(Integer[] nums, int start, int end, int evalValue, String expression)
	{
		if (start>end)
			return false;
		else if ((start == end) && (nums[start] == evalValue))		
		{
			System.out.println(expression + nums[start]);
			return true;
		}
		else
		{
			int firstNum = nums[start];
			return (IsExpressionPossible(nums, start+1, end, evalValue-firstNum, expression+nums[start] + "+") 
				|| IsExpressionPossible(nums, start+1, end, -(evalValue-firstNum), expression+nums[start] + "-")
				|| IsExpressionPossible(nums, start+1, end, evalValue/firstNum, expression+nums[start] + "*")
				|| IsExpressionPossible(nums, start+1, end, evalValue*firstNum, expression+nums[start] + "/"));
		}			
	}
}
