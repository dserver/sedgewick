package jonathanhenk.sedgewick.algs;

import java.util.ArrayList;

public class Queue<Item>
{
	private ArrayList<Item> queue;
	private int size;

	public Queue()
	{
		queue = new ArrayList<Item>();
		size = 0;
	}

	public void enqueue(Item a)
	{
		queue.add(a);
		size++;
	}

	public Item dequeue() throws Exception
	{
		try {
			Item r = queue.remove(0);
			size--;
			return r;
		}
		catch (IndexOutOfBoundsException e) 
		{ throw new Exception("Cannot dequeue. Queue is empty."); }
	}

	public int size()
	{
		return size;
	}

}