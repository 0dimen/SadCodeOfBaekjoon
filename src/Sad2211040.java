import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수 정렬하기 2 (내림차순): https://www.acmicpc.net/problem/2751
 * 설명 : Quick Sort 재귀.
 * ArrayList -> int[]
 * 입력값 버퍼로 받음.
 *
 * 시간 초과.
 *
 * 다음에 시도할 방법 : 더 빠른 속도의 출력 방식 시도.
 */


public class Sad2211040 {
    static void quickSort(int[] disorderedArray, int maxIndex) {
        if(maxIndex == 0){
            System.out.println(disorderedArray[0]);
            return;
        }

        int compareNum = disorderedArray[maxIndex];

        int[] smallArray = new int[maxIndex+1];//compareNum 보다 작은 값만 저장되는 array
        int[] bigArray = new int[maxIndex+1]; // compareNum 보다 큰 값만 저장되는 array

        int smallIndex = 0; // 다음 값이 들어갈 인덱스
        int bigIndex = 0; // 다음 값이 들어갈 인덱스

        for(maxIndex -= 1;maxIndex >= 0 ;maxIndex--){ // disorderedArray == bigArray, smallArray 만들기
            int indexNum = disorderedArray[maxIndex];

            if(indexNum < compareNum){
                smallArray[smallIndex] = indexNum;
                smallIndex++;
            }
            else{
                bigArray[bigIndex] = indexNum;
                bigIndex++;
            }

        }

        // small,big Array의 최대 Index
        smallIndex--;
        bigIndex--;

        if(smallIndex >= 0)
            quickSort(smallArray, smallIndex);

        if(bigIndex != -1)
            quickSort(bigArray, bigIndex);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] input = new int[N];


        // N개의 입력값 받기
        for (int i = 0; i < N; i++)
            input[i] = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        quickSort(input, N-1);
    }
}