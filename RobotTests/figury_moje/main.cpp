#include <iostream>
#include <string>

/* Twórca: Dawid Frost, s15670
 * kompilacja g++ main.cpp -o figury
 * przykłady użycia:
 * ./figury 1 2 2;   przewidywany wynik: trójkąt rownoramienny
 * ./figury 3 2 2 3; przewidywany wynik: prostokat
*/


using namespace std;

int max_element(int a,int b, int c,int d)
{
    if( (a >= b) && (a >= c) && (a >= d) )
    {
        return a;
    }
    else if( (b >= a) && (b >= c) && (b >= d) )
    {
        return b;
    }
    else if( (c >= a) && (c >= b) && (c >= d) )
    {
        return c;
    }
    else if( (d >= a) && (d >= b) && (d >= c) )
    {
        return d;
    }
}

string triangle(int a,int b, int c){
    
        if ((a + b <= c) || (a + c <= b) || (b + c <= a))
            return "nierozpoznano";
        else if (a == b && b == c)
        {
            return "trojkat rownoboczny";
        }
        else if (( a==b ) || ( a==c ) || ( b==c ))
        {
            return "trojkat rownoramienny";
        }
        else if ((a!=b) && (a!=c) && (b!=c))
        {
            return "trojkat roznoramienny";
        }
        
}

string quadrangle(int a,int b, int c,int d){
    
        if (max_element(a, b, c, d) > (a + b + c + d - max_element(a, b, c, d)))
            return "nierozpoznano";
        else if (a == b && c == d && b == c)
        {
            return "kwadrat";
        }
        else if (a == b && c == d)
        {
            return "prostokat" ;
        }
        else if (a == d && c == b)
        {
            return "prostokat";
        }
        else if (a == c && b == d)
        {
            return  "prostokat";
        }
        else
            return  "czworobok";
}
    
int main(int argc, char* argv[])
{
 if (argc == 4) {
        try {
            int a = stoi(argv[1]); 
            int b = stoi(argv[2]); 
            int c = stoi(argv[3]);
            cout << triangle(a, b, c) << endl;
        }
        catch (const invalid_argument e) {
            cout << "ERROR:argumenty musza byc liczbami calkowitymi" << endl;
        }
    }
    else if (argc == 5) {
        try {
            int a = stoi(argv[1]); 
            int b = stoi(argv[2]); 
            int c = stoi(argv[3]);
            int d = stoi(argv[4]);
            cout << quadrangle(a, b, c, d) <<endl;
        }
        catch (const invalid_argument e) {
            cout << "ERROR:argumenty musza byc liczbami calkowitymi" << endl;
        }
        
    }
    else {
        cout << "ERROR:nieprawidlowa_liczba_argumentow: Podaj 3 lub 4 argumenty" << endl;
    }
}
