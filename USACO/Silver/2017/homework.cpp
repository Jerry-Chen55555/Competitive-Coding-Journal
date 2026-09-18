#include <iostream>
using namespace std;

int main() {
    freopen("homework.in", "r", stdin);
    freopen("homework.out", "w", stdout);

    long n;
    cin >> n;
    long hw[n];

    for (int i = 0; i < n; i++) {
        cin >> hw[i];
    }
    

    long currSum = hw[n - 1];
    long lowest = hw[n - 1];
    long maxSum = 0;
    long maxK = 0;
    long answers = 0;
    for (int i = n - 2; i >= 1; i--) {
        lowest = min(lowest, hw[i]);
        currSum += hw[i];
        if ((currSum - lowest) * (n - maxK - 1) == maxSum * (n - i - 1)) {
            answers++;
        } else if ((currSum - lowest) * (n - maxK - 1) > maxSum * (n - i - 1)) {
            answers = 1;
            maxSum = currSum - lowest;
            maxK = i;
        }
    }

    long possibleK[answers];
    int counter = 1;
    currSum = hw[n - 1];
    lowest = hw[n - 1];
    for (int i = n - 2; i >= 1; i--) {
        lowest = min(lowest, hw[i]);
        currSum += hw[i];
        if ((currSum - lowest) * (n - maxK - 1) == maxSum * (n - i - 1)) {
            possibleK[answers - counter] = i;
            counter++;
        }
    }
    for (int i = 0; i < answers; i++) {
        cout << possibleK[i] << endl;
    }
}