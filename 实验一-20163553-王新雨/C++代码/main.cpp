#include"node.h"

int main()
{
	int n,s;
	node * listHead = NULL;
	node * h = NULL;
    node t;
	
	cout << "����������Ϊ:";
	cin >> n;
	if (n > 0)
       listHead = t.createList(n);
	cout << "�����뿪ʼ��������";
	cin>>s;
	h = t.startid(s,listHead);
	t.tuiquan(n,h);
}