#include <iostream>
#include <algorithm>
using namespace std;

int minRangeIndex(int t, int a[], int b[], int size) {
    int minimum = 2147483647;
    int minIndex = -1;
    for (int i = 0; i < size; i++) {
        if (t >= a[i] && t <= b[i] && b[i] <= minimum) {
            minimum = b[i];
            minIndex = i;
        }
    }
    
    return minIndex;
}

int main() {
    freopen("helpcross.in", "r", stdin);
    freopen("helpcross.out", "w", stdout);

    int c, n;
    cin >> c >> n;

    int t[c], a[n], b[n];
    int size = n;

    for (int i = 0; i < c; i++) {
        cin >> t[i];
    }
    
    for (int i = 0; i < n; i++) {
        cin >> a[i] >> b[i];
    }

    // end getting input

    sort(t, t + sizeof(t) / sizeof(t[0]));

    int maxCrossings = 0;
    int currRangeIndex = 0;
    
    for (int i = 0; i < c; i++) {
        currRangeIndex = minRangeIndex(t[i], a, b, size);
        if (currRangeIndex != -1) {
            a[currRangeIndex] = a[size - 1];
            b[currRangeIndex] = b[size - 1];
            size--;
            maxCrossings++;
        }
    }
    
    cout << maxCrossings << endl;
}