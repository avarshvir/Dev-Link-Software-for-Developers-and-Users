#include <iostream>
#include <cmath>
using namespace std;
int border()
{
    cout << "----------------------------------------------------------" << endl;
}
void choice()
{
    cout << "************************************Enter choice************************************ " << endl;
}
void asuvidha()
{
    border();
    cout << endl;
    cout << "Work on Progress ``/  " << endl;
    cout << endl;
    cout << "Please Try Another button " << endl;
    cout << endl;
    cout << "Apko Hui Asuvidha Ke Liye Khed Hai :(" << endl;
    cout << endl;
    cout << "Sorry for your inconvenience caused :(" << endl;
    cout << endl;
    border();
}
class Matrix_ops;
template <class T>
class Arithmetic
{
private:
    T a, b, c, d;

public:
    /*T Sim_Calc(T a,T b, T c, T d){
        this->a=a;
        this->b=b;
        this->c=c;
        this->d=d;
    }*/
    T add(T a1, T b1)
    {
        T c1;
        c1 = a1 + b1;
        cout << c1 << endl;
    }
    T subtract(T a1, T b1)
    {
        T c1;
        c1 = a1 - b1;
        cout << c1 << endl;
    }
    T multiply(T a1, T b1)
    {
        T c1;
        c1 = a1 * b1;
        cout << c1 << endl;
    }
    T divide(T a1, T b1)
    {
        T c1;
        c1 = a1 / b1;
        cout << c1 << endl;
    }
};

// Matrix class
class Matrix
{
protected:
    int n;

public:
    void matrix()
    {
        cout << "Enter Size of Matrix " << endl;
        cin >> n;
        int m1[n][n], m2[n][n];
        int m[n][n];
        cout << "Enter the element of 1st matrix of size " << n << " X " << n << endl;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                cin >> m1[i][j];
            }
        }
        //	border();
        cout << ".........................your 1st matrix......................... " << endl;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                cout << m1[i][j] << " ";
            }
            cout << endl;
        }
        //	border();
        //	border();
        cout << "Enter the element of 2nd matrix of size " << n << " X " << n << endl;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                cin >> m2[i][j];
            }
        }
        //	border();
        cout << ".........................your 2nd matrix......................... " << endl;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                cout << m2[i][j] << " ";
            }
            cout << endl;
        }
        
    }
    // border();
    /*int matrix_add(){
    	int m[][];
        matrix();
                cout<<"Matrix Addition is "<<endl;
    for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
         m[i][j]=m1[i][j]+m2[i][j];
    cout<<m[i][j]<<" ";
    }
    cout<<endl;
    }
            }*/
};
// Matrix class for addition
class matrix_ad : public Matrix
{
	
	//matrix();
    int m1[10][10], m2[10][10];
    int m[10][10];

public:
    //			matrix addition function
    int matrix_add()
    {
        // /matrix();
        cout << "Matrix Addition is " << endl;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                m[i][j] = m1[i][j] + m2[i][j];
                cout << m[i][j] << " ";
            }
            
            cout << endl;
        }
    }
};
// Matrix class for subtraction
class matrix_sb : public Matrix
{
    int m1[10][10], m2[10][10];
    int m[10][10];

public:
    //			matrix subtraction function
    int matrix_sub()
    {
        // matrix();
        cout << "Matrix Subtraction is " << endl;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                m[i][j] = m1[i][j] - m2[i][j];
                cout << m[i][j] << " ";
            }
            cout << endl;
        }
    }
};
// Matrix class for multiplication
class matrix_ml : public Matrix
{
    int m1[10][10], m2[10][10];
    int m[10][10];

public:
    //			matrix multiplication function
    int matrix_mul()
    {
        // matrix();
        cout << "Matrix Multiplication is " << endl;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                m[i][j] = m1[i][j] * m2[i][j];
                cout << m[i][j] << " ";
            }
            cout << endl;
        }
    }
};
// Matrix class for division
class matrix_dv : public Matrix
{
    int m1[10][10], m2[10][10];
    float m[10][10];

public:
    //			matrix division function
    int matrix_div()
    {
        // matrix();
        cout << "Matrix Division is " << endl;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                m[i][j] = m1[i][j] * m2[i][j];
                cout << m[i][j] << " ";
            }
            cout << endl;
        }
    }
};
class Trigonometry
{
protected:
    float n;

public:
    void input()
    {
        cout << "Enter The Value " << endl;
        cin >> n;
    }
    void Sin()
    {
        cout << "The Value of sin " << n << " is " << sin(n) << endl;
    }
    void Cos()
    {
        cout << "The Value of cos " << n << " is " << cos(n) << endl;
    }
    void Tan()
    {
        cout << "The Value of tan " << n << " is " << tan(n) << endl;
    }
    /*void Cosec(){
        cout<<"The Value of cosec "<<n;//<<" is "<<cosec(n)<<endl;
    }
    void Sec(){
        cout<<"The Value of sec ";//<<n<<" is "<<sec(n)<<endl;
    }
    void Cot(){
        cout<<"The Value of cot ";//<<n<<" is "<<cot(n)<<endl;
    }*/
};
class H_Trigonometry : public Trigonometry
{
public:
    void Sinh()
    {
        cout << "The Value of sinh " << n << " is " << sinh(n) << endl;
    }
    void Cosh()
    {
        cout << "The Value of cosh " << n << " is " << cosh(n) << endl;
    }
    void Tanh()
    {
        cout << "The Value of tanh " << n << " is " << tanh(n) << endl;
    }
};
class A_Trigonometry : public H_Trigonometry
{
public:
    void Asin()
    {
        cout << "The Value of asin " << n << " is " << asin(n) << endl;
    }
    void Acos()
    {
        cout << "The Value of acos " << n << " is " << acos(n) << endl;
    }
    void Atan()
    {
        cout << "The Value of atan " << n << " is " << atan(n) << endl;
    }
};
template <class T>
class Number_System
{
    T decimal, binary, remainder, product, octal;

public:
    /*decimal=0;
    binary=0;
    octal=0;
    product=1;*/
    // Decimal to Binary Function
    T Decimal_To_Binary()
    {
        binary = 0;
        product = 1;
        cout << "Enter Decimal Number " << endl;
        cin >> decimal;
        while (decimal != 0)
        {
            remainder = decimal % 2;
            binary = binary + (remainder * product);
            decimal = decimal / 2;
            product *= 10;
        }
        cout << "Binary Equivalent is : " << binary << endl;
    }
    // Decimal to Octal
    T Decimal_To_Octal()
    {
        octal = 0;
        product = 1;
        cout << "Enter Decimal Number " << endl;
        cin >> decimal;
        while (decimal != 0)
        {
            remainder = decimal % 8;
            octal = octal + (remainder * product);
            decimal = decimal / 8;
            product *= 10;
        }
        cout << "Octal Equivalent is : " << octal << endl;
    }
    // Binary to Decimal function
    T Binary_To_Decimal()
    {
        int temp;
        product = 1;
        decimal = 0;
        cout << "Enter Binary Number" << endl;
        cin >> binary;
        temp >> binary;
        while (binary > 0)
        {
            remainder = temp % 10;
            decimal = decimal + remainder * 2;
            product *= 2;
            temp /= 10;
        }
        cout << "Decimal Equivalent is : " << binary << endl;
    }
    // Binary to Octal function
    T Binary_To_Octal()
    {
        octal = 0;
        decimal = 0;
        product = 0;
        while (binary != 0)
        {
            decimal = decimal + (binary % 10) * pow(2, product);
            product++;
            binary /= 10;
        }
        product = 1;
        while (decimal != 0)
        {
            octal = octal + (decimal % 8) * product;
            decimal = decimal / 8;
            product *= 10;
        }
        cout << "Octal Equivalent is : " << binary << endl;
    }
};
class Area
{
protected:
    float l, b, h, pi; // h=height;     //l= length;    b=breadth;    //pi for circle;
public:
    // function to find Area of Rectangle
    int area_rec()
    {
        cout << "Enter Length of Rectangle in cm" << endl;
        cin >> l;
        cout << "Enter Breadth of Rectangle in cm" << endl;
        cin >> b;
        cout << "The Area of Rectangle is : " << l * b << " cm^2" << endl;
    }
    // function to find Area of Square
    void area_sqr()
    {
        // l=side     assume
        cout << "Enter the Side of Square in cm" << endl;
        cin >> l;
        cout << "The Area of Square is : " << l * l << " cm^2" << endl;
    }
    // function to find Area of Circle
    void area_cir()
    {
        // l=radius for circle      assume
        pi = 3.14;
        cout << "Enter the radius of circle " << endl;
        cin >> l;
        cout << "The Area of Circle is " << pi * (l * l) << endl;
    }
    // function to find Area of Cuboid
    void area_cuboid()
    {
        cout << "Enter Length of Cuboid in cm" << endl;
        cin >> l;
        cout << "Enter Breadth of Cuboid in cm" << endl;
        cin >> b;
        cout << "Enter Height of Cuboid in cm" << endl;
        cin >> h;
        cout << "The Area of Cuboid is : " << l * b * h << " cm^2" << endl;
    }
    // function to find Area of Cube
    void area_cube()
    {
        // l=side     assume
        cout << "Enter the Side of Cube in cm" << endl;
        cin >> l;
        cout << "The Area of Cube is " << 2 * ((l * b) + (l * h) + (h * b)) << endl;
    }
    // function to find Area of Sphere
    void area_sphere()
    {
        // l=radius for sphere assume
        pi = 3.14;
        cout << "Enter the Radius of Sphere " << endl;
        cin >> l;
        cout << "The Area of Sphere is " << 4 * pi * (l * l) << endl;
    }
};
class Parameter : virtual public Area
{
public:
    // function to find Parameter of Rectangle
    void Parameter_rec()
    {
        cout << "Enter the Length of Rectangle " << endl;
        cin >> l;
        cout << "Enter the Breadth of Rectangle " << endl;
        cin >> b;
        cout << "The Parameter of Rectangle is " << 2 * (l + b) << endl;
    }
    // function to find Parameter of Square
    void Parameter_sqr()
    {
        cout << "Enter the Side of Square " << endl;
        cin >> l;
        cout << "The Parameter of Square is " << 4 * l << endl;
    }
    // function to find Circumference of Circle
    void Circumference_cir()
    {
        pi = 3.14;
        cout << "Enter the Radius of Circle " << endl;
        cin >> l;
        cout << "The Circumference of Circle is " << 2 * pi * l << endl;
    }
    // function to find Surface Area of Cube
    void Surface_cube()
    {
        cout << "Enter the Side Length of Cube " << endl;
        cin >> l;
        cout << "The Surface Area of Cube is " << 6 * l * l << endl;
    }
    // function to find Surface Area of Cuboid
    void Surface_cuboid()
    {
        cout << "Enter the Length of Cuboid " << endl;
        cin >> l;
        cout << "Enter the Width of Cuboid " << endl;
        cin >> b;
        cout << "Enter the Height of Cuboid " << endl;
        cin >> h;
        cout << "The Surface Area of Cuboid is " << 2 * ((l * b) + (l * h) + (h * b)) << endl;
    }
};
class Volume : virtual public Area
{
public:
    // function to find Volume of Cube
    void Volume_cube()
    {
        cout << "Enter the Length of Cube " << endl;
        cin >> l;
        cout << "The Volume of Cube is " << l * l * l << endl;
    }
    // function to find Volume of Cuboid
    void Volume_cuboid()
    {
        cout << "Enter Length of Cuboid " << endl;
        cin >> l;
        cout << "Enter Width of Cuboid " << endl;
        cin >> b;
        cout << "Enter Height of Cuboid " << endl;
        cin >> h;
        cout << "The Volume of Cuboid is " << l * b * h << endl;
    }
    // function to find Volume of Sphere
    void Volume_sphere()
    {
        pi = 3.14;
        cout << "Enter the Radius of Sphere " << endl;
        cin >> l;
        cout << "The Volume of Sphere is " << 1.33 * pi * (l * l * l) << endl;
    }
    // function to find Volume of Hemisphere
    void Volume_hemisphere()
    {
        pi = 3.14;
        cout << "Enter the Radius of Hemisphere " << endl;
        cin >> l;
        cout << "The Volume of Hemisphere is " << 0.67 * pi * (l * l * l) << endl;
    }
    // function to find Volume of Cylinder
    void Volume_cylinder()
    {
        pi = 3.14;
        cout << "Enter the Radius of Cylinder " << endl;
        cin >> l;
        cout << "Enter the Height of Cylinder " << endl;
        cin >> h;
        cout << "The Volume of Cylinder is " << pi * l * l * h << endl;
    }
    // function to find Volume of Cone
    void Volume_cone()
    {
        pi = 3.14;
        cout << "Enter the Radius of Cone " << endl;
        cin >> l;
        cout << "Enter the Height of Cone " << endl;
        cin >> h;
        cout << "The Volume of Cone is " << 0.33 * pi * l * l * h << endl;
    }
};
class Round_shapes : public Parameter, public Volume
{
public:
    // function to find Area of Semi Circle
    void Area_SemiCircle()
    {
        pi = 3.14;
        cout << "Enter the Radius of Semicircle " << endl;
        cin >> l;
        cout << "The Area of Semi Circle is " << 0.5 * (pi * l * l) << endl;
    }
    // function to find Area of Quarter Circle
    void Area_Quarter_Circle()
    {
        pi = 3.14;
        cout << "Enter the Radius of Quarter Circle " << endl;
        cin >> l;
        cout << "The Area of Quarter Circle " << (pi * l * l) / 4 << endl;
    }
    // function to find Circumference of Semi Circle
    void Circumference_Semi_Circle()
    {
        pi = 3.14;
        cout << "Enter the Radius of Semi Circle " << endl;
        cin >> l;
        cout << "The Circumference of Semi Circle is " << (pi * l) + (2 * l) << endl;
    }
    // function to find Circumference of Quarter Circle
    void Circumference_Quarter_Circle()
    {
        pi = 3.14;
        cout << "Enter the Radius of Quarter Circle " << endl;
        cin >> l;
        cout << "The Circumference of Quarter Circle is " << (1 / 4 * 2 * pi * l) + 2 * l << endl;
    }
    void Surface_Area_Hemi_Sphere()
    {
        pi = 3.14;
        cout << "Enter the Radius of Hemi Sphere " << endl;
        cin >> l;
        cout << "The Surface Area of Hemi Sphere " << 3 * pi * l * l << endl;
    }
    void Surface_Area_Quarter_Sphere()
    {
        /*pi=3.14;
        cout<<"Enter the Radius of Quarter Sphere "<<endl;
        cin>>l;
        cout<<"The Surface Area of Quarter Sphere is "<<*/
        asuvidha();
    }
    void Surface_Area_Cylinder()
    {
        pi = 3.14;
        cout << "Enter the Radius of Cylinder " << endl;
        cin >> l;
        cout << "Enter the Height of Cylinder " << endl;
        cin >> h;
        cout << "The Surface Area of Cylinder is " << (2 * pi * l * h) + (2 * pi * l * l) << endl;
    }
    void Surface_Area_Cone()
    {
        asuvidha();
    }
};
class Learn_Formula
{
public:
    Learn_Formula()
    {
    }
    Learn_Formula(int x)
    {
        cout << "========================= Basic Algebra Formula =========================" << endl;
        border();
        cout << "(a+b)^2 = a^2 + b^2 + 2ab " << endl;
        border();
        cout << "(a-b)^2 = a^2 - b^2 + 2ab " << endl;
        border();
        cout << "(a+b)^3 = a^3 + b^3 + 3ab(a+b)" << endl;
        border();
        cout << "(a-b)^3 = a^3 - b^3 - 3ab(a-b)" << endl;
        border();
        cout << "(a^2 - b^2) = (a+b)(a-b)" << endl;
        border();
        cout << "(a^2 + b^2) = (a+b)^2 - 2ab" << endl;
        border();
    }
    Learn_Formula(int x, int g)
    {
        cout << "========================= Basic Geometry Formula =========================" << endl;
        border();
        cout << "=>Rectangle" << endl;
        cout << "Perimeter of Rectangle           = 2(L+B) " << endl;
        cout << "Area of Rectangle                = L*B " << endl;
        border();
        cout << "=>Square" << endl;
        cout << "Perimeter of Square              = 4*Side     or 4*a " << endl;
        cout << "Area of Square                   = Side*Side  or a*a " << endl;
        border();
        cout << "=>Circle" << endl;
        cout << "Circumference of Circle          = 2*Pi*r " << endl;
        cout << "Area of Circle                   = Pi*r*r " << endl;
        border();
        cout << "=>Semi Circle" << endl;
        cout << "Circumference of Semi Circle     = (Pi*r)+(2*r) " << endl;
        cout << "Area of Semi Circle              = (1/2)*(Pi*r*r)" << endl;
        border();
        cout << "=>Quarter Circle" << endl;
        cout << "Circumference of Quarter Circle  = ((Pi/2)+2)*r " << endl;
        cout << "Area of Quarter Circle           = (1/4)*(Pi*r*r)" << endl;
        border();
        cout << "=>Cuboid" << endl;
        cout << "Surface Area of Cuboid           = 2*((l*b)+(l*h)+(h*b))" << endl;
        cout << "Volume of Cuboid                 = L*B*H" << endl;
        border();
        cout << "=>Cube" << endl;
        cout << "Surface Area of Cube             = 6*a*a" << endl;
        cout << "Volume of Cube                   = a*a*a" << endl;
        border();
        cout << "=>Cylinder" << endl;
        cout << "Surface Area of Cylinder         = (2*Pi*r*h)+(2*Pi*r*r)" << endl;
        cout << "Curved Surface Area of Cylinder  = (2*Pi*r*h)" << endl;
        cout << "Volume of Cylinder               = Pi*r*r*h" << endl;
        border();
        cout << "=>Cone" << endl;
        cout << "Surface Area of Cone             = Pi*r(r+(sqrt(h*h + r*r)))" << endl;
        cout << "Curved Surface Area of Cone      = Pi*r*L" << endl;
        cout << "Volume of Cone                   = Pi*r*r*(h/3)" << endl;
        border();
    }
};
int main()
{
    Arithmetic<float> o1;
    matrix_ad o2;           // creating object of matrix class (addition)
    matrix_sb o3;           // creating object of matrix class (subtraction)
    matrix_ml o4;           // creating object of matrix class (multiplication)
    matrix_dv o5;           // creating object of matrix class (division)
    Number_System<long> o6; // creating object of Number System class (conversion)
    A_Trigonometry o7;      // creating object of Derived clss A_Trigonometry (Multilevel Inheritance)
    Round_shapes o8;

    int ch, ch1;

    // Main While Loop
    while (ch != 8)
    {
        ch1 = 0;
        choice();
        border();
        cout << "\n 1> Arithmetic \n 2> Matrix \n 3> Trigonometry \n 4> Number System Conversion \n 5> Area, Parameter/Surface Area and Volume Finder ";
        cout << "\n 6> Round Shaped (speacial i.e circles, sphere, 2d/3d round shapes) \n 7> Learn Basic Formulas \n 8> Exit " << endl;
        border();
        cout << "Select 1 to 8 " << endl;
        cin >> ch;
        // 1st if statement in Main While Loop
        if (ch == 1)
        {
            // 1st While Loop in 1st if statement inside Main While Loop
            while (ch1 != 5)
            {
                choice();
                border();
                cout << "\n 1> Addition \n 2> Subtraction \n 3> Multiplication \n 4> Division  \n 5> Exit" << endl;
                border();
                cin >> ch1;
                if (ch1 == 5) {
                    break; // Break out of the inner loop when option 5 is selected
                }
                int x, y;
                cout << "Enter 1st Number :";
                cin >> x;
                cout << "Enter 2nd Number :";
                cin >> y;
                // 1st Switch Statement in 1st While Loop in 1st if statement inside Main While Loop
                switch (ch1)
                {
                case 1:
                    cout << "------------------Addition is------------------ " << endl;
                    o1.add(x, y);
                    border();
                    break;
                case 2:
                    cout << "------------------Subtraction is------------------ " << endl;
                    o1.subtract(x, y);
                    // cout<<"------------------------------------------------"<<endl;
                    border();
                    break;
                case 3:
                    cout << "------------------Multiplication is------------------ " << endl;
                    o1.multiply(x, y);
                    // cout<<"------------------------------------------------"<<endl;
                    border();
                    break;
                case 4:
                    cout << "------------------Division is------------------ " << endl;
                    o1.divide(x, y);
                    // cout<<"------------------------------------------------"<<endl;
                    border();
                    break;
                default:
                    border();
                    cout << "Next Time Select 1 to 4 or exiting " << endl;
                    border();
                }
            }
        }
        // 2nd else if statement in Main While Loop
        else if (ch == 2)
        {
            // 2nd While Loop in 2nd else if statement inside Main While Loop
            while (ch1 != 5)
            {
                choice();
                border();
                cout << "\n 1> Matrix Addition \n 2> Matrix Subtraction \n 3> Matrix Multiplication \n 4> Matrix Division \n 5> Exit" << endl;
                border();
                cin >> ch1;
                // 2nd Switch Statement in 2nd While Loop in 2nd else if statement inside Main While Loop
                switch (ch1)
                {
                case 1:
                    o2.matrix();
                    border();
                    o2.matrix_add();
                    border();
                    break;
                case 2:
                    o3.matrix();
                    border();
                    o3.matrix_sub();
                    border();
                    break;
                case 3:
                    o4.matrix();
                    border();
                    o4.matrix_mul();
                    border();
                    break;
                case 4:
                    o5.matrix();
                    border();
                    o5.matrix_div();
                    border();
                    break;
                default:
                    cout << "Exiting..." << endl;
                    border();
                }
            }
        }
        // 3rd else if statement in Main While Loop
        else if (ch == 3)
        {
            // 3rd While Loop in 3rd else if statement inside Main While Loop
            int n;
            while (ch1 != 4)
            {
                choice();
                border();
                cout << "\n 1> Simple Trigonometry \n 2> Hyperbolic Trigonometry \n 3> Inverse Trignometry \n 4> Exit " << endl;
                cin >> ch1;
                // 3rd Switch Statement in 3rd While Loop in 3rd else if statement inside Main While Loop
                switch (ch1)
                {
                case 1:
                    // 1st while loop inside 3rd Switch Statement in 3rd While Loop in 3rd else if statement inside Main While Loop
                    while (n != 7)
                    {
                        choice();
                        cout << "\n 1> sin \n 2> cos \n 3> tan \n 4> cosec \n 5> sec \n 6> cot \n 7> Exit  " << endl;
                        cin >> n;
                        // 1st Switch Statement in 1st while loop inside 3rd Switch Statement in 3rd While Loop in 3rd else if statement inside Main While Loop
                        switch (n)
                        {
                        case 1:
                            o7.input();
                            o7.Sin();
                            border();
                            break;
                        case 2:
                            o7.input();
                            o7.Cos();
                            border();
                            break;
                        case 3:
                            o7.input();
                            o7.Tan();
                            border();
                            break;
                        case 4:
                            asuvidha();
                            border();
                            break;
                        case 5:
                            asuvidha();
                            border();
                            break;
                        case 6:
                            asuvidha();
                            border();
                            break;
                        default:
                            cout << "Exiting..." << endl;
                            border();
                            //	exit(0);
                        }
                    }
                    break;
                case 2:
                    // 2nd while loop inside 3rd Switch Statement in 3rd While Loop in 3rd else if statement inside Main While Loop
                    while (n != 7)
                    {
                        choice();
                        cout << "\n 1> sinh() \n 2> cosh() \n 3> tanh() \n 4> cosech() \n 5> sech() \n 6> coth() \n 7> Exit " << endl;
                        cin >> n;
                        // 2nd Switch Statement in 2nd while loop inside 3rd Switch Statement in 3rd While Loop in 3rd else if statement inside Main While Loop
                        switch (n)
                        {
                        case 1:
                            o7.input();
                            o7.Sinh();
                            border();
                            break;
                        case 2:
                            o7.input();
                            o7.Cosh();
                            border();
                            break;
                        case 3:
                            o7.input();
                            o7.Tanh();
                            border();
                            break;
                        case 4:
                            asuvidha();
                            border();
                            break;
                        case 5:
                            asuvidha();
                            border();
                            break;
                        case 6:
                            asuvidha();
                            border();
                            break;
                        default:
                            cout << "Exiting..." << endl;
                            border();
                        }
                    }
                    break;
                case 3:
                    // 3rd while loop inside 3rd Switch Statement in 3rd While Loop in 3rd else if statement inside Main While Loop
                    while (n != 7)
                    {
                        choice();
                        cout << "\n 1> asin() \n 2> acos() \n 3> atan() \n 4> acosec() \n 5> asec() \n 6> acot() \n 7> Exit " << endl;
                        cin >> n;
                        // 3rd Switch Statement in 3rd while loop inside 3rd Switch Statement in 3rd While Loop in 3rd else if statement inside Main While Loop
                        switch (n)
                        {
                        case 1:
                            o7.input();
                            o7.Asin();
                            border();
                            break;
                        case 2:
                            o7.input();
                            o7.Acos();
                            border();
                            break;
                        case 3:
                            o7.input();
                            o7.Atan();
                            border();
                            break;
                        case 4:
                            asuvidha();
                            border();
                            break;
                        case 5:
                            asuvidha();
                            border();
                            break;
                        case 6:
                            asuvidha();
                            border();
                            break;
                        default:
                            cout << "Exiting..." << endl;
                            border();
                        }
                    }
                    break;
                default:
                    cout << "Exiting..." << endl;
                    border();
                }
            }
            /*while(ch1!=7){
                cout<<"Enter Choice "<<endl;
                cout<<"\n 1> sin \n 2> cos \n 3> tan \n 4> cosec \n 5> sec \n 6> cot \n 7> Exit  "<<endl;
                cin>>ch1;
                switch(ch1){
                    case 1:
                        o7.input();
                        o7.Sin();
                        border();
                        break;
                        case 2:
                            o7.input();
                            o7.Cos();
                            border();
                            break;
                            case 3:
                                o7.input();
                                o7.Tan();
                                border();
                                break;
                                case 4:
                                   cout<<"Under Construction "<<endl;
                                   border();
                                   break;
                                   case 5:
                                      cout<<"Under Construction "<<endl;
                                      border();
                                      break;
                                      case 6:
                                        cout<<"Under Construction "<<endl;
                                        border();
                                        break;
                                        default:
                                            cout<<"Exiting..."<<endl;
                                        //	exit(0);

                }
            }*/
        }
        // 4th else if statement in Main While Loop
        else if (ch == 4)
        {
            // 4th While Loop in 4th else if statement inside Main While Loop
            while (ch1 != 5)
            {
                choice();
                cout << "\n 1> Decimal To Binary \n 2> Decimal To Octal \n 3> Binary To Decimal \n 4> Binary To Octal \n 5> Exit" << endl;
                cin >> ch1;
                // 4th Switch Statement in 4th While Loop in 4th else if statement inside Main While Loop
                switch (ch1)
                {
                case 1:
                    border();
                    o6.Decimal_To_Binary();
                    border();
                    break;
                case 2:
                    border();
                    o6.Decimal_To_Octal();
                    border();
                    break;
                case 3:
                    o6.Binary_To_Decimal();
                    break;
                case 4:
                    o6.Binary_To_Octal();
                    break;
                default:
                    cout << "Exiting..." << endl;
                    cout << "          from Number System " << endl;
                    border();
                }
            }
        }
        // 5th else if statement in Main While Loop
        else if (ch == 5)
        {
            int n5;
            // 5th while loop in 5th else if statement in Main While Loop
            while (ch1 != 4)
            {
                choice();
                cout << "\n 1> Area Finder \n 2> Parameter Finder \n 3> Volume Finder \n 4> Exit" << endl;
                cin >> ch1;
                // 5th Switch Statement in 5th while loop in 5th else if statement in Main While Loop
                switch (ch1)
                {
                case 1:
                    // 1st While Loop inside 5th Switch Statement in 5th while loop in 5th else if statement in Main While Loop
                    while (n5 != 7)
                    {
                        cout << "Enter Choice " << endl;
                        cout << "\n 1> Area of Rectangle \n 2> Area of Square \n 3> Area of Circle ";
                        cout << "\n 4> Area of Cuboid \n 5> Area of Cube \n 6> Area of Sphere \n 7> Exit" << endl;
                        border();
                        cin >> n5;
                        // 1st Switch Statement in 1st While Loop inside 5th Switch Statement in 5th while loop in 5th else if statement in Main While Loop
                        switch (n5)
                        {
                        case 1:
                            o8.area_rec();
                            border();
                            break;
                        case 2:
                            o8.area_sqr();
                            border();
                            break;
                        case 3:
                            o8.area_cir();
                            border();
                            break;
                        case 4:
                            o8.area_cuboid();
                            border();
                            break;
                        case 5:
                            o8.area_cube();
                            border();
                            break;
                        case 6:
                            o8.area_sphere();
                            border();
                            break;
                        default:
                            cout << "Exiting..." << endl;
                            border();
                        }
                    }
                    break;
                case 2:
                    // 2nd While Loop inside 5th Switch Statement in 5th while loop in 5th else if statement in Main While Loop
                    while (n5 != 6)
                    {
                        choice();
                        cout << "\n 1> Parameter of Rectangle \n 2> Parameter of Square \n 3> Circumference of Circle ";
                        cout << "\n 4> Surface Area of Cuboid \n 5> Surface Area of Cube \n 6> Exit" << endl;
                        border();
                        cin >> n5;
                        // 2nd Switch Statement in 2nd While Loop inside 5th Switch Statement in 5th while loop in 5th else if statement in Main While Loop
                        switch (n5)
                        {
                        case 1:
                            o8.Parameter_rec();
                            border();
                            break;
                        case 2:
                            o8.Parameter_sqr();
                            border();
                            break;
                        case 3:
                            o8.Circumference_cir();
                            border();
                            break;
                        case 4:
                            o8.Surface_cuboid();
                            border();
                            break;
                        case 5:
                            o8.Surface_cube();
                            border();
                            break;
                        default:
                            cout << "Exiting..." << endl;
                            border();
                        }
                    }
                    break;
                case 3:
                    // 3rd While Loop inside 5th Switch Statement in 5th while loop in 5th else if statement in Main While Loop
                    while (n5 != 7)
                    {
                        choice();
                        cout << "\n 1> Volume of Cube \n 2> Volume of Cuboid \n 3> Volume of Sphere \n 4> Volume of Cone ";
                        cout << "\n 5> Volume of Hemisphere \n 6> Volume of Cylinder \n 7> Exit " << endl;
                        border();
                        cin >> n5;
                        // 3rd Switch Statement in 3rd While Loop inside 5th Switch Statement in 5th while loop in 5th else if statement in Main While Loop
                        switch (n5)
                        {
                        case 1:
                            o8.Volume_cube();
                            border();
                            break;
                        case 2:
                            o8.Volume_cuboid();
                            border();
                            break;
                        case 3:
                            o8.Volume_sphere();
                            border();
                            break;
                        case 4:
                            o8.Volume_cone();
                            border();
                            break;
                        case 5:
                            o8.Volume_hemisphere();
                            border();
                            break;
                        case 6:
                            o8.Volume_cylinder();
                            border();
                            break;
                        default:
                            cout << "Exiting..." << endl;
                            border();
                        }
                    }
                    break;
                default:
                    cout << "Exiting..." << endl;
                    border();
                }
            }
        }
        // 6th else if statement in Main While Loop
        else if (ch == 6)
        {
            int n6;
            // 6th while loop in 6th else if statement in Main While Loop
            while (ch1 != 5)
            {
                choice();
                cout << "\n 1> Area of 2d Shapes \n 2> Circumference of 2d shapes  " << endl;
                cout << "\n 3> Surface Area of 3d Shapes \n 4> Volume of 3d Shapes \n 5> Exit " << endl;
                cout << endl;
                cin >> ch1;
                // 6th Switch Statement in 6th while loop in 6th else if statement in Main While Loop
                switch (ch1)
                {
                case 1:
                    // 1st While Loop inside 6th Switch Statement in 6th while loop in 6th else if statement in Main While Loop
                    while (n6 != 4)
                    {
                        choice();
                        cout << "\n 1> Area of Circle \n 2> Area of Semi Circle \n 3> Area of Quarter Circle \n 4> Exit" << endl;
                        border();
                        cin >> n6;
                        // 1st Switch Statement in 1st While Loop inside 6th Switch Statement in 6th while loop in 6th else if statement in Main While Loop
                        switch (n6)
                        {
                        case 1:
                            o8.area_cir();
                            border();
                            break;
                        case 2:
                            o8.Area_SemiCircle();
                            border();
                            break;
                        case 3:
                            o8.Area_Quarter_Circle();
                            border();
                            break;
                        default:
                            cout << "Exiting..." << endl;
                            border();
                        }
                    }
                    break;
                case 2:
                    // 2nd While Loop inside 6th Switch Statement in 6th while loop in 6th else if statement in Main While Loop
                    while (n6 != 4)
                    {
                        choice();
                        cout << "\n 1> Circumference of Circle \n 2> Circumference of Semi Circle \n 3> Circumference of Quarter Circle \n 4> Exit" << endl;
                        border();
                        cin >> n6;
                        // 2nd Switch Statement in 2nd While Loop inside 6th Switch Statement in 6th while loop in 6th else if statement in Main While Loop
                        switch (n6)
                        {
                        case 1:
                            o8.Circumference_cir();
                            border();
                            break;
                        case 2:
                            o8.Circumference_Semi_Circle();
                            border();
                            break;
                        case 3:
                            o8.Circumference_Quarter_Circle();
                            border();
                            break;
                        default:
                            cout << "Exiting..." << endl;
                            border();
                        }
                    }
                    break;
                case 3:
                    // 3rd While Loop inside 6th Switch Statement in 6th while loop in 6th else if statement in Main While Loop
                    while (n6 != 6)
                    {
                        choice();
                        cout << "\n 1> Surface Area of Sphere \n 2> Surface Area of Hemi Sphere \n 3> Surface Area of Quarter Sphere \n 4> Surface Area of Cylinder";
                        cout << "\n 5> Surface Area of Cone \n 6> Exit " << endl;
                        border();
                        cin >> n6;
                        // 3rd Switch Statement in 3rd While Loop inside 6th Switch Statement in 6th while loop in 6th else if statement in Main While Loop
                        switch (n6)
                        {
                        case 1:
                            o8.area_sphere();
                            border();
                            break;
                        case 2:
                            o8.Surface_Area_Hemi_Sphere();
                            border();
                            break;
                        case 3:
                            o8.Surface_Area_Quarter_Sphere();
                            border();
                            break;
                        case 4:
                            o8.Surface_Area_Cylinder();
                            border();
                            break;
                        case 5:
                            o8.Surface_Area_Cone();
                            border();
                            break;
                        default:
                            cout << "Exiting..." << endl;
                            border();
                        }
                    }
                    break;
                case 4:
                    // 4th While Loop inside 6th Switch Statement in 6th while loop in 6th else if statement in Main While Loop
                    while (n6 != 6)
                    {
                        choice();
                        cout << "\n 1> Volume of Sphere \n 2> Volume of Hemi Sphere \n 3> Voulume of Quarter Sphere \n 4> Volume of Cylinder ";
                        cout << "\n 5> Volume of Cone \n 6> Exit " << endl;
                        border();
                        cin >> n6;
                        // 4th Switch Statement in 4th While Loop inside 6th Switch Statement in 6th while loop in 6th else if statement in Main While Loop
                        switch (n6)
                        {
                        case 1:
                            o8.Volume_sphere();
                            border();
                            break;
                        case 2:
                            o8.Volume_hemisphere();
                            border();
                            break;
                        case 3:
                            o8.Surface_Area_Quarter_Sphere();
                            border();
                            break;
                        case 4:
                            o8.Volume_cylinder();
                            border();
                            break;
                        case 5:
                            o8.Volume_cone();
                            border();
                            break;
                        default:
                            cout << "Exiting..." << endl;
                            border();
                        }
                    }
                    break;
                default:
                    cout << "Exiting..." << endl;
                    border();
                }
            }
        }
        else if (ch == 7)
        {
            int x1, y1, g1;
            Learn_Formula lf;
            while (ch1 != 6)
            {
                choice();
                cout << "\n 1> Basic Algebra Formula \n 2> Basic Geometry Formula \n 3> Basic Trigonometry Formula ";
                cout << "\n 4> Basic Probality Formula \n 5> Basic Statics Formula \n 6> Exit " << endl;
                cin >> ch1;
                switch (ch1)
                {
                case 1:
                    // Learn_Formula lf;
                    lf = Learn_Formula(x1);
                    break;
                case 2:
                    lf = Learn_Formula(x1, y1);
                    break;
                case 3:
                    asuvidha();
                    break;

                case 4:
                    asuvidha();
                    break;
                    /*o5.matrix();
                    border();
                    o5.matrix_div();
                    border();
                break;*/
                case 5:
                    asuvidha();
                    break;
                default:
                    cout << "Exiting..." << endl;
                    border();
                }
            }
        }
        else
        {
            cout << "Exiting... :(" << endl;
            exit(0);
        }
    }
    return 0;
}
