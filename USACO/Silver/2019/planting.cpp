#include <iostream>
using namespace std;

int main() {
    freopen("planting.in", "r", stdin);
    freopen("planting.out", "w", stdout);
    int n;
    cin >> n;
    int p[n];
    for (int i = 0; i < n; i++)
    {
        p[i] = 0;
    }
    
    for (int i = 0; i < n - 1; i++)
    {
        int a, b;
        cin >> a >> b;
        p[a]++;
        p[b]++;
    }

    int m = 0;
    
    for (int i = 0; i < n; i++)
    {
        m = max(m, p[i]);
    }
    
    cout << m + 1;
}