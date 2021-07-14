using namespace std;
#include<bits/stdc++.h>
#include<cinttypes>
#include<iostream>
/*
Challenge Description
An XOR linked list is a more memory efficient doubly linked list. Instead of each node holding next and prev fields, it holds a field named both, which is an XOR of the next node and the previous node. Implement an XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.

C++ Implementation of this solution found and modeled after: https://www.geeksforgeeks.org/xor-linked-list-a-memory-efficient-doubly-linked-list-set-1/
*/

//Node class
class Node {
	public : int data;
	Node* xnode;
};

void printList(Node* head);
void insert(Node** head_ref, int data);
Node* Xor(Node* x, Node* y);




int main()
{
	Node* head = NULL; //initalize Node* head
	insert(&head, 10); //insertion statements for 4 different values
	insert(&head, 100);
	insert(&head, 1000);
	insert(&head, 10000);
	
	//print created xorLLL
	printList(head);
	cout << endl;
	
	return 0;
}

//function to return xor'd value of node address
Node* Xor(Node* x, Node* y)
{
	return reinterpret_cast<Node*>(
		reinterpret_cast<uintptr_t>(x) ^ reinterpret_cast<uintptr_t>(y));
}

//function for inserting
//insert a new node at the start of a xorLLL
//then set newly inserted node as the new head
void insert(Node** head_ref, int data)
{
	//allocate memory for new node
	Node* new_node = new Node();
	new_node->data = data;
	
	//always assign new node's xnode to be head_ref
	//xnode will always be xor of current head and NULL
	new_node->xnode = *head_ref;
	
	//when LLL is ont empty xnode of current head node
	//will be xor of new node and the node next to current head
	if(*head_ref != NULL) {
		// *(head_ref)->xnode is xor of (NULL and next)
		// by using xor with NULL, we get next
		(*head_ref)->xnode = Xor(new_node, (*head_ref)->xnode); //passing new node, which is a pointer and
																//the head reference [dereferenced] xnode, which is 
																//a pointer since head reference is a pointer to a pointer
	}
	
	//update new head
	*head_ref = new_node;
}

//function to print out contents of xorLLL
//lists in "forward" direction
void printList(Node* head)
{
	Node* curr = head; //set current to be the head of the list
	Node* prev = NULL; //since we are at the head, just set prev to NULL
	Node* next;
	
	cout << "The nodes of the Linked List are: \n"; //prompt the user for the incoming list
	
	//while loop until reached the end of the list
	while(curr != NULL) {
		//print value of current node
		cout << curr->data << " ";
		
		//get address of next node - works like below
		//curr->xnode is next^prev, so curr->xnode is next^prev^prev
		//next^prev^prev is actually next
		next = Xor(prev, curr->xnode);
		
		//set new prev and curr to print next or exit loop
		prev = curr;
		curr = next;
	}
}
