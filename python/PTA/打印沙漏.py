N, symbol = input().split()
N = int(N)
层数 = 1
总符号数 = 1
while 总符号数 + 2*(层数+2) <= N:
    层数 += 2
    总符号数 += 2 * 层数
for i in range(层数, 0, -2):
    print(" " * ((层数 - i) // 2) + symbol * i)
for i in range(3, 层数+1, 2):
    print(" " * ((层数 - i) // 2) + symbol * i)
unused_symbols = N - 总符号数
print(unused_symbols)