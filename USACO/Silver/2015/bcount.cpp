#include <iostream>
using namespace std;

int main() {
    freopen("bcount.in", "r", stdin);
	freopen("bcount.out", "w", stdout);

	int n, q;
    cin >> n >> q;

    int prefixSums[n + 1][3];
    prefixSums[0][0] = 0;
    prefixSums[0][1] = 0;
    prefixSums[0][2] = 0;

    for (int i = 1; i < n + 1; i++) {
        int breed;
        cin >> breed;
        prefixSums[i][0] = prefixSums[i - 1][0];
        prefixSums[i][1] = prefixSums[i - 1][1];
        prefixSums[i][2] = prefixSums[i - 1][2];

        prefixSums[i][breed - 1]++;
    }

    for (int i = 0; i < q; i++) {
        int from, to;
        cin >> from >> to;
        cout << prefixSums[to][0] - prefixSums[from - 1][0] << " " << prefixSums[to][1] - prefixSums[from - 1][1] << " " <<
        prefixSums[to][2] - prefixSums[from - 1][2] << "\n";
    }
}