#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    int a[n + 1];
    
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    a[n] = 0;
    
    int i = 0;
    string path = "";
    while (!(i == 0 && a[i] == 0)) {
        while (a[i] > 0) {
            path += "R";
            a[i]--;
            i++;
        }
        while ((i != 0) && (a[i] == 0 || a[i - 1] > 1)) {
            path += "L";
            i--;
            a[i]--;
        }
    }

    cout << path << endl;
}