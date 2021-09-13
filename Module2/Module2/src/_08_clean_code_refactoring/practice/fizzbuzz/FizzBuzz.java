package _08_clean_code_refactoring.practice.fizzbuzz;

public class FizzBuzz {
    public static void main(String[] args) {
        String result = fizzBuzz(10);
        System.out.println(result);
    }
    public static String fizzBuzz(int number){
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;

        if(isFizz && isBuzz)
            return "FizzBuzz";

        if(isFizz)
            return "Fizz";

        if(isBuzz)
            return "Buzz";

        return number + "";
    }
}
