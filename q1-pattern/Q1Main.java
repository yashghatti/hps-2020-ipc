import java.util.Scanner;

class Q1Main {

    public static void main(String... args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Input:");
        int num = Integer.parseInt(sn.nextLine());

        System.out.println("\nOutput: ");
        for(int i=1; i<=num; i++) {
            for(int j=1; j<=(num - i)*2; j++)
                System.out.print(" ");
            for(int j=1; j<=i; j++)
                System.out.print(j+" ");
            for(int j=(num - (num - i + 1)); j>=1; j--)
                System.out.print(j+" ");
            System.out.println();
        }

        for(int i=num-1; i>=1; i--) {
            for(int j=1; j<=(num - i)*2; j++)
                System.out.print(" ");
            for(int j=1; j<=i; j++)
                System.out.print(j+" ");
            for(int j=(i - 1); j>=1; j--)
                System.out.print(j+" ");
            System.out.println();
        }
    }

}