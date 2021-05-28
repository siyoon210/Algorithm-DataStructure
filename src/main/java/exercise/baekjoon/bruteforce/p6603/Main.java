package exercise.baekjoon.bruteforce.p6603;

/*
모든 경우를 놓치지 않고 한번씩 확인해볼려면 어떻게 해야할까?
 -> 출력예제 처럼 오름차순으로 차례대로 한다.

1. 가장 작은 인덱스를 왼쪽에서부터 나열한다.
2. 나열이 끝나면, 가장 오른쪽에있는 자리수 부터 차례대로 인덱스를 하나씩 증가시킨다.
3. 오른쪽 자리수의 인덱스는 왼쪾 자리수의 인덱스보다 항상 크다.
4. 반복은 가장 왼쪽자리에 7번째로 큰 숫자가 오게 되면, 그 뒤로 숫자를 채울수 없으므로 종료한다.
 */
public class Main { //로또
    public static void main(String[] args) {
        int[] inputArr = {1, 2, 3, 5,8,13,21,34};
        printLotto(inputArr);
    }

    public static void printLotto(int[] arr) {
        for (int i = 0; arr.length - i >= 6; i++) {
            for (int j = i + 1; arr.length - j >= 5; j++) {
                for (int k = j + 1; arr.length - k >= 4; k++) {
                    for (int l = k + 1; arr.length - l >= 3; l++) {
                        for (int m = l + 1; arr.length - m >= 2; m++) {
                            for (int n = m + 1; arr.length - n >= 1; n++) {
                                System.out.print(arr[i]+" "+arr[j]+" "+arr[k]+" "+arr[l]+" "+arr[m]+" "+arr[n]);
                                System.out.println();
                            }
                        }
                    }
                }
            }
        }
    }
}

