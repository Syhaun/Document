T = int(input())
for i in range(T):
    a, b = map(int, input().split())
    result = []
    for i in range(a, b+1):
        if i % 3 == 2 and i % 7 == 1:
            result.append(i)
    if len(result) > 0:
        print(" ".join(map(str,result)))
    else:
        print("none")
