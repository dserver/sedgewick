package jonathanhenk.sedgewick.algs;

import java.util.Iterator;
import java.util.ArrayList;
import java.lang.reflect.Array;

public class ResizingArrayStack<Item> implements Iterable<Item>
{
	private int max_size;
	private int size;
	private ArrayList<Item> stack;

	// start_size must be > 16
	// public ResizingArrayStack(int start_size)
	// {
	// 	stack = new ArrayList<Item>(start_size);
	// 	size = 0;
	// 	max_size = start_size;
	// }

	public ResizingArrayStack()
	{
		size = 0;
		max_size = 16;
		stack = new ArrayList<Item>(max_size);
	}


	// CORE API
	public void push(Item item)
	{
		if (size==max_size)
		{
			resize(2*max_size);
		}

		size++;
		stack.add(size-1, item);

	}

	public Item pop() throws Exception
	{
		if (size==0)
			throw new Exception("Cannot pop. Stack is empty.");

		if ((size-1)==(max_size/4) && max_size > 16)
			resize(max_size/2);

		size--;
		return stack.remove(size);
	}


	private void resize(int new_size)
	{
		ArrayList<Item> new_stack = new ArrayList<Item>(new_size);
		Item[] old_stack_copy = (Item[]) stack.toArray();
		for (int i=0; i<= size-1; i++)
		{
			new_stack.add(i, old_stack_copy[i]);
			old_stack_copy[i] = null;
		}

		stack = null;
		stack = new_stack;
		max_size = new_size;
	}

	public Item peek() throws Exception
	{

		if (size==0)
			throw new Exception("Cannot peek. Stack is empty!");
		else
		{
			return stack.get(size-1);
		}
	}

	public int size()
	{
		return size;
	}

	public int max_size()
	{
		return max_size;
	}

	// END CORE API


	// OBJECT METHODS
	public boolean equals(ResizingArrayStack other)
	{
		if (this.size() != other.size() || this.max_size() != other.max_size())
			return false;

		Iterator<Item> this_stack = this.iterator();
		Iterator<Item> other_stack = other.iterator();

		while (this_stack.hasNext() && other_stack.hasNext())
		{
				Item a = this_stack.next();
				Item b = other_stack.next();
				if (!a.equals(b))
					return false;
		}

		return true;

	}
	// METHODS FOR ITERABLE
	public Iterator<Item> iterator(){
		return new ResizingArrayStackIterator();
	}

	// ITERATOR CLASS
	private class ResizingArrayStackIterator implements Iterator<Item>
	{
		int i = size - 1;
		public boolean hasNext() {
			if (i==-1) { return false; }
			else { return true; }
		}

		public Item next() {
			return stack.get(i--);
		}

	}
}