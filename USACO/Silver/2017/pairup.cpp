#include <iostream>
using namespace std;

int main() {
    // freopen("pairup.in", "r", stdin);
    // freopen("pairup.out", "w", stdout);
    int n;
    cin >> n;
    int m[n];
    int q[n];
    long mSum;
    long qSum;

    for (int i = 0; i < n; i++)
    {
        cin >> m[i] >> q[i];
        mSum += m[i];
        qSum += q[i];
    }
    
}