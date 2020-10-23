package operator_task;

public class Calculator {
	public static void main(String[] args) {
		Operations.add(78, 26);
		Operations.subtract(94, 21);
		Operations.divide(98, 49);
		Operations.equalTo(45, 45);
		Operations.equalTo(45, 92);
		Operations.equalTo("Yogurt", "Yogurt");
		Operations.equalTo("Yogurt", "yogurt");
	}
}
