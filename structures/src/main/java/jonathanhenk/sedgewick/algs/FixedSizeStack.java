package jonathanhenk.sedgewick.algs;

import java.util.Iterator;
import java.util.ArrayList;
import java.lang.reflect.Array;

public class FixedSizeStack<Item> implements Iterable<Item>
{

	private ArrayList<Item> item_array;
	private int size;
	private int max_size;

	public FixedSizeStack(int max_size)
	{
		item_array = new ArrayList<Item>(max_size);
		size = 0;
		this.max_size = max_size;
	}

	// CORE API
	public Item pop() throws Exception
	{

		if (size==0)
			throw new Exception("Cannot pop. Stack is empty!");
		else
		{
			Item r = item_array.remove(size-1);
			size--;
			return r;
		}

	}

	public void push(Item a_item) throws Exception
	{

		if (size==max_size)
			throw new Exception("Cannot push. Stack is full.");
		else
		{
			item_array.add(size, a_item);
			size++;
			return;
		}

	}

	public Item peek() throws Exception
	{

		if (size==0)
			throw new Exception("Cannot peek. Stack is empty!");
		else
		{
			return item_array.get(size-1);
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
	public boolean equals(FixedSizeStack other)
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
		return new FixedSizeStackIterator();
	}

	// ITERATOR CLASS
	private class FixedSizeStackIterator implements Iterator<Item>
	{
		int i = size - 1;
		public boolean hasNext() {
			if (i==-1) { return false; }
			else { return true; }
		}

		public Item next() {
			return item_array.get(i--);
		}

	}
}