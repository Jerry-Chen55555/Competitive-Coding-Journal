#include <iostream>
using namespace std;

int main() {
    freopen("div7.in", "r", stdin);
    freopen("div7.out", "w", stdout);

    long n;
    cin >> n;
    long prefix[n + 1];
    long firstOccurence[7] = {0, n + 1, n + 1, n + 1, n + 1, n + 1, n + 1};
    long lastOccurence[7] = {0, -1, -1, -1, -1, -1, -1};

    prefix[0] = 0;
    for (long i = 1; i < n + 1; i++) {
        cin >> prefix[i];
        prefix[i] = (prefix[i] % 7 + prefix[i - 1]) % 7;
        firstOccurence[prefix[i]] = min(firstOccurence[prefix[i]], i);
        lastOccurence[prefix[i]] = i;
    }
    
    long largestConseq = 0;

    for (int i = 0; i < 6; i++) {
        if (firstOccurence[i] < n + 1 && lastOccurence[i] > -1) {
            largestConseq = max(largestConseq, lastOccurence[i] - firstOccurence[i]);
        }
    }

    cout << largestConseq;
}