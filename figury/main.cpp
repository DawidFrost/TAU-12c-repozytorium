#include <iostream>


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

void triangle(int a,int b, int c){
    
        if ((a + b <= c) || (a + c <= b) || (b + c <= a))
            cout << "nierozpoznano"<<endl;
        else if ((a==b==c))
        {
            cout << "trojkat rownoboczny" <<endl;
        }
        else if (( a==b ) || ( a==c ) || ( b==c ))
        {
            cout << "trojkat rownoramienny" <<endl;
        }
        else if ((a!=b) && (a!=c) && (b!=c))
        {
            cout << "trojkat roznoramienny" <<endl;
        }
        
}

void quadrangle(int a,int b, int c,int d){
    
        if (max_element(a, b, c, d) > (a + b + c + d - max_element(a, b, c, d)))
            cout << "nierozpoznano"<<endl;
        else if (a == b == c == d)
        {
            cout << "kwadrat" <<endl;
        }
        else if (a == b && c == d)
        {
            cout << "prostokat" <<endl;
        }
        else if (a == d && c == b)
        {
            cout << "prostokat" <<endl;
        }
        else if (a == c && b == d)
        {
            cout << "prostokat" <<endl;
        }
        else
            cout << "czworobok" <<endl;
}
    
int main()
{
    int s;
    int a,b,c,d;
    
    cout << "Program pozwala sprawdzić czy z podanych argumentow mozna sie stworzyc figure 3 lub 4 ramienna."<<endl<< "Podaj liczbę argumentow, potwierdz enterem:";
    cin >> s;
    
    if(s == 4){
        cout << "Podaj 4 argumenty, kazdy potwierdz enterem"<<endl;
        cin>>a;
        cin>>b;
        cin>>c;
        cin>>d; 
        quadrangle(a,b,c,d);
    }
    else if (s == 3){
        cout << "Podaj 3 argumenty, kazdy potwierdz enterem"<<endl;
        cin>>a;
        cin>>b;
        cin>>c;
        triangle(a,b,c);
    }
    else
    cout << "nierozpoznano"<<endl;
    
    return 0;
}