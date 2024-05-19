def reverseNumber (num):
    return int(str(num)[::-1])
def isPrime(num):
    if num < 2:
        return False
    for i in range(2, int(num ** 0.5) + 1):
        if num % i == 0:
            return False
    return True
N = int(input())
for n in range(1,N+1):
    if isPrime(n) and reverseNumber(n) == n:
        print(n)