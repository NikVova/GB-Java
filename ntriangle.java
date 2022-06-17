import java.util.Scanner;
public class ntriangle {
     public static void main(String[] args) {
       
        int n = InputN();
        int res = CalcTriangle(n);
        System.out.printf("Треугольное число для %d будет %d", n, res);

     }
     private static int CalcTriangle(int n) {
        return n*(n + 1)/2;
    }

     public static int InputN() {
        Scanner inputN = new Scanner(System.in);
        System.out.printf("Введите целое число: ");
        while(!inputN.hasNextInt()) {
                System.out.println("Неверный ввод!!!");
                System.out.printf("Введите целое число: ");
                inputN = new Scanner(System.in);
            }
        int n = inputN.nextInt();
        inputN.close();
        return n;
        }
}


