import java.util.ArrayList;
import java.util.Scanner;

/**
 * 수 정렬하기 2 (내림차순): https://www.acmicpc.net/problem/2751
 *
 * 설명 : Binary Sort (올림차순 sort -> 내림차순으로 출력)
 * 다음에 시도해보고 싶은 방식 : Binary Sort를 하되, 큰 값은 다른 ArrayList에 모아서, 해당 과정을 반복하는 것.
 */


public class Sad2211010 {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        ArrayList<Integer> result = new ArrayList();

        // N개의 입력값 받기
        for(int i = 0; i < N ; i++)
            result.add(scan.nextInt());

        // 오름차순 정렬
        result = sort(result);

        //내림차순으로 출력
        for(int turn = result.size()-1; turn >= 0 ; turn--)
            System.out.println(result.get(turn));

    }

    static ArrayList<Integer> sort(ArrayList<Integer> result){
        int index = 1; // 2번째 요소부터 sort
        int maxIndex = result.size()-1;

        for(; index <= maxIndex; index ++){ // result에 index-1까지의 요소는 sort 되어있다고 가정.
            int compareIndex = index/2; // 비교가 될 binary 인덱스
            int indexValue = result.get(index); // result의 index번째에 들어 있는 요소값.
            int moveScale = compareIndex/2; // compareIndex 이동 scale

            while(true){
                int compareValue = result.get(compareIndex); // result의 비교될 인덱스에 들어 있는 요소값.


                if(indexValue < compareValue){
                    /*
                    - 더 작은 인덱스 값과 비교해야하는 경우
                    - 들어갈 위치인 경우
                    - indexValue 값이 최소인 경우
                    */

                    int preValue;

                    // preValue가 존재하는지 확인
                    try {
                        preValue = result.get(compareIndex-1); // compareIndex의 이전 인덱스 요소 값.
                    }catch (Exception NullPointException){// 최솟값인 경우. 즉, index가 0에 도달한 경우.
                        result = switchIndex(index, 0, result);
                        break;
                    }


                    if(indexValue > preValue){ // 들어갈 위치인 경우.
                        result= switchIndex(index, compareIndex, result);
                        break;
                    }
                    else{ // 더 작은 인덱스 값과 비교해야하는 경우
                        compareIndex -= moveScale;
                        moveScale /= 2;
                        if(moveScale == 0){//이 구문이 없는 경우 비교 Array가 짝수개인 경우, compareIndex는 2 까지 갈 수 있다. 1까지 갈 수 있도록 돕는 구문.
                            moveScale = 1;
                        }
                    }
                }
                else{// indexValue > compareValue
                    /*
                    - 더 큰 인덱스 값과 비교해야하는 경우
                    - 들어갈 위치인 경우
                    - indexValue 값이 최대인 경우
                    */


                    //가장 큰 값인 경우
                    if(compareIndex == index-1){//가장 큰 값인 경우.
                        break;//compareIndex + 1 == index이기 때문에, 그대로 있으면 됨.
                    }

                    int nextValue = result.get(compareIndex+1);


                    if(indexValue < nextValue){ //들어갈 위치인 경우
                        result = switchIndex(index, compareIndex+1, result);
                        break;
                    }
                    else{ // 더 큰 인덱스 값과 비교해야하는 경우.
                        compareIndex += moveScale;
                        moveScale /= 2;
                        if(moveScale == 0){//이 구문이 없는 경우 비교 Array가 짝수개인 경우, compareIndex는 index-2 까지 갈 수 있다. index-1까지 갈 수 있도록 돕는 구문.
                            moveScale = 1;
                        }
                    }
                }
            }
        }
        return result;
    }

    static ArrayList<Integer> switchIndex(int nowIndex, int switchIndex, ArrayList<Integer> result){// ArrayList에서 요소 값 위치 변경. (끼워넣기.)
        // ex) 1,2,3,4에서 4를 1과 2 사이에 끼워넣음. -> 1, 4, 2, 3

        if(switchIndex < nowIndex){
            result.add(switchIndex, result.get(nowIndex));
            result.remove(nowIndex+1);
        }
        else{ // switchIndex > nowIndex인 경우.
            result.add(switchIndex, result.get(nowIndex));
            result.remove(nowIndex);
        }

        return result;

    }

}

