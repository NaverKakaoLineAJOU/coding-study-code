#include <string>
#include <vector>
#include <iostream>

using namespace std;
int leftright = 0;

void leftright_move(string name, int i, int cnt) {

    int len = name.size();
    //AAA...�˻���
    for (int n = 0; n < name.size(); n++) {
        if (name[n] != 'A') break;
        else len--;
    }
    //�� �ٲ���ٸ� �¿��̵�Ƚ�� ����
    if (len == 0) {
        leftright = cnt;
        return;
    }

    len = name.size();
    int k = 1; 

    //�¿�� k��ŭ �̵��ϸ� ���� �ε������� A�� �ƴ� ����� ���ڷ� �̵�
    while (true) {
        if (name[(i + k) % len] != 'A' && name[(i - k + len) % len] != 'A') {
            name[(i + k) % len] = 'A';
            leftright_move(name, (i + k) % len, cnt + k);
            break;
        }
        else if (name[(i + k) % len] == 'A' && name[(i - k + len) % len] != 'A') {
            name[(i - k + len) % len] = 'A';
            leftright_move(name, (i - k + len) % len, cnt + k);
            break;
        }
        else if (name[(i + k) % len] != 'A' && name[(i - k + len) % len] == 'A') {
            name[(i + k) % len] = 'A';
            leftright_move(name, (i + k) % len, cnt + k);
            break;
        }
        else
            k++;
    }

}

int solution(string name) {
    int answer = 0;

    //A�� ��� �ٲٱ� ���� ���Ʒ� Ƚ��
    int updown = 0;
    for (int i = 0; i < (int)name.size(); i++) {
        updown = name[i] - 65 <= 13 ? name[i] - 65 : 26 - (name[i] - 65);
        answer += updown;
    }

    name[0] = 'A';
    leftright_move(name, 0, 0);
    answer += leftright;

    return answer;
}

int main() {
    string n;
    cin >> n;
    int ans = solution(n);

    cout << ans<<"\n";
    return 0;
}