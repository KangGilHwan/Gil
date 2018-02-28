#include <stdio.h>
#include <stdlib.h>
#include<conio.h>
#include <time.h>
#pragma warning(disable:4996)


void creatNum(int random[]) {    //게임에 필요한 1~9까지 중복이 아닌 랜덤 숫자를 만드는 함수
	int i = 0;
	srand((int)time(NULL));
	do {
		for (i = 0; i < 3; i++) {
			random[i] = rand() % 9 + 1;
		}
	} while (random[0] == random[1] || random[0] == random[2] || random[1] == random[2]);
}

void manNum(int insert[]) {      //한번에 숫자 3개를 입력받아 배열에 넣어주는 함수 
	int j = 0;
	int n;

	printf("3자리 숫자를 입력해주세요. ex)123 : ");
		scanf("%d", &n);
		insert[0] = n / 100;
		insert[1] = (n - (100 * insert[0])) / 10;
		insert[2] = n - (100 * insert[0] + 10 * insert[1]);
}

int compare(int insert[], int random[]) {  //입력받은 숫자와 게임 숫자를 비교해 결과를 출력하는 함수
	int strike = 0, ball = 0;
	int t = 0;

	for (t = 0; t < 3; t++) { 
		if (insert[t] == random[t]) //숫자가 같으면 스트라이크
			strike++;
		else if (insert[t] == random[(t + 1) % 3] || insert[t] == random[(t + 2) % 3]) //입력받은 숫자가 다른 자리의 숫자와 같으면 볼
			ball++;
	}

	if (strike != 0)
		printf("%d 스트라이크 ", strike);
	if (ball != 0)
		printf("%d 볼 ", ball);
	if (strike == 0 && ball == 0)
		printf("Noting ");

	printf("\n");

	return strike;
}


int main() {

	int random[3], insert[3];
	int strike = 0;

	creatNum(random);
	printf("야구게임을 시작합니다. \n");

	while (strike != 3) {
		manNum(insert);                         //숫자를 입력받는다.
		strike = compare(insert, random);       //게임 숫자와 입력 받은 숫자를 비교해 결과를 출력한다.
	}
	printf("3개의 숫자를 모두 맞히셨습니다! 게임 종료. \n");

	getch();
	return 0;
}
