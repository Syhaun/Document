n = int(input())
arr = [int(j) for j in input().split()]
maxn = max(arr)
minn = min(arr)
sort = sorted(arr)
if n / 2 == 0:
    mid = sort[len(sort)//2-1]
else:
    mid = sort[(len(sort)+1)//2-1]
sumn = mid+maxn+minn
print(sumn)