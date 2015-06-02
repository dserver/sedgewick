

public class LinkedList<Item>
{
	private Node first;
	private Node last;
	private int size;

	public void insertAtBeginning(Item a)
	{
		Node old_first = first;
		Node new_node = new Node();
		new_node.item = a;

		if (size==0)
		{
			first = new_node;
			last = new_node;
		}
		else
		{
			new_node.next = old_first;
			first = new_node;
		}

		size++;
	}

	public Item removeFromBeginning() throws Exception
	{
		Item r = first.item;
		
		if (size==0)
			throw new Exception("Cannot remove from an empty list.");
		else if (size==1)
		{
			first = null;
			last = null;
		}
		else
		{
			first = first.next;
		}

		size--;
		return r;
	}

	public void insertAtEnd(Item a)
	{
		Node new_node = new Node();
		new_node.item = a;

		if (size==0)
		{
			first = new_node;
			last = new_node;
		}
		else
		{
			last.next = new_node;
			last = new_node;
		}

		size++;
	}

	public int size()
	{
		return size;
	}

	private class Node
	{
		Item item;
		Node next;
	}


}