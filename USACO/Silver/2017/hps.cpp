#include <iostream>
using namespace std;

int main() {
    freopen("hps.in", "r", stdin);
    freopen("hps.out", "w", stdout);

    int n;
    cin >> n;

    // 0 = H, 1 = P, 2 = S
    // the symbol to win is different than fj's, but it doesn't matter because the values are just cycled
    int fj[n + 1][3];

    fj[0][0] = 0;
    fj[0][1] = 0;
    fj[0][2] = 0;
    char currChar;

    for (int i = 1; i < n + 1; i++) {
        cin >> currChar;
        fj[i][0] = fj[i - 1][0];
        fj[i][1] = fj[i - 1][1];
        fj[i][2] = fj[i - 1][2];
        if (currChar == 'H') {
            fj[i][0]++;
        } else if (currChar == 'P') {
            fj[i][1]++;
        } else {
            fj[i][2]++;
        }
    }
    
    int maxWins = -1;
    for (int i = 1; i < n + 1; i++) {
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++)
            {
                maxWins = max(maxWins, fj[n][j] - fj[i][j] + fj[i][k]);
            }
        }
    }

    cout << maxWins;
}