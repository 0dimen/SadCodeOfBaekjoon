import java.util.ArrayList;
import java.util.Scanner;

// 수 정렬하기 2 (https://www.acmicpc.net/problem/2751)
public class Main{

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); //수의 개수

        ArrayList<Integer> result = new ArrayList(); //결과 저장 배열

        // 수 정렬
        result.add(scan.nextInt());
        for(int i = 1; i < N; i++)
            organizing(scan.nextInt(), result);

        // 결과 출력
        printResult(result);

    }

    public static void organizing(int inputNum, ArrayList<Integer> result){ // 내림차순 정렬이 되어버렸다.
        int index = result.size()/2;
        int moveScale = index / 2;
        while(true){
            if(index == result.size()-1){ // 현 result에서 가장 큰 값인 경우
                if(result.get(index) < inputNum){ // 가장 큰 값인 경우
                    result.add(index+1, inputNum);

//                    System.out.println("현 Result에서 가장 큰 값인 경우");
                    return;
                }
                else{ // result.size == 1 && inputNum이 가장 작은 경우.
                    result.add(0, inputNum);
//                    System.out.println("사이즈 1, 가장 작은 값인 경우.");
                    return;
                }
            }
            else if(index == 0){ // 현 result에서 가장 작은 값인 경우
                if(result.get(0) > inputNum) {
                    result.add(0, inputNum);
//                    System.out.println("현 Result에서 작은 값인 경우");
                    return;
                }
            }

            if(result.get(index) < inputNum) {
                if(result.size()-1 == index){
                    result.add(result.size(), inputNum); // result 마지막 인덱스에 추가
//                    System.out.println("현 Result에서 가장 큰 값인 경우");
                    return;
                }
                if(result.get(index+1) > inputNum){ // 들어갈 자리. result[n] < inputNum < result[n+1]
                    result.add(index+1, inputNum);
//                    System.out.println("들어갈자리 +");
                    return;
                }
                else {// result[n+1]보다 더 큰 경우, 절반 보다 큰 인덱스로 이동
                    index += moveScale;
                    moveScale /= 2;
                    if(moveScale == 0) // 이 구문이 없는 경우 index는 최대 result.size()-2 까지 갈 수 있다. result.size()-1까지 갈 수 있도록 돕는 구문.
                        moveScale = 1;
                }
//                System.out.println(index +" 양의 위치로 이동 ");
                continue;

            }
            else if(result.get(index) > inputNum){
                if(result.get(index-1) < inputNum){
                    result.add(index, inputNum);
//                    System.out.println("들어갈자리 -");
                    return;
                }
                else {// result[n-1]보다 작은 경우, 절반 보다 작은 인덱스로 이동
                    index -= moveScale;
                    moveScale /= 2;
                    if(moveScale == 0) // 이 구문이 없는 경우 index는 최소 1 까지 갈 수 있다. 0까지 갈 수 있도록 돕는 구문.
                        moveScale = 1;
                }
                continue;
            }
        }
    }

    public static void printResult(ArrayList<Integer> result){
        int N = result.size();
        for(int i = N; i>=0; i--)
            System.out.println(result.get(i));
    }

}