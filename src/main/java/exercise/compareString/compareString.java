package exercise.compareString;

import java.util.Scanner;

public class compareString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("단어 2개 입력");
            String str1 = sc.next();
            String str2 = sc.next();

            System.out.println(compareString(str1, str2));
        }
    }

    public static int compareString(String str1, String str2){
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        for(int i=0; i<((c1.length<c2.length) ? c1.length : c2.length); i++){
            if((int)c1[i]-(int)c2[i]>0){
                return 1;
            }
            else if((int)c1[i]-(int)c2[i]<0){
                return -1;
            }
        }

        //앞쪽까지 모두 비교했을때 같은경우 - 긴글을 뒤로 이것도 같으면 리턴0
        if(c1.length>c2.length){
            return 1;
        }
        else if(c1.length<c2.length){
            return -1;
        }
        else
            return 0;
    }
}
