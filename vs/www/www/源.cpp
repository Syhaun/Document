//#include <stdio.h>
//#include <string.h>
//
//char numbers[1000][100] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"}; // ���ֱ�ע��Ҫ������Ŀ������˳��
//
//int main() {
//    char sentence[100];
//    int nums[20], len, cnt = 0; // nums �������ڴ洢�����г��ֵ����֣�cnt Ϊ�������ֵĸ���
//    int mod = 100; // ȡģ��ֵ
//    scanf("%[^\n]", sentence); // ������������
//    len = strlen(sentence);
//    for (int i = 0; i < len; ) { // ������������
//        if (sentence[i] >= 'a' && sentence[i] <= 'z') { // �����ǰ�ַ���Сд��ĸ��˵�����������ֵĿ�ʼ
//            char word[10];
//            int j = 0;
//            while (sentence[i] >= 'a' && sentence[i] <= 'z' && j < 9) { // ��������Сд��ĸ���� word ������
//                word[j++] = sentence[i++];
//            }
//            word[j] = '\0';
//            int n = -1;
//            for (int k = 0; k <= 20; k++) { // �ж� word �����еĵ����Ƿ�Ϊ���֣����������洢�� nums ������
//                if (strcmp(word, numbers[k]) == 0) {
//                    n = k;
//                    break;
//                }
//            }
//            if (n >= 0) { // ����ҵ�������
//                nums[cnt++] = (n * n) % mod; // �����ֵ�ƽ��ȡģ��洢�� nums ������
//            }
//        }
//        else {
//            i++;
//        }
//    }
//    if (cnt == 0) { // ���������û������
//        printf("0\n");
//        return 0;
//    }
//    int min_num = 99;
//    for (int i = 0; i < cnt; i++) { // ö�����п��ܵ����У��ҳ���С����
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