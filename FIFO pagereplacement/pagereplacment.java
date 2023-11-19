 
import java.util.HashSet; 
import java.util.LinkedList; 
import java.util.Queue; 


class Test 
{ 
	// Method to find page faults using FIFO 
	static int pageFaults(int pages[], int n, int capacity) 
	{ 
		
		HashSet<Integer> s = new HashSet<>(capacity); 
	
		 
		Queue<Integer> indexes = new LinkedList<>() ; 
	
		 
		int page_faults = 0; 
		for (int i=0; i<n; i++) 
		{ 
			
			if (s.size() < capacity) 
			{ 
				 
				if (!s.contains(pages[i])) 
				{ 
					s.add(pages[i]); 
	
					
					page_faults++; 
	
					 
					indexes.add(pages[i]); 
				} 
			} 
	
			
			else
			{ 
				 
				if (!s.contains(pages[i])) 
				{ 
					 
					int val = indexes.peek(); 
	
					indexes.poll(); 
	
					// Remove the indexes page 
					s.remove(val); 
	
					// insert the current page 
					s.add(pages[i]); 
	
					 
					indexes.add(pages[i]); 
	
					// Increment page faults 
					page_faults++; 
				} 
			} 
		} 
	
		return page_faults; 
	} 
	
	// Driver method 
	public static void main(String args[]) 
	{ 
		int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 
						2, 3, 0, 3, 2}; 

		int capacity = 4; 
		System.out.println(pageFaults(pages, pages.length, capacity)); 
	} 
} 
