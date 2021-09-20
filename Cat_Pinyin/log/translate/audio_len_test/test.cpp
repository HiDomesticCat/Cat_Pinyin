#include <iostream>
using namespace std;

#include <cstring>
#include <cstdio>
#include <cstdlib>

int main(void){
	char a[21][5] = {"ㄅ","ㄆ","ㄇ","ㄈ","ㄉ","ㄊ","ㄋ","ㄌ","ㄍ","ㄎ","ㄏ","ㄐ","ㄑ","ㄒ","ㄓ","ㄔ","ㄕ","ㄖ","ㄗ","ㄘ","ㄙ"};
	char b[3][5] = {"一","ㄨ","ㄩ"};
	char c[13][5] = {"ㄚ","ㄛ","ㄜ","ㄝ","ㄞ","ㄟ","ㄠ","ㄡ","ㄢ","ㄣ","ㄤ","ㄥ","ㄦ"};
	
	//char str1[60] = "trans {zh-TW=zh-TW} -download-audio-as test3.ts ";
	//strcat(str1, c[3]);
	
	char str1[15] = "trans --help";
	
	cout << str1 <<endl;
	
	system(str1);
	
	return 0;
}