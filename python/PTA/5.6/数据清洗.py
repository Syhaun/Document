def clean_sales_data(n, data):
    cleaned_data = []
    seen_records = set()

    for record in data:
        date, product, sales, price = record.split()

        if 'NULL' in (sales, price):
            continue

        record_id = (date, product, sales, price)
        if record_id in seen_records:
            continue
        seen_records.add(record_id)
        cleaned_data.append(record_id)
    print("日期         商品         销量         价格        ")
    for record in cleaned_data:
        date, product, sales, price = record
        print(f"{date:>} {product:>1} {sales:>11}   {price:>11}     ")


n = int(input().strip())
data = [input().strip() for _ in range(n)]

clean_sales_data(n, data)