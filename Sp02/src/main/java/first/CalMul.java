package first;

public class CalMul implements Calculator{

	@Override
	public int cal(int firstNum, int secondNum) {
		int result;
		result = firstNum * secondNum;
		return result;
	}

}
