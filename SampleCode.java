import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class SampleCode {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while(true){
            answer(input.nextLine());
        }
    }

    public static void answer(String s){
        Queue<number> operands = new LinkedList<number>();
        Queue<String> operators = new LinkedList<String>();
        String[] str = s.split(" ");
        for(int i = 0; i < str.length; i++){
            if(i%2 == 0){
                if(str[i].contains("/")){
                    operands.add(new number(Integer.parseInt(str[i].substring(0,1)), Integer.parseInt(str[i].substring(2,3))));
                }
                else operands.add(new number(Integer.parseInt(str[i])));
            }
            else operators.add(str[i]);
        }
        String operator = "";
        
        while(!operands.isEmpty() && operators.size() > 0){
            number num1 = operands.remove();
            number num2 = operands.remove();
            operator = operators.remove();
            switch(operator){
                case "+":
                if(num1.denominator == num2.denominator){
                    operands.add(new number(num1.numerator + num2.numerator, num1.denominator));
                }
                else operands.add(new number(num1.numerator + num2.numerator, num1.denominator * num2.denominator ));
                break;
                case "-":
                if(num1.denominator == num2.denominator){
                    operands.add(new number(num1.numerator - num2.numerator, num1.denominator));
                }
                else operands.add(new number(num1.numerator - num2.numerator, num1.denominator * num2.denominator ));
                break;
                case "/":
                operands.add(new number(num1.numerator * num2.denominator, num1.denominator * num2.numerator ));
                break;
                default: 
                operands.add(new number(num1.numerator * num2.numerator, num1.denominator * num2.denominator ));
            }

        }
        System.out.println(operands.remove());
    }   
}

