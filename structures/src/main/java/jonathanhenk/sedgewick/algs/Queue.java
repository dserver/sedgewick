package jonathanhenk.sedgewick.algs;

import java.util.ArrayList;
import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>
{
	private ArrayList<Item> queue;
	private int size;

	// CORE API
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


	// OBJECT METHODS
	public boolean equals(Queue some_q)
	{
		if (this.size() != some_q.size())
			return false;
		Iterator<Item> this_iter = this.iterator();
		Iterator<Item> some_q_iter = some_q.iterator();

		while (this_iter.hasNext() && some_q_iter.hasNext())
		{
			Item a = this_iter.next();
			Item b = this_iter.next();
			if (!a.equals(b))
				return false;
		}

		return true;
	}


	// ITERATOR METHODS
	public Iterator<Item> iterator()
	{
		return new QueueIterator();
	}


	private class QueueIterator implements Iterator<Item>
	{
		int i = size - 1;
		public boolean hasNext()
		{
			if (i==-1)
				return false;
			else
				return true;
		}

		public Item next()
		{
			Item x = queue.get(i);
			i--;
			return x;
		}
	}

}