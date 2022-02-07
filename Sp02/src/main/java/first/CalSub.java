package first;

public class CalSub implements Calculator{

	@Override
	public int cal(int firstNum, int secondNum) {
		int result;
		result = firstNum - secondNum;
		return result;
	}

}
