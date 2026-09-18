#include <iostream>
using namespace std;

int main() {
    freopen("pails.in", "r", stdin);
    freopen("pails.out", "w", stdout);
    int X, Y, K, M;
    cin >> X >> Y >> K >> M;
    bool can[X + 1][Y + 1];
    
    for (int i = 0; i < X + 1; i++)
    {
        for (int j = 0; j < Y + 1; j++)
        {
            can[i][j] = false;
        }
    }
    
    can[0][0] = true;
    
    for (int i = 0; i < K; i++)
    {
        bool newCan[X + 1][Y + 1];
        for (int j = 0; j < X + 1; j++)
        {
            for (int k = 0; k < Y + 1; k++)
            {
                newCan[j][k] = false;
            }
        }
        for (int j = 0; j < X + 1; j++)
        {
            for (int k = 0; k < Y + 1; k++)
            {
                if (!can[j][k]) continue;
                newCan[j][k] = true;
                newCan[0][k] = true;
                newCan[j][0] = true;
                newCan[X][k] = true;
                newCan[j][Y] = true;
                int subtractX = min(j, Y - k);
                newCan[j - subtractX][k + subtractX] = true;
                int subtractY = min(X - j, k);
                newCan[j + subtractY][k - subtractY] = true;
            }
        }
        for (int j = 0; j < X + 1; j++)
        {
            for (int k = 0; k < Y + 1; k++)
            {
                can[j][k] = newCan[j][k];
            }
        }
    }

    int minDiff = M;
    
    for (int i = 0; i < X + 1; i++)
    {
        for (int j = 0; j < Y + 1; j++)
        {
            if (can[i][j]) minDiff = min(minDiff, abs(i + j - M));
        }
    }
    
    cout << minDiff << endl;
}