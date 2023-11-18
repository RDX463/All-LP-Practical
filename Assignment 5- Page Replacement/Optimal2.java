import java.io.*;
import java.util.*;
public class Optimal2
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
int n,f,pageHit = 0,pageFault = 0,pointer = 0;
boolean isFull = false;
System.out.println("Enter the number of pages :\n ");
n = sc.nextInt();
System.out.println("Enter the number of frames :\n");
f = sc.nextInt();
int frame[] = new int[f];
int pages[] = new int[n];
System.out.println("enter the"+" "+n+" " +"page numbers");
for(int i=0;i<n;i++)
{
pages[i] = sc.nextInt();
}
System.out.println("Entered page numbers");
for(int i=0;i<n;i++)
{
System.out.print("\t"+pages[i]);
}
for(int i=0;i<f;i++)
{
frame[i] = -1;
}
System.out.println("\nInitial Frames contents :");
for(int i=0;i<f;i++)
{
System.out.print("\t"+frame[i]);
}
for(int i=0;i<n;i++) //start searching empty frames
{
int search = -1;
for(int j=0;j<f;j++)
{
if(frame[j] == pages[i])
{
search = j;
pageHit++;
break;
}
}
if(search == -1) //if no page found
{
if(isFull)
{
int index[] = new int[f];
boolean index_flag[] = new boolean[f];
for(int j = i+1 ;j<n;j++)
{
for(int k = 0;k < f;k++)
{
if((pages[j] == frame[k]) && (index_flag[k] == false))
{
index[k] = j;
index_flag[k] = true;
break;
}
}
}
int max = index[0];
pointer = 0;
if(max == 0)
{
max = 200;
}
for(int j=0;j<f;j++)
{
if(index[j] == 0)
{
index[j] = 200;
}
if(index[j] > max)
{
max = index[j];
pointer = j;
}
}//end for
} //end of isFull
frame[pointer] = pages[i];
pageFault++;
if(!isFull)
{
pointer++;
if(pointer == f)
{
pointer = 0;
isFull = true;
}
}
} //end if
System.out.print("\nFrame contents after inserting page:"+" "+i+"\n");
for(int k=0;k<f;k++)
{
System.out.print(frame[k]+" ");
}
System.out.println();
} //end for
System.out.println("\n*****************************************");
System.out.println("\nNumber of page hits :\n" + pageHit);
System.out.println("Number of page faults :\n" + pageFault);
int pageFR = (pageFault*100) / n;
System.out.println("Page fault rate :\n" + pageFR);
}
}