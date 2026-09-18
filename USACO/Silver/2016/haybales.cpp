#include <iostream>
#include <algorithm>
using namespace std;

// number of numbers less than or equal to
// so binary search for index which is first one less than target or equal to target
// then add one, but subtract one because I put 0 at h[0]
int binarySearch(long target, long a[], int arraySize) {
    int min = 0;
    int max = arraySize - 1;
    int mid;
    
    while (min != max) {
        mid = (min + max + 1) / 2;
        if (a[mid] > target) {
            max = mid - 1;
        } else {
            min = mid;
        }
    }

    return min;
}

int main() {
    freopen("haybales.in", "r", stdin);
    freopen("haybales.out", "w", stdout);

    int n, q;
    cin >> n >> q;

    long h[n + 1];
    h[0] = 0;
    for (int i = 1; i < n + 1; i++) {
        cin >> h[i];
    }

    sort(h, h + n + 1);
    

    for (int i = 0; i < q; i++) {
        long begin, end;
        cin >> begin >> end;
        cout << binarySearch(end, h, n + 1) - binarySearch(begin - 1, h, n + 1) << endl;
    }
}