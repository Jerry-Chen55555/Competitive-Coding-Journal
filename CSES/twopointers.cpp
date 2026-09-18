#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;
    int x;

    cin >> n >> x;

    int a[n];

    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }

    
    
    int l = 0;
    int r = 1;
    string sol = "IMPOSSIBLE";
    
    while (l < n && r < n) {
        if (a[l] + a[r] == x) {
            sol = l + " " + r;
        } else if (a[l] + a[r] < x) {
            r += 1;
        } else {
            l += 1;
        }
    }

    cout << sol;
}