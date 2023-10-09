import json

# 将字典类型的数据转换为JSON
data = [{"name": "张超", "age": 19}, {"name": "王彦舒", "age": 19}, {"name": "张婷", "age ": 19}]
json_str = json.dumps(data, ensure_ascii=False)
print(type(json_str))
print(json_str)

d = {"name": "周杰伦", "addr": "台北"}
json_str = json.dumps(d, ensure_ascii=False)
print(type(json_str))
print(json_str)
# 将JSON字符串转换为Python数据类型
s = '[{"name": "张超", "age": 19}, {"name": "王彦舒", "age": 19}, {"name": "张婷", "age ": 19}]'
l = json.loads(s)
print(type(l))
print(l)
