public class Main {
    public static void main(String[] args) {

    SimpleCalculator calculator=new SimpleCalculator(60,90);
    double firstNumber=calculator.getFirstNumber();

    System.out.println(firstNumber);

    double secondNumber=calculator.getSecondNumber();
    System.out.println(secondNumber);

    calculator.setFirstNumber(99.3);

    firstNumber=calculator.getFirstNumber();

    System.out.println(firstNumber);
    }
}