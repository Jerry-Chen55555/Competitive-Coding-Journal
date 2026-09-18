// UNFINISHED

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    freopen("highcard.in", "r", stdin);
    freopen("highcard.out", "w", stdout);

    int n;
    cin >> n;
    vector<int> b;
    vector<int> e;
    for (int i = 0; i < n; i++)
    {
        b.push_back(i + 1);
    }

    for (int i = 0; i < n; i++)
    {  
        int c;
        cin >> c;
        e.push_back(c);
        b.erase(remove(b.begin(), b.end(), c), b.end());
    }
    
    sort(b.begin(), b.end());
    sort(e.begin(), e.end());

    string s = "";

    for (int i = 0; i < b.size(); i++)
    {
        cout << b[i] << endl;
    }
    
    

    int bIndex = 0;
    int eIndex = 0;
    while (bIndex < b.size() && eIndex < e.size()) {
        while (bIndex < b.size() && b[bIndex] <= e[eIndex]) {
            bIndex++;
        }
        eIndex++;
        bIndex++;
    }

    cout << eIndex << endl;
}

// 123456789 10
// 2 3 4 8 9
// 1 5 6 7 10
// 1
// 1