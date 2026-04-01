package in.JavaBasics.Projects;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    public double add(double a, double b){
        return a+b;
    }
    public double sub(double a, double b){
        return a-b;
    }
    public double mul(double a, double b){
        return a*b;
    }
    public double div(double a, double b){
        if(b==0){
            System.out.println("Error: Cannot divide by zero");
            return Double.NaN;
        }
        return a/b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        CalcHistory calcHis = new CalcHistory();

        Scanner in = new Scanner(System.in);

        System.out.println("Simple Calculator: ");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Show History");
        System.out.println("6. Exit");

        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = in.nextInt();

            if(choice<1 || choice>6){
                System.out.println("Invalid Choice!");
                continue;
            }
            if(choice==5) {
                calcHis.hisPrint();
                continue;
            }
            if(choice==6) break;

            System.out.print("Enter first Number: ");
            double input1 = in.nextDouble();

            System.out.print("Enter second Number: ");
            double input2 = in.nextDouble();

            double result = 0;
            String opr = "";

            switch (choice){
                case 1:
                    result = calc.add(input1, input2);
                    opr = "+";
                    break;
                case 2:
                    result = calc.sub(input1, input2);
                    opr = "-";
                    break;
                case 3:
                    result = calc.mul(input1, input2);
                    opr = "*";
                    break;
                case 4:
                    result = calc.div(input1, input2);
                    opr = "/";
                    break;
            }
            String format = String.format("%.2f", result);

            System.out.println("\nResult: " + result + "\n");
            calcHis.addHis("[ " + input1 + " " + opr + " " + input2 + " = " + format + " ]");

        } while(true);

        System.out.println("\nExiting... Thank You.");

        in.close();
    }
}

class CalcHistory {
    private ArrayList<String> history = new ArrayList<>();
    void addHis(String entry){
        if(history.size()==5){
            history.removeFirst();
        }
        history.add(entry);
    }
    void hisPrint(){
        if(history.isEmpty()){
            System.out.println("No History Available!");
            return;
        }
        for(String s : history) {
            System.out.println(s);
        }
    }
}
