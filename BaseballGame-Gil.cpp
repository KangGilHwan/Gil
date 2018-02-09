#include <stdio.h>
#include <stdlib.h>
#include<conio.h>
#include <time.h>
#pragma warning(disable:4996)

int main() {

	int baseball_num = 0;
	int one = 0, ten = 0, hundred = 0;
	int b_one = 0, b_ten = 0, b_hundred = 0;
	int strike = 0, ball = 0;
	int n = 0;

	srand((int)time(NULL));

	do {
		one = rand() % 9 + 1;
		ten = rand() % 9 + 1;
		hundred = rand() % 9 + 1;
		baseball_num = hundred * 100 + ten * 10 + one;
	   } while (one == ten || one == hundred || ten == hundred);

	printf("야구게임을 시작합니다. \n");

	while (strike != 3) {

		printf("3자리 숫자를 입력해주세요. ex)123 : ");
		scanf("%d", &n);

		b_hundred = n / 100;
		b_ten = (n - (100 * b_hundred)) / 10;
		b_one = n - (100 * b_hundred + 10 * b_ten);

		strike = 0;
		ball = 0;

		if (b_hundred == hundred)
			strike++;
		else if(b_hundred == ten || b_hundred == one)
			ball++;

		if (b_ten == ten)
			strike++;
		else if (b_ten == hundred || b_ten == one)
			ball++;

		if (b_one == one)
			strike++;
		else if (b_one == hundred || b_one == ten )
			ball++;

		if (strike != 0)
			printf("%d 스트라이크 ", strike);
		if (ball != 0)
			printf("%d 볼 ", ball);
		if (strike == 0 && ball == 0)
			printf("Noting ");

		printf("\n");
	}
	printf("3개의 숫자를 모두 맞히셨습니다! 게임 종료. \n");

	getch();
	return 0;
}
