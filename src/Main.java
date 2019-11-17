import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество альтернатив: ");
        int aCount = in.nextInt();
        System.out.print("Введите количество критериев: ");
        int cCount = in.nextInt();
        ArrayList<Alternative> altList = new ArrayList();

        int[][] arr = new int[aCount+1][cCount+1];

        for (int i=1; i<=aCount; i++) {
            Alternative alt = new Alternative();
            System.out.println("Введите критерии для альтернативы #" + i + ":");
                for (int j=1; j <= cCount; j++) {
                    System.out.print("Критерий #" + j + ":");
                    arr[i][j] = in.nextInt();
                    alt.criteriaList.add(arr[i][j]);
                }
            altList.add(alt);
        }

        int maxvalue = 0, maxindex = 0;

        System.out.println("----------------------------");
        for (int i =1; i<=aCount; i++) {
            for (int j =1; j<=aCount; j++) {
                altList.get(i-1).priority += arr[i][j];
            }
            System.out.println("Приоритет альтернативы №" + i +": " + altList.get(i-1).priority);
            if (maxvalue < altList.get(i-1).priority) {
                maxindex = i;
                maxvalue = altList.get(i-1).priority;
            }

        }
        System.out.println("----------------------------");
        System.out.println("Наибольший приоритет имеет альтернатива №" + maxindex + ": " + maxvalue);

    }
}
