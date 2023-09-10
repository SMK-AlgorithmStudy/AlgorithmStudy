
# [2번문제] 다항식 클래스를 만들기 위해 다항식 A, B 2개를 입력 받아 식을 출력하고, 두
# 다항식을 곱셈하여 새로운 다항식 C를 출력한 뒤에 임의의 x값을 입력 받아 다항식 C
# 에 x를 대입한 결과값을 출력하시오.


# [조건]
# 입력 받을 다항식의 계수와 지수는 1~10까지의 자연수만 고려함
# 출력 조건을 유심히 볼 것

# [입력]
# 다항식 입력 시 계수, 지수 순서로 입력 받음
# 다항식 A와 B는 각각 enter로 구분해 입력 받음
# 입력 받을 x값은 자연수만 고려함

# [출력]
# A, B, C를 출력한 뒤에 X값을 입력받음
# 다항식의 곱셈 결과식은 차수가 높은 것부터 내림차순으로 표현될 것
# 차수가 같은 항은 하나의 항으로 합쳐서 결과를 출력할 것


def printPolynomial(poly):
    result = ""
    for i in range(0, len(poly), 2):
        coe = poly[i]
        exp = poly[i + 1]

        if (i == 2):
            result += f"{coe}x^{exp}"
        else:
            result += f"{coe}x^{exp}"
            if coe > 0:
                result += "+"
    return result


def PolyC(A, B, C):
    for i in range(0, len(A), 2):
        coe_a = A[i]
    exp_a = A[i + 1]
    for j in range(0, len(B), 2):
        coe_b = B[j]
        exp_b = B[j + 1]
        new_coe = coe_a * coe_b
        new_exp = exp_a + exp_b
        is_mul = False
        for k in range(0, len(C), 2):
            if C[k + 1] == new_exp:
                C[k] += new_coe
                is_mul = True
                break
        if not is_mul:
            C.extend([new_coe, new_exp])



def multiPoly(C, x):
    result = 0
    for i in range(0, len(C)):
        coe = C[i][0]
        exp = C[i][1]
        result += coe * (x ** exp)
    return result


a_input = input().split()
A = [int(i) for i in a_input]

b_input = input().split()
B = [int(j) for j in b_input]

c = []
for i in range(0, len(A), 2):
    coe_a = A[i]
    exp_a = A[i + 1]
    for j in range(0, len(B), 2):
        coe_b = B[j]
        exp_b = B[j + 1]
        new_coe = coe_a * coe_b
        new_exp = exp_a + exp_b
        is_mul = False
        for k in range(0, len(c), 2):
            if c[k + 1] == new_exp:
                c[k] += new_coe
                is_mul = True
                break
        if not is_mul:
            c.extend([new_coe, new_exp])

C = [(c[i], c[i + 1]) for i in range(0, len(c), 2)]
C.sort(key=lambda x: x[1], reverse=True)

def formatPolynomial(poly):
    result = ""
    for i in range(len(poly)):
        coe = poly[i][0]
        exp = poly[i][1]
        if i != 0:
            if coe > 0:
                result += "+"
        result += f"{coe}x^{exp}"
    return result

print("A:", printPolynomial(A), sep="")
print("B:", printPolynomial(B), sep="")
print("C:", formatPolynomial(C), sep="")

x = int(input("x = "))
print(multiPoly(C, x))
