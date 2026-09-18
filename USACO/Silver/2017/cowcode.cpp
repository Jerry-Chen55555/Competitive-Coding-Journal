#include <iostream>
#include <string>
#include <cmath>
using namespace std;

char solve(string s, long n, int k) {
    // the length of f^k(s) = pow(2, k) so divide by 2 is pow(2, k - 1)
    long halfFKS = pow(2, k - 1) * s.length();
    if (k == 0) {
        return s[n - 1];
    }
    if (n > halfFKS) {
        if (n == halfFKS + 1) {
            return solve(s, n - 1, k - 1);
        } else {
            return solve(s, n - halfFKS - 1, k - 1);
        }
    }  else {
        return solve(s, n, k - 1);
    }
}

int main() {
    freopen("cowcode.in", "r", stdin);
    freopen("cowcode.out", "w", stdout);
    string s;
    long n;
    cin >> s >> n;
    
    int k = ceil(log2(n / s.length() + (n % s.length() != 0)));
    
    cout << solve(s, n, k) << endl;
}