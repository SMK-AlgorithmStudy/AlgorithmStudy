# [1번 문제] 정수 N개로 주어진 수열 A와 정수 X가 주어질때, A에서 X보다 큰 수를 모두 출력하는 프로그램을 작성하시오.

# [조건]
# 선택정렬(or 버블정렬)과 이원탐색 원리를 필수로 사용할 것
# X보다 큰 수 가 없을 경우 Error를 출력

# [입력]
# 첫 줄에 공백을 기준으로 A배열의 크기 N과 X가 주어진다.
# 둘째줄에 공백을 기준으로 수열의 첫번째 원소부터 차례로 주어진다.
# N과 X 그리고 수열의 각 원소는 10000보다 작거나 같은 자연수다.

# [출력]
# X보다 큰 자연수를 공백을 기준으로 출력
# 언급한 예외사항을 제외한 어떠한 예외사항도 고려하지 않는다.

# 선택 정렬(Selection Sort)
def selection_sort(N, A):
    for i in range(N):
        # 현재 자리를 가장 작은 값으로 설정
        min = i
        for j in range(i + 1, N):
            # 다음 숫자가 현재 숫자보다 작을 경우, min의 값을 다음 숫자로 변경
            if int(A[min]) > int(A[j]):
                min = j
        A[i], A[min] = A[min], A[i]


# # 이진 탐색(Binary Search)
# # 이진 탐색은 오름차순으로 정렬된 상태에서 시작해야 한다
def binary_search(N, A, X):
    start = 0
    end = N - 1
    answer = []
    while start <= end:
        mid = (start + end) // 2
        if int(A[mid]) > X:
            for i in range(start, end + 1):
                if int(A[i]) > X :
                    answer.append(A[i])
            return answer
        else:
            start = mid + 1
    return answer


# N개의 정수를 입력받고, X보다 큰 수를 찾기 위한 정수 선언
N, X = map(int, input().split())

# 수열 A
list = input()
A = list.split()
if len(A) != N:
    print(N, "개의 숫자를 입력하셔야 합니다.", sep="")

selection_sort(N, A)

B = binary_search(N, A, X)
print(*B)
