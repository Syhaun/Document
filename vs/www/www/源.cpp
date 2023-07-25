//#include <stdio.h>
//#include <string.h>
//
//char numbers[1000][100] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"}; // 数字表，注意要按照题目所给的顺序
//
//int main() {
//    char sentence[100];
//    int nums[20], len, cnt = 0; // nums 数组用于存储句子中出现的数字，cnt 为出现数字的个数
//    int mod = 100; // 取模的值
//    scanf("%[^\n]", sentence); // 读入整个句子
//    len = strlen(sentence);
//    for (int i = 0; i < len; ) { // 遍历整个句子
//        if (sentence[i] >= 'a' && sentence[i] <= 'z') { // 如果当前字符是小写字母，说明可能是数字的开始
//            char word[10];
//            int j = 0;
//            while (sentence[i] >= 'a' && sentence[i] <= 'z' && j < 9) { // 将连续的小写字母读入 word 数组中
//                word[j++] = sentence[i++];
//            }
//            word[j] = '\0';
//            int n = -1;
//            for (int k = 0; k <= 20; k++) { // 判断 word 数组中的单词是否为数字，如果是则将其存储到 nums 数组中
//                if (strcmp(word, numbers[k]) == 0) {
//                    n = k;
//                    break;
//                }
//            }
//            if (n >= 0) { // 如果找到了数字
//                nums[cnt++] = (n * n) % mod; // 将数字的平方取模后存储到 nums 数组中
//            }
//        }
//        else {
//            i++;
//        }
//    }
//    if (cnt == 0) { // 如果句子中没有数字
//        printf("0\n");
//        return 0;
//    }
//    int min_num = 99;
//    for (int i = 0; i < cnt; i++) { // 枚举所有可能的排列，找出最小的数
//        for (int j = i + 1; j < cnt; j++) {
//            int num = nums[i] * 100 + nums[j];
//            if (num < min_num) {
//                min_num = num;
//            }
//        }
//    }
//    printf("%d\n", min_num);
//    return 0;
//}
#include<stdio.h>
void quick_sort(int* arr, int left, int right)
{
	int temp = arr[(left + right) / 2];
	if (left >= right)
		return;
	int i = left;
	int j = right;
	while (i < j)
	{
		while (arr[i] < temp)
			i++;
		while (arr[j] > temp)
			j--;
		if (i <= j)
		{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	quick_sort(arr, i, right);
	quick_sort(arr, left, j);
}
int main()
{
	int n, k;
	int arr[5000000] = { 0 };
	scanf_s("%d%d", &n, &k);

	for (int i = 0; i < n; i++)
	{
		scanf_s("%d", &arr[i]);
	}
	quick_sort(arr, 0, n - 1);
	printf("%d", arr[k]);
	return 0;
}