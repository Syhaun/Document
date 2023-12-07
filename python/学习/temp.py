def countQueue(X, Y):
    N = X + Y
    dp = [[0] * (Y + 1) for _ in range(N + 1)]
    dp[0][0] = 1

    for i in range(1, N + 1):
        dp[i][0] = 1

    for i in range(1, N + 1):
        for j in range(1, Y + 1):
            dp[i][j] = dp[i-1][j] + dp[i-1][j-1]

    return dp[N][Y]

X = 2  # 带了2元的小朋友数量
Y = 3  # 带了1元的小朋友数量

result = countQueue(X, Y)
print("小朋友排队的方法数量为:", result)