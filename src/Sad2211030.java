import java.util.ArrayList;
import java.util.Scanner;

/**
 * 수 정렬하기 2 (내림차순): https://www.acmicpc.net/problem/2751
 * <p>
 * 설명 : Quick Sort로 추정. 시간 초과...
 */


public class Sad2211030 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        ArrayList<ArrayList> result = new ArrayList<>();
        ArrayList<Integer> input = new ArrayList<>();


        // N개의 입력값 받기
        for (int i = 0; i < N; i++)
            input.add(scan.nextInt());
        result.add(input);

        result = quickSort(result);

        for(int i = 0; i < N-1; i++)
            System.out.println(result.get(i));


    }

    static ArrayList<ArrayList> quickSort(ArrayList<ArrayList> result) { // result의 최대 index

        for (int resultIndex = 0; resultIndex <= result.size() - 1; resultIndex++) {
            System.out.println(result);
            if (result.get(resultIndex).size() == 1) // 이미 정렬된 array인 경우. 다음 index로 이동.
                continue;

            ArrayList<Integer> array = result.get(resultIndex); // 정렬해야하는 요소가 들어있는 배열이자, compareNum보다 큰 값이 남을 배열.

            ArrayList<Integer> smallArray = new ArrayList<>(); // array의 마지막 값보다 작은 값의 배열

            // array 정렬.

            int compareNum = array.get(array.size() - 1); // array의 마지막 값.
            array.remove(array.size()-1);

            for (int arrayIndex = array.size()-1; arrayIndex >= 0; arrayIndex--) {
                if (array.get(arrayIndex) < compareNum) {
                    smallArray.add(array.get(arrayIndex));
                    array.remove(arrayIndex);
                }
            }
            // 정렬된 array add
            ArrayList<Integer> compareNumArray = new ArrayList<>();
            compareNumArray.add(compareNum);
            result.add(resultIndex, compareNumArray);
            int indexChangedValue = 0; // add를 통해 변한 index 값 보정용.
            if (smallArray.size() != 0) {
                result.add(resultIndex, smallArray);
                indexChangedValue++;
            }
            if (array.size() == 0) {
                result.remove(resultIndex+indexChangedValue + 1);
            }
            resultIndex -= indexChangedValue;

        }
        return result;
    }
}

