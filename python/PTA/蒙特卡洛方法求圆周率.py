import random

seed, n = input().split()
seed = int(seed)
n = int(n)
random.seed(seed)
points_in_circle = 0
points_in_square = 0
for _ in range(n):
    x = random.uniform(0, 1)
    y = random.uniform(0, 1)
    distance = (x ** 2) + (y ** 2)
    if distance <= 1:
        points_in_circle += 1
    points_in_square += 1
pi_approximation = (points_in_circle / points_in_square) * 4
print("{:.5f}".format(pi_approximation))