#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define MAX_N 100

int main() {
    int n;
    scanf("%d", &n);

    int a[MAX_N][MAX_N] = { 0 };
    int x = 0, y = 0;
    int dx[4] = { 0, 1, 0, -1 }, dy[4] = { 1, 0, -1, 0 };
    int d = 0;
    for (int i = 1; i <= n * n; i++) {
        a[x][y] = i;
        int nx = x + dx[d], ny = y + dy[d];
        if (nx < 0 || nx >= n || ny < 0 || ny >= n || a[nx][ny]) {
            d = (d + 1) % 4;
            nx = x + dx[d], ny = y + dy[d];
        }
        x = nx, y = ny;
    }
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%3d", a[i][j]);
        }
        printf("\n");
    }

    return 0;
}
