#include <iostream>
using namespace std;

int main() {
    freopen("moobuzz.in", "r", stdin);
    freopen("moobuzz.out", "w", stdout);

    // 1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz
    // 16, 17, f, 19, b, f, 22, 23, f, b, 26, f, 28, 29, b
    long n;
    cin >> n;
    int f[8] = {1, 2, 4, 7, 8, 11, 13, 14};
    
    cout << (((n - 1) / 8) * 15 + f[(n - 1) % 8]);
}