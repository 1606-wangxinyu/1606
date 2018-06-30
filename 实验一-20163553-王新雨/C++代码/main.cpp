#include"node.h"

int main()
{
	int n,s;
	node * listHead = NULL;
	node * h = NULL;
    node t;
	
	cout << "请输入人数为:";
	cin >> n;
	if (n > 0)
       listHead = t.createList(n);
	cout << "请输入开始的整数：";
	cin>>s;
	h = t.startid(s,listHead);
	t.tuiquan(n,h);
}