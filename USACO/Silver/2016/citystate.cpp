#include <iostream>
#include <string>
#include <map>

using namespace std;

int main() {
    freopen("citystate.in", "r", stdin);
    freopen("citystate.out", "w", stdout);
    map<string, int> freq;
    int n;
    cin >> n;

    int total = 0;

    for (int i = 0; i < n; i++)
    {
        string city;
        string state;
        cin >> city >> state;
        city = city.substr(0, 2);

        if (state == city) continue;

        total += freq[state + city];

        freq[city + state]++;
    }
    
    

    cout << total << endl;
}