#include "node.h"


node::node(void)
{
}


node::~node(void)
{
}

node * node:: createList(int n) 
{
	node *temp, *tail = NULL, *head = NULL ;
	int num;
	head = new node ; 
	if (head == NULL) 
	{
		cout << "No memory available!";
		return NULL;
	}
	else 
	{
		head->data = 1;
		head->num =1;
		head->next = NULL;
		tail = head;
	}

	int i;
	for(i=2; i<n+1; i++) 
	{
		temp = new node ; 
		if(temp == NULL) 
		{
			cout << "No memory available!";
			return head;
		}
			temp->data = i;
			temp->num =1;
			temp->next = NULL;
			tail->next = temp;
			tail = temp;	
	}
	tail->next=head;
	return head ;
}


node * node:: tuiquan(int n, node * head)
{
	int m;
	int i=1,k=1;
	cout<<"ÇëÊäÈëÍËÈ¦ÉÏÏÞ£º";
	cin>>m;
	node *curNode = head;
	node *preNode = NULL;
	while (1) 
	{
		if(m==i)
		{ 
			cout<<curNode->data<<endl;
			i=0;
			k++;
			curNode->num=0;
		}
		preNode = curNode; 
		curNode = curNode->next; 
		  
		if(curNode->num!=0)
		i++;
		if(k==n)
		break;
	}
	delete curNode;
	return 0;
}

node * node:: startid(int n, node * head)
{
	node *curNode = head;
	while ( curNode )  
	{
		if ( curNode->data == n)  
		{
			return curNode;
		}
		curNode = curNode->next;
	}

	cout<<"Can't find "<<n<<" in the list."<<endl;
	return NULL;
} 
