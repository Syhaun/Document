import math

n = int(input())

pi = n * math.sin(math.radians(180 / n))

print(f"{pi:.12f}")