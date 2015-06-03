package jonathanhenk.sedgewick.algs;

import edu.princeton.cs.introcs.*;
import java.util.ArrayList;
import java.io.File;
import java.nio.file.DirectoryStream;


public class FileUtils
{
	
	public void listFiles(String directory)
	{
		Queue<ListFileNode> files_with_indent_q = new Queue<ListFileNode>();
		try {
			files_with_indent_q = listFilesQ(directory, 0, files_with_indent_q);
		} catch (Exception e)
		{ e.printStackTrace(); }
		printFileQ(files_with_indent_q);

	}

	private Queue<ListFileNode> listFilesQ(String directory, int ind, Queue<ListFileNode> q)
		throws Exception
	{
		File cur_dir = new File(directory);
		ArrayList<File> files = new ArrayList<File>();
		ArrayList<File> dirs = new ArrayList<File>();

		try {
			File[] stream = cur_dir.listFiles();
			for (File f : stream)
			{
				if (f.isDirectory())
					dirs.add(f);
				else if (f.isFile())
					files.add(f);
			}

			q.enqueue(new ListFileNode(cur_dir, ind));
			ind++;

			for (File f : files)
				q.enqueue(new ListFileNode(f, ind));
			for (File d : dirs)
				listFilesQ(d.toString(),ind+1,q);

			return q;
		} catch (Exception e)
		{
			throw e;
		}
	}

	private void printFileQ(Queue<ListFileNode> q)
	{
		for (ListFileNode fn : q)
		{
			StringBuilder sb = new StringBuilder();
			for (int i=0; i < fn.indentation; i++)
				sb.append("\t");
			sb.append(fn.file.toString());
			StdOut.println(sb);
		}
	}


	private class ListFileNode
	{
		public File file;
		public int indentation;

		public ListFileNode(File n, int i)
		{
			file = n;
			indentation = i;
		}
	}

}