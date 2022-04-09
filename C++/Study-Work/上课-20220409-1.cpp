#include <iostream>
using namespace std;
class Array_max
{
public:
    void max_value();
    void show_value();
    void set_value()
    {
        int i;
        cout << "请输入10个整数值：" << endl;
        for (i = 0; i < 10; i++)
            cin >> array[i];
    }
    ~Array_max()
    {
        cout << "析构函数调用" << endl;
    }

private:
    int array[10];
    int max;
};
void Array_max::max_value()
{
    int i;
    max = array[0];
    for (i = 1; i < 10; i++)
        if (array[i] > max)
            max = array[i];
}
void Array_max::show_value()
{
    cout << "最大值=" << max << endl;
}
int main()
{
    Array_max am;
    am.set_value();
    am.max_value();
    am.show_value();
    return 0;
}