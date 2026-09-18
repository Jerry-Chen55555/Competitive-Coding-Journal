#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    freopen("lemonade.in", "r", stdin);
    freopen("lemonade.out", "w", stdout);

    int n;
    cin >> n;
    int w[n];
    for (size_t i = 0; i < n; i++) {
        cin >> w[i];
    }

    sort(w, w + sizeof(w)/sizeof(w[0]));

    int counter = 0;
    while ((counter < n) && w[n - counter - 1] >= counter) {
        counter++;
    }
    
    cout << counter << endl;
}