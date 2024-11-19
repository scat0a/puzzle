import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("간단 숫자 퍼즐");
        int turn = 1;
        Random random = new Random();
        List<Integer> randoms = new ArrayList<>();
        while (true) {
            for (int i = 0; i <= 8; i++) {
                int randomNumber = random.nextInt(8) + 1;
                if (!randoms.contains(randomNumber)) {
                    randoms.add(randomNumber);
                }
            }

            if (randoms.size() == 8) {
                break;
            }
        }

        List<Integer> sorteds = new ArrayList<>(randoms);
        sorteds.sort(Integer::compareTo);

        while (true){
            System.out.println("Turn " + turn);
            System.out.println();
            System.out.println(randoms);
            System.out.println();
            System.out.println("교환할 두 숫자를 입력>");
            System.out.println();

            String inputs = sc.nextLine();
            String[] changes = inputs.split(",");
            //[5, 1, 8, 3, 7, 4, 6, 2]
            // 1,2
            // 5,2,8,3,7,4,7,1
            int[] changeNumbers = new int[changes.length];
            for (int i = 0; i < changes.length ; i++) {
                changeNumbers[i] = Integer.parseInt(changes[i]);
            }
            int index1 = 0;
            int index2 = 0;
            for (int i = 0; i < randoms.size(); i++) {
                if(randoms.get(i) == changeNumbers[0]){
                    index1= i;
                }
                if(randoms.get(i) == changeNumbers[1]){
                    index2 = i;
                }
            }

            int temp = randoms.get(index1);
            randoms.set(index1, randoms.get(index2));
            randoms.set(index2,temp);

            System.out.println(randoms);

            if(randoms.equals(sorteds)){
                System.out.println("축하합니다!"+turn+"턴만에 퍼즐을 완성하셨습니다!");
                break;
            }
            turn++;
        }


    }
}
