scores = eval(input())

sort = sorted(scores.items(), key=lambda x:x[1], reverse=True)

print(dict(sort))

average = sum(scores.values())/len(scores)
print(f"平均分={average:.2f}")

print("最高分:")
for key,value in scores.items():
    if value == max(scores.values()):
        print(f"{key}:{value}")