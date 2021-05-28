# Algorithm-DataStructure

## (21.1.13) LinkedList 회문 구하기
- 시간복잡도 O(N), 공간복잡도 O(1)
    - 워커 & 러너로 가운데와 맨 끝을 탐색한다. (러너가 null이 아니면 홀수개라는 뜻이니 가운데에서 워커를 한칸 더 전진한다.)
    - 가운데를 기점으로 링크드 리스트를 뒤집는다. (ex 1-2-3-4 -> 4-3-2-1)
    - 뒤집은 곳과 맨 처음 헤더서 부터 비교한다.
- 리트코드 234번

## (20.12.17) 배열의 모든 합
- 각 인덱스를 기준으로 앞선 숫자의 합을 저장한 배열(sum)을 선언한다.
- 특정영역 i~j의 인덱의 합을 구하고자 한다면 sum[j] - sum[i-1];
- 리트코드 303번

## (20.10.22) 위상정렬 (Topology Sort)
- 사이클이 없는 방향그래프 (DAG:Directed Acyclic Graph)의 모든 노드를 방향성에 거스르지 않도록 순서를 나열하는 것
- 예) 선수과목을 고려한 학습 순서
```
    자료구조 ---> 알고리즘
        \          /
         v        v
         고급 알고리즘
```
- 자료구조 -> 알고리즘 -> 고급 알고리즙(O)
- 자료구조 -> 고급알고리즘 -> 알고리즘(x)

- 진입차수(InDegree): 특정한 노드로 들어오는 간선의 갯수
- 진출차수(OutDegree): 특정한 노드에서 나가는 간선의 갯수

### 큐를 이용한 위상 정렬 알고리즘
1. 진입차수가 0인 모든 노드를 큐에 넣는다.
2. 큐가 빌 때까지 다음 과정을 반복한다.
    1) 큐에서 원소를 꺼내 해당 노드에서 나가는 간선을 그래프에서 제거한다.
    2) 새롭게 진입차수가 0이 된 노드를 큐에 넣는다.

- 결과적으로 노드가 큐에 들어온 순서가 위상 정렬을 수행한 결과와 같다.

- 참고 : https://www.youtube.com/watch?v=aOhhNFTIeFI

- 예제 : 리트코드 207

## (20.10.12 ~ 21) UNION-FIND 연산
0. 초기화 : N 개의 원소가 각각의 집합에 포함되어 있도록 초기화 한다.
1. Union (합치기) 연산 : 두 원소 a, b 가 주어질 때, 이들이 속한 두 집합을 하나로 합친다.
    - 각 원소들의 루트를 Find연산으로 찾아낸다. 
    - 두 루트중에 더 작은것을 루트가 되도록 나머지 하나의 루트값을 변경한다. (큰것으로해도 되지만 관례적으로 작은 숫자로 설정)
    - 주의할점은 해당 원소 a,b를 업데이트 하는 것이 아니라, 찾은 **루트**의 루트값을 변경하는 것이다. 
    - 그럼 두개의 원소는 이제 하나의 subset이 된다.
2. Find (찾기) 연산 : 어떤 원소 a 가 주어질 때, 이 원소가 속한 집합을 반환한다.
    - 속한 집합이란 루트가 되는 최상위 원소를 말한다. 즉 같은 루트를 가지고 있다면 같은 집합이다.
    - Find연산은 재귀적으로 실행되는데, 종료조건이 루트가 자기자신인 경우다. 
    - 재귀적으로 호출되면서 루트값을 업데이트한다!! (경로 압축을 통한 시간복잡도 개선)

- 관련문제 : package exercise.programmers.p64063;

### Union-Find 연산으로 서로소 집합(Disjoint Set) 판별하기
- 서로소 집합은 공통 원소가 없는 두 집합을 말한다. (교집합이 공집합)
    - {1, 2} {3, 4} 는 서로소 집합이다.
    - {1, 2} {2, 3}은 공통원소 2가 존재하므로 서로소 집합이 아니다.

- 모든 노드 간선에 대한 합집합(Union)연산을 수행한다.
    - ex) (1,4) (2,3) (2,4) (5,6) 이 간선정보라면
    0. 모든 노드들의 루트노드를 자기 자신으로 설정한다.
    1. (1,4) : 1번의 루트노드 1번과 4번의 루트노드 4번 중 작은 건 1번이므로, 4번의 루트노드를 1번으로 한다. (관례적으로 낮은 숫자를 참조)
    2. (2,3) : 2번의 루트노드 2번과 3번의 루트노드 3번 중 작은 건 2번이므로, 3번의 루트노드를 2번으로 한다.
    3. (2,4) : 2번의 루트노드 2번과 4번의 루트노드 1번 중 작은 건 1번이므로, 2번의 루트노드를 1번으로 한다.
    4. (5,6) : 5번의 루트노드 5번과 6번의 루트노드 6번 중 작은 건 5번이므로, 6번의 루트노드를 5번으로 한다.
  
- 최종 루트노드가 다른 2개의 집합(그래프)로 판별될 수 있다. 그러므로 {1,2,3,4}와 {5,6}은 서로소 집합이다.
- 관련문제: 프로그래머스 43162 (네트워크)

### Union-Find 연산으로 무방향 그래프에서 사이클이 존재하는지 판별하기
- Union Find 전략을 사용하여서 무방향 그래프의 사이클 존재 여부를 확인할 수 있다.
    - (방향그래프에서는 DFS를 수행한다.)
    0. 모든 간선을 탐색하면서,
    1. 루트노드가 서로 다르면, 합집합 연산을 수행한다.
    2. 루트노드가 같다면 싸이클이 존재한다. 
    + 싸이클의 존재를 확인할때마다 서로 다른 싸이클이다. 즉 싸이클이 2번 존재한다고 알아냈으면 서로 다른 싸이클이 2개 존재한다.
    + 만약 큰 테두리를 공유하는 싸이클이 있다면 싸이클은 내부적으로 존재하는 것만 카운팅된다.
        - 예를들어 아래와 같은 그래프가 존재한다면 {1,2,3}, {2,3,4}만 카운팅되고 {1,2,3,4}는 카운팅 되지 않는다.
        ``` 
        1 -- 2
         \ /  \
          3 -- 4
        ```
    
- 관련문제 : 리트코드 959

### 최소신장트리
- 신장트리(spanning tree) : 모든 노드를 포함하면서 싸이클이 존재하지 않는 부분 그래프
- '최소' 신장트리(MST: Minimum Spanning Tree) : 신장트리 중에서 비용이 가장 적은 부분 그래프
- 예) 최소한의 비용으로 모든 도시(노드)를 연결 할 수 있는 경우를 구하라.

#### 크루스칼(Kruskal) 알고리즘으로 최소신장트리 구하기
0. 간선데이터를 비용이 낮은 것부터 오름차순 정렬한다.
1. 간선을 하나씩 확인하면서, 현재 간선이 사이클을 발생시키는지 확인한다. (Union-Find 활용)
    - 만약 사이클을 발생시지 않는다면 최소신장 트리에 포함한다.
2. 모든 간선에 대해서 1번 과정을 수행한다.
- 간선의 갯수가 E일떄 O(ElogE)의 시간복잡도를 갖는다.

- 관련문제 : 리트코드 1584
- 관련문제 : 프로그래머스 42861

- 참고 : https://www.youtube.com/watch?v=aOhhNFTIeFI

## (20.10.16) 재귀탐색 (DFS)시에 주의할점
- 만약 조정해둔 값이 있다면 재귀가 끝난 이후 원복해야한다는 사실을 잊으면 안된다.
- package codingTest.programmers.remote202010.p3;
- 순열구하기

## (20.10.15) 인덱스가 너무 큰경우라면
- 미리 해당 객체를 만들지 말고, 필요한 경우에만 생성하고 Map의 key를 인덱스로 사용하자.
- package exercise.programmers.p64063;
    - 미리 다 업데이트 할필요 없다. 필요한 경우만 업데이트 하면 된다.

## (20.10.09) 최단 경로 구하기 - 플로이드 워셜 (floyd warshall)
- 최단 경로를 탐색하는 그래프 탐색 알고르짐
- '모든'노드에서 모든 노드간의 최소 거리를 알 수 있다.
- 음의 간선이 존재하는 경우도 사용 할 수 있다. (단 음의 싸이클이면 안됨)

1. 노드들 간의 비용을 2차원 배열로 선언한다.
```
for (int throughNode = 0; throughNode < graph.length; throughNode++) {
    //throughNode 거쳐가는 경우
    //a -> b vs a -> node -> b
    for (int i = 0; i < graph.length; i++) {
        for (int j = 0; j < graph[i].length; j++) {
            //거쳐가는게 아닌 경우는 굳이 계산할 필요 없다.
            if (i == throughNode || j == throughNode) {
                continue;
            }

            //이미 0인경우도 굳이 계산할 필요 없다.
            if (graph[i][j] == 0) {
                continue;
            }

            graph[i][j] = Math.min(graph[i][j], graph[i][throughNode] + graph[throughNode][j]);
        }
    }
}
```
2. 2차원 배열의 각 노드간의 최단 경로가 들어가 있음

### 다익스트라 vs 플로이드 워셜
- 모든 경로를 구하더라도, 간선의 갯수가 상당히 많지 않은 이상 다익스트라가 더 빠르다.
    - 다익스트라 O(N*ElogE), 플로이드 워셜 O(N^3)  // N은 노드(정점)의 갯수, E는 간선의 갯수
- 그러나 플로이드 워셜은 음의 간선이 존재하는 경우에도 사용할 수있다.
- 그리고 플로이드 워셜은 상대적으로 구현이 간단하다.

예제코드 : package exercise.graph.floydwarshall;

## (20.10.08) 최단 경로 구하기 - 다익스트라(dijkstra)
- 최단 경로를 탐색하는 그래프 탐색 알고리즘
- 기준이 되는 출발노드에서 모든 노드들의 최소거리를 알 수 있다.
- 음의 간선이 존재하는 경우 사용할 수 없다.
- 우선순위 큐를 활용하면 O(N*logN)이 되므로 우선순위 큐를 활용 (N은 노드의 갯수, E는 간선의 갯)
    - DFS를 쓰면 O(N^N + ElogE), 다익스트라를 쓰면 O(N^2 + ElogE) (리트코드 743기준)

1. 출발(기준)노드의 거리는 0, 나머지는 거리를 무한대 설정한다.
2. 출발노드를 우선순위 큐에 담는다. (큐에 정렬순서는 거리가 낮은 순서다.)
while(큐의 내용이 empty가 아니라면 반복) {
3. 큐에서 노드를 하나 꺼낸다.
4. 노드가 이미 방문한 노드라면 continue; (방문은 큐에서 이전에 이미 꺼내진 경우를 말한다.)
5. 노드의 인접노드들을 순회하면서, 현재 노드에서 발생되는 거리(비용) vs 인접노드의 현재 거리(비용) 중 작은 값을 인접노드의 거리로 설정한다.
    (만약 인접노드 또한 이미 방문했다면 continue)
6. 만약! 인접노드의 거리가 갱신되었다면 (현재 노드에서 이동하는 것이 더 적은 비용이 든다면) 해당 인접노드를 우선순위 큐에 삽입한다.
7. 노드에게 방문처리 플래그를 true로 설정한다.
}

- 예제 프로그래머스 : 가장 먼 노드 (49189)
- 예제 리트코드 : 743

## (20.10.05) 2차원 배열에서 가장 큰 사이즈 정사각형 찾기
![dp find max square](https://leetcode.com/media/original_images/221_Maximal_Square.PNG?raw=true)
- dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
- 예제코드 : 리트코드 221번

## (20.09.30) 가장 긴 회문찾기
- 문자열의 첫번째 char부터 순회를 한다.
- 길이가 짝수인 경우, 홀수인 경우를 나누어서 생각한다.
- 포인터를 2개두고 포인토를 양쪽으로 벌려가면서 회문이 되는지 확인한다.
- 회문이 되지 않는 경우, 이전 포인터들 값으로 subString()한다.
```
private String extend(String s, int i, int j) {
    while (i >= 0 && j < s.length()) {
        if (s.charAt(i) != s.charAt(j)) {
            break;
        }
        i--;
        j++;
    }

    return s.substring(i + 1, j);
}
```

- n번 순회하면서, m번 확장해보니 시간복잡도는 o(nm)이고 최악의 경우도 o(n^2)이 된다.
- 예제코드 : package exercise.leetcode.p5;

## (20.09.29) B tree
- 이진트리의 문제점은 노드의 균형이 맞지 않아 최악의 경우 탐색의 O(n)이 소요된다는 점이다.
- B Tree는 밸런스 트리의 일종으로 노드의 좌우 균형이 잡혀있다.
![B tree Sample](https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/B-tree.svg/800px-B-tree.svg.png)
- 한개의 노드에 여러 자료를 담는다.
- 한 노드의 담긴 자료의 최대 갯수 사이즈를 보통 M으로 표기하며, M차 B트리 라고 한다. (위에 이미지는 4차 B트)
- 홀수차수 B트리와 짝수차수 B트리의 알고리즘은 다르며 보통 홀수차수 B트리를 사용한다. (알고리즘이 더 간결하기 때문)
- B트리 구현 규칙
    - 노드의 자료수가 N개이면, 해당 노드의 자식의 수는 반드시  N+1이어야 한다. (그러므로 자식노드로 향하는 다리(Order)의 갯수도 이미 정해진 상태)
    - 노드 내의 자료들은 정렬된 상태여야 한다.
    - 이진트리처럼 왼쪽 자식노드의 자료들은 부모노드의 자료보다 작아야하고, 오른쪽 자식노드의 자료들은 부모노드의 자료보다 커야한다.

- https://ko.wikipedia.org/wiki/B_%ED%8A%B8%EB%A6%AC 

## (20.08.18) 리트코드 509번 (피보나치)
- 피보나치 메모이제이션 사용시 시간복잡도는 O(N) - 숫자 N은 한번 계산되면 계속 O(1)으로 접근하게 되니
- O(N). Each number, starting at 2 up to and including N, is visited, computed and then stored for O(1) access later on.

## (20.08.17) 리트코드 122번
- Best Time to Buy and Sell Stock II
- 최적의 구간을 찾기위해서 '그래프'를 그려보면 문제를 직관적으로 접근할 수 있었다.

## (20.08.14) 리트코드 53번 - DP
- n번째 상황을 판단할때 앞선 n-1번째 상황을 **sub-problem**으로 잘 생각해냈다.
- DP에서 좋은문제!
- 유사문제 리트코드 152번

## (20.08.13) 리트코드 198번 House Robber - DP
- **sub-problem** + 현재의 문제 접근방식 리트코드 279번 Perfect Square에서도 느꼈다.
- sub-problem으로 생각하면 sub-problem을 DP로 선언할 수 있을 것이다.
- 여기서 sub-problem은, 현재 인덱스가 i일때 0 ~ i-1까지의 최대값을 sub-problem이다.
- i-1에서 훔친경우의 최대값, 훔치지 않은 경우의 최대값으로 나뉠수있다.
- https://www.youtube.com/watch?v=73r3KWiEvyk
- 다시한번 풀어봤으면 하는 문제

## (20.07.31) 리트코드 264번
- 무조건 프로그래밍적으로 접근할려고 하는 편견을 버리지 (무조건, 재귀? DP?.. 이렇게 접근하면 편견이 생김)

0. 기본 요소들은 2,3,5의 값으로 이뤄진다. 곱으로 구한다는 접근은 좋았으나 *사용한 마지막 인덱스를 활용*한다는 생각을 해내지 못함
1. 셋중 가장 작은 값을 선택한다.
2. uglyNumbers의 값으로 1번에서 선택한 값을 넣는다.
3. 가장 작은 값과 일치했을 경우 인덱스를 하나 증가시키고, 증가된 인덱스와 자신의 originFactor를 곱한다.
예제코드: exercise.leetcode.p264

## (20.07.29) 특정한 수의 범위 안에 존재하는 모든 소수 찾기 (에라토테네스의 체)
* 소수찾기
* 소수 2의 모든 배수는 소수가 아니다. 4, 6, 8, 10 ...
* 소수 3의 모든 배수는 소수가 아니다. 3, 6, 9, 12, 15 ...
* 소수 5의 모든 배수는 소수가 아니다. 10, 15, 20 ...
* https://leetcode.com/problems/count-primes/discuss/57588/My-simple-Java-solution

- 시간복잡도 O(log(log(n))
```
O(n/2 + n/3 + n/5 + ... + n/(last prime before n))
= O(n) * O(1/2 + 1/3 + 1/5 + ... + 1/(last prime before n))

What can O(1/2 + 1/3 + 1/5 + ... + 1/(last prime before n)) be simplified to in terms of n?

I won't go into detail here but the answer is essentially bounded by log(log(n)). The proof for this is summed up well here for those interested: http://www.cs.umd.edu/~gasarch/BLOGPAPERS/sump.pdf

So now we have that the time complexity of "crossing out" is:

O(n) * O(1/2 + 1/3 + 1/5 + ... + 1/(last prime before n))
= O(n) * O(log(log(n)))
= O(nlog(log(n)))
```

- 예제코드 exercise.leetcode.p204

## (20.07.26) 리트코드 279번 Perfect Square (완전 제곱수)
- 완전제곱수 : 정수가 정수의 **제곱**으로 표현될 때, (다항식이 다항식의 제곱으로 표현될 때) 완전제곱이라 한다.
    - 예를들어 4는 정수 2의 제곱으로 표현된다. 9는 정수 3의 제곱으로 표현된다. 그러므로 4와 9는 완전제곱이다.
    - 그러나 5, 7, 11, 12.. 는 정수의 제곱으로 표현되지 않는다. 그러므로 완전제곱이 아니다.
    - 주어진 정수가 완전제곱인지 판단하는 방법
    ```
    private boolean isPerfectSquare(int n) {
        double sq = Math.sqrt(n);
        return (sq - Math.floor(sq)) == 0;
    }
    ```
**연습문제 : 리트코드 279번 (까먹었을때 한번 다시 풀어봐야 하는 문제)**
**유사 연습문제 : 리트코드 263번**

## (20.07.24) 코드부터 쓸려는 습관을 버리자
1. 시작전 반드시 수도코드로 로직이 말이 되는지 확인해야 시간을 아낄 수 있다.
2. (연습시에는) 끝나고 시간복잡도 계산

## (20.07.02) 타입캐스팅 시간을 무시하지말자.
- 타입캐스팅 시간을 무시하여서 효율성 검사에 실패함
- 예제코드 package exercise.programmers.dp.tiledecorator;

## (20.07.02) DP
- DP를 하면서 일급컬렉션 같다는 기분이 들었다. 클라이언트가 원하는건 일정한 값인데, 그걸 미리 저장해두었다가 get() 메서드 내부에서 효율적으로 반환하는 과정이!
- 예제코드 package exercise.programmers.dp.tiledecorator;

## (20.06.04) 배열로 주어진 값을 이진 트리로 만들기
```
        0
      /    \
    1       2
   / \     / \
  3   4   5   6
```
- 배열의 인덱스가 위와 같을때, 인덱스 i의 왼쪽자식은 (2 * i) + 1이고, 오른쪽 자식은 (2 * i) + 2이다.
- 인덱스가 홀수면 부모의 왼쪽자식, 짝수면 부모의 오른쪽 자식이다.
- 인덱스 i가 홀수 (왼쪽자식)이면 부모의 인덱스는 (i - 1) /2 이고, 짝수 (오른쪽자식)이면 부모의 인덱스는 (i - 2) / 2이다. 

## (20.03.31) TreepSet시리즈는 동등성을 compareTo를 이용해서 한다.
- Equals()를 통해서 논리적 동치성을 확인하지 않기때문에 조심해야한다. compareTo에 들어가는 비교 필드에 '핵심필드' 들이 모두 들어가야 한다. 안그러면 같은 걸로 판단한.
- 예제코드 package exercise.leetcode.p347;

## (20.03.06) 두개의 트리 병합하기
- 하나의 트리노드가 null이라면, (나머지 생각할 필요없이) 다른 하나를 그대로 반환하면 되는구나!
```
public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
        return t2;
    }

    if (t2 == null) {
        return t1;
    }
    
        ...
}
```
- 참고문제 : 리트코드 617

## (19.12.19) 보이어무어의 과반수 득표 알고리즘
- 과반인 요소를 찾아내는 알고리즘 시간 O(n), 공간 O(1)이다. 사실 그냥 브루트포스로 찾아도 시간 O(n), 공간 O(n)이라 크게 좋은지는 모르겠다.
- 추가적으로 반드시 과반이 존재하는 경우에만 사용해야한다.
    > However, if there is no majority, the algorithm will not detect that fact, and will still output one of the element.
```
public int majorityElement(int[] nums) {
    int x = 0, cnt = 0;

    for (int num : nums) {
        if (cnt == 0) {
            x = num;
            cnt++;
        } else if (x == num) {
            cnt++;
        } else {
            cnt--;
        }
    }

    return x;
}
```
- 연습문제 : 리트코드 169번
- 참고 https://en.wikipedia.org/wiki/Boyer–Moore_majority_vote_algorithm

## (19.12.12) 순열구하기 (다음 오름차순 숫자 구하기)
- 기술면접에서 자주 물어본다는데 - 관련 키워드 렉시컬 솔트?
1. 뒤에서부터 탐색하면서 오름차순이 꺠지는 인덱스를 찾는다. (인덱스 a) 예를들어 1 4 5 4 3 이라면, 1 4(a) 5 4 3
2. 다시 뒤에서부터 탐색하면서 a 보다 큰 첫번쨰 인덱스를 찾는다. (인덱스 b) 예를들어 1 4 5 4 3 이라면 1 4(a) 5(b) 4 3
3. a와 b를 스왑한다.
4. a+1 부터 끝까지 오름차순 정렬한다. 이때 이미 내림찬순 정렬이 되어 있었으므로 첫번쨰와 마지막부터 스왑하면 정렬이 된다. 예를 들어 1 5(a) 4 4 3 이라면 4와 3을 스왑하고 인덱스 하나씩 증가
- 참고문제 : 리트코드 31번

## (19.12.03) 큐로 스택 구현하기
- 큐를 하나만으로 이용하는 방법은 푸쉬를 구현하는데 핵심이 있다.
    1. queue.offer() 하기전에 사이즈를 기록해둔다. 
    2. queue.offer(원소) 한다.
    3. 1번에서 사이즈만큼 queue.offer(queue.remove) 한다.
- 푸쉬의 시간복잡도는 원소의 갯수 n만큼 진행하므로 O(n)이다.
```
public void push(int x) {
    final int size = queue.size();
    queue.offer(x);
    for (int i = 0; i < size; i++) {
        queue.offer(queue.remove());
    }
}
``` 
- 큐 2개를 이용하는 방법도 있다.
- 참고 문제 : 리트코드 225번

## (19.12.01) 정수의 자릿수 구하기
- 정수 n이 0보다 크다면, **10으로 나눈 나머지**가 자릿수다. (n %10)
```
while (n > 0) { // 혹은 (n != 0)
    sum += n % 10;
    n /= 10;
}
```
- 참고 문제 : 프로그래머스 자릿수 더하기 (12931)

## (19.11.28) 스택으로 큐 구현하기              
- 스택2개를 이용한다. (1번 스택, 2번 스택으로 이름을 붙이면,)
- 1번 스택에 푸쉬한 다음, 2번스택으로 다시 밀어넣으면 2번스택에서 pop()되는 순서는 큐와 동일하다.
  - 주의해야 할 점은, 2번스택이 비어있을 때 밀어 넣어야 한다.
- 참고 문제 : 리트 코드 232번

## (19.11.11) Walker & Runner 테크닉(2) - 싸이클을 판단하기 위한 방법
- 시간복잡도 O(n), 공간복잡도 O(1)로 중간지점을 찾는 방법이다.
1. Walker는 한칸씩 전진한다.
2. Runner는 두칸씩 전진한다.
3. Runner가 더 이상 전진하지 못한다면 싸이클이 없지만, Runner와 Walker가 만난다면 싸이클이다.
- 참고 문제 : 리트코드 141번

## (19.11.09) LinkedHashSet vs TreeSet
### LinkedHashSet
- LinkedHashSet은 입력된 '순서'를 기억한다. (List 처럼)
- 하지만 List와 다르게 인덱스는 존재하지 않는다. 그러므로 get() 메소드도 없다.
- Hash Table을 사용하기 때문에 get(), remove(), contain()의 시간복잡도는 O(1)이다.

### TreeSet
- TreeSet은 입력된 순서가 아니라, '정렬된 순서'로 삽입된다.
    ```
    TreeSet<Integer> treeSet = new TreeSet<>();
    treeSet.add(5);
    treeSet.add(4);
    treeSet.add(3);
    treeSet.add(2);
    treeSet.add(1);
    ```
    - 위와 같이 삽입시켜도 1,2,3,4,5의 순서로 정렬 삽입된다.
- 그러므로 TreeSet에 인자로 삽입되기 위해서는 Comparable 인터페이스를 구현해야 한다.
- red-black tree 구조를 사용하기 때문에 get(), remove(), contain()의 시간복잡도는 O(logN)이다.
- 대신 first(), last(), headSet(), tailSet().. 의 메소드를 갖고있다.

- HashSet vs. TreeSet vs. LinkedHashSet 
  - HashSet is Implemented using a hash table. Elements are not ordered. The add, remove, and contains methods has constant time complexity O(1). TreeSet is implemented using a tree structure(red-black tree in algorithm book). The element in a set are sorted, but the add, remove, and contains methods has  time complexity of O(log (n)). It offers several methods to deal with the ordered set like first(), last(), headSet(), tailSet(), etc.  LinkedHashSet is between HashSet and TreeSet. It is implemented as a hash table with a linked list running through it, so it provides the order of insertion. The time complexity of basic methods is O(1).
  - https://dzone.com/articles/hashset-vs-treeset-vs
  
## (19.10.28) character 다루기
- 소문자의 아스키값이 대문자의 아스키 값보다 더 크다. ('a' == 97, 'A' == 65)
- 소문자와 대문자의 차이는 32이고 이건 스페이스 ' '의 값이다. (char)('a' - ' ') = A
- character 연산을 하면 아스키값 숫자(int)로 자동형변환되니, (char)로 명시적 형변환을 다시 해줘야 한다. **(char)**('a' - ' ') = A
- 참고 문제 : 리트코드 784번

## (19.10.26) Least Recently Used (LRU)
- 한정된 저장공간에서 가장 오랫동안 참조되지 않은 자료를 교체하는 캐시 알고리즘
- ex) 숫자를 저장하는 저장공간의 사이즈가 2일때, 1->2->3 을 차례대로 사용 했다면 최근에 사용한 (2, 3)이 저장된다.
- ex) 만약 3을 다시 사용 한다면, 2가 다음번에 교체되는 1순위가 된다. (3, 2)
- 해당 문제 : 리트코드 146번 (더블링크드 리스트를 구현해보는 재밌는 문제 ㅎㅎ)

## (19.10.17) 트리의 깊이(depth)를 알아내는 방법
- 트리의 깊이를 알아내기 위해서는 BFS를 사용하여서, 한 depth의 순회가 끝날 때 마다 depth를 하나씩 추가시킨다.
```
int depth = 0;
Queue<Node> queue = new LinkedList<>();
queue.add(root);

while (!queue.isEmpty()) {
    depth++;
    final int size = queue.size();
    for (int i = 0; i < size; i++) {
        final Node poll = queue.poll();
        if (Objects.requireNonNull(poll).children != null) {
            queue.addAll(poll.children);
        }
    }
}
```
- while 안쪽에 queue의 sizes는 같은 depth에 있었던 노드들의 갯수다.
- 해당 문제 : 리트코드 559번

## (19.10.15) BST (이진검색트리)
- BST (이진검색트리)는 모든 노드의 왼쪽에는 해당 노드보다 작은값이, 오른쪽에는 해당 노드보다 큰값이 들어간다.
- 이런 특징을 이용해서 **이진검색트리를 inorder (중위순회) 하면 작은값부터 큰값까지 순차적으로 순회** 할 수 있다!
- 해당 문제 : 리트코드 530번

## (19.10.12) n개의 요소가 각각 (1 ~ n -1번) 탐색하는 경우의 시간복잡도
- 1번탐색 + 2번탐색 + ... + (n-2번탐색) + (n-1번탐색)
- 합공식으로 단순화 하면 n이 최소 n/2개가 존재하므로 최고차항 n^2을 갖게된다.
- 즉, 시간복잡도는 O(n^2)이 된다. 
- (이미 탐색을 한것이니 n을 다시 곱하지 않는다.) 

## (19.10.11) 2중첩반복문이라도 시간복잡도가 O(n^2)이 아닌 경우
- 해당 문제 : 리트코드 739번
```
for (int i = 0; i < T.length; i++) {
    while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
        answer[stack.peek()] = i - stack.peek();
        stack.pop();
    }
    stack.push(i);
}
```
- 중첩 반복문이라 O(n^2) 혹은 O(NM)이라고 생각했다.
- 그러나 n개의 반복 요소들이 push()되는 횟수가 각 1회, pop()되는 횟수가 각 1회로, 2n이 된다. 즉 시간복잡도는 O(n)이 된다.

## (19.10.10) 비트연산자로 숫자 n의 비트 '1'의 갯수 구하기
1. 숫자 n과 숫자 1을 and(&) 연산하여 가장 우측의 비트가 1인지 0인지 확인하고, 이를 카운팅한다.
2. 숫자 n의 비트를 우측으로 1칸 움직인다.
3. 숫자 n이 0보다 클때까지 반복한다.
```
while (n > 0) {
    count += n & 1;
    n >>= 1;
}
```
- 참고 문제 : 리트코드 461번

## (19.10.07) 동적계획법 (Dynamic Programming)
- 동적계획법을 구현하기 위해서는 **점화식**을 찾아야 한다.
- 참고 문제 : 리트코드 70번

## (19.10.06) 트리 순회 (DFS)
- preorder (전위순회) : SELF, children(left -> right)
- inorder (중위순회) : left -> SELF -> right **(이진 트리인 경우만 가능)**
- postorder (후위순회): children(left -> right), SELF
- 참고 문제 : 리트코드 589번

## (19.10.05)  Walker & Runner 테크닉 - 중간지점을 찾기 위한 방법
- 시간복잡도 O(n), 공간복잡도 O(1)로 중간지점을 찾는 방법이다.
1. Walker는 한칸씩 전진한다.
2. Runner는 두칸씩 전진한다.
3. Runner가 더 이상 전진하지 못할때의 Walker의 위치는 중간지점이다.
- 참고 문제 : 리트코드 876번

## (19.10.03) XOR
- XOR 비트연산자는 비교하는 비트의 연산자가 '다르면' 비트 1을, 같으면 비트 0으로 계산한다.
- 숫자 n과 0을 XOR 연산하면 항상 숫자 n이 나온다. (n^0 = n)
- 숫자 n과 같은 숫자 n을 XOR 연산하면 항상 0이 나온다. (n^n = 0)
- XOR 비트연산자는 교환법칙/결합법칙이 성립한다.(a^b^c^d = d^a^c^b)
- 참고 문제 : 리트코드 136번 Single Number


