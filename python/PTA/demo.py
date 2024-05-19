def akm(m, n):
    if(m == 0):
        return n + 1;
    if(m > 0 and n == 0):
        return akm(m-1, 1)
    if( n > 0):
        return akm(m - 1, akm(m, n - 1))

#请在这里填写答案
ak={}  #记录已经算过的阿克曼函数结果
m,n=map(int, input().split())
print(akm(m,n))