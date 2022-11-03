import java.util.ArrayList;
import java.util.Scanner;

/**
 * 수 정렬하기 2 (내림차순): https://www.acmicpc.net/problem/2751
 *
 * 설명 : Binary Sort 재귀.
 */

public class Sad2211031 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        ArrayList<Integer> input = new ArrayList<>();


        // N개의 입력값 받기
        for (int i = 0; i < N; i++)
            input.add(scan.nextInt());

        quickSort(input);

    }

    static void quickSort(ArrayList<Integer> disorderedArray) {
        if(disorderedArray.size() == 1){
            System.out.println(disorderedArray.get(0));
            return;
        }

        int index = disorderedArray.size()-1;
        int compareNum = disorderedArray.get(index);
        disorderedArray.remove(index);
        ArrayList<Integer> smallArray = new ArrayList<>();//compareNum 보다 작은 값만 저장되는 array


        for(index -= 1;index >= 0 ;index--){ // disorderedArray == bigArray, smallArray 만들기
            int indexNum = disorderedArray.get(index);

            if(indexNum < compareNum){
                smallArray.add(indexNum);
                disorderedArray.remove(index);
            }
        }

        if(smallArray.size() >= 1)
            quickSort(smallArray);

        System.out.println(compareNum);

        if(disorderedArray.size() != 0)
            quickSort(disorderedArray);
    }

}

