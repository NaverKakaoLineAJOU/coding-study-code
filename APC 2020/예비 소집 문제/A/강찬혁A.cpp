#include <iostream>
using namespace std;

int s1, s2;
int ans, man_ans;
int accpted = 1;
int wrong = 0;
int why = 0;

int main() {
	cin >> s1 >> s2;
	for (int i = 0; i < s1; i++) {
		cin >> ans >> man_ans;
		if (ans != man_ans) {
			wrong = 1;
			accpted = 0;
		}
	}
	for (int i = 0; i < s2; i++) {
		cin >> ans >> man_ans;
		if (ans != man_ans) {
			why = 1;
			accpted = 0;
		}
	}

	if (accpted == 1)
		cout << "Accepted\n";
	else if (wrong == 1)
		cout << "Wrong Answer\n";
	else
		cout << "Why Wrong!!!\n";

	return 0;
}