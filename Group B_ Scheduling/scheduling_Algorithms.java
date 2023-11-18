

import java.util.*;
import java.util.Arrays;

public class scheduling_Algorithms
{
	//int no_of_process;
	static int no_of_process;
    static int proc_no[]=new int[15]; 
    static int burst_time[]=new int[15];
    public static void fcfs()
    {   int waiting_time=0;
        int t_time;
        burst_time[0]=0;
    	System.out.println("Process"+"\t"+"Burst time"+"\t"+"waiting time"+"\t"+"turnaround time"+"\n");
    	for(int i=1;i<=no_of_process;i++)
    	{   waiting_time=waiting_time+burst_time[i-1];
    	    t_time=waiting_time+burst_time[i];
    		System.out.println(proc_no[i]+"\t"+burst_time[i]+"\t"+"\t"+waiting_time+"\t"+"\t"+t_time+"\n");
    	}
    }
    public static void SJF()
    {   int temp,temp1;
    int proc_no1[]=new int[15]; 
    int burst_time1[]=new int[15]; 
    for(int i=1;i<=no_of_process;i++)
    {
    	proc_no1[i]=proc_no[i];
    	burst_time1[i]=burst_time[i];
    }
    	for(int i=1;i<=no_of_process-1;i++)
    	{
    		for(int j=1;j<=(no_of_process-1);j++)
    		{
    			if(burst_time1[j]>burst_time1[j+1])
    			{
    				temp=burst_time1[j+1];
    				temp1=proc_no1[j+1];
    				burst_time1[j+1]=burst_time1[j];
    				proc_no1[j+1]=proc_no1[j];
    				burst_time1[j]=temp;
    				proc_no1[j]=temp1;
    			}
    		}
    	}
    	int waiting_time=0;
        int t_time;
        burst_time1[0]=0;
    	System.out.println("Process"+"\t"+"Burst time"+"\t"+"waiting time"+"\t"+"turnaround time"+"\n");
    	for(int i=1;i<=no_of_process;i++)
    	{   waiting_time=waiting_time+burst_time1[i-1];
    	    t_time=waiting_time+burst_time1[i];
    		System.out.println(proc_no1[i]+"\t"+burst_time1[i]+"\t"+"\t"+waiting_time+"\t"+"\t"+t_time+"\n");
    	}
    	
    	
    }
    
    static void priority()
    {       Scanner sc=new Scanner(System.in);

    	int pr1[]=new int[15];
    	int temp,temp1,temp2;
        int proc_no1[]=new int[15]; 
        int burst_time1[]=new int[15]; 
    	for(int i=1;i<=no_of_process;i++)
    	{
    		System.out.print("priority of "+proc_no[i]+": ");
    		pr1[i]=sc.nextInt();
    		System.out.println("\n");
    	}
    	
        for(int i=1;i<=no_of_process;i++)
        {
        	proc_no1[i]=proc_no[i];
        	burst_time1[i]=burst_time[i];
        }
        	for(int i=1;i<=no_of_process-1;i++)
        	{
        		for(int j=1;j<=(no_of_process-1);j++)
        		{
        			if(pr1[j]>pr1[j+1])
        			{
        				temp=burst_time1[j+1];
        				temp1=proc_no1[j+1];
        				temp2=pr1[j+1];
        				burst_time1[j+1]=burst_time1[j];
        				proc_no1[j+1]=proc_no1[j];
        				pr1[j+1]=pr1[j];
        				burst_time1[j]=temp;
        				proc_no1[j]=temp1;
        				pr1[j]=temp2;
        			}
        		}
        	}
        	int waiting_time=0;
            int t_time;
            burst_time1[0]=0;
        	System.out.println("Process"+"\t"+"Burst time"+"\t"+"waiting time"+"\t"+"turnaround time"+"\t"+"priority"+"\n");
        	for(int i=1;i<=no_of_process;i++)
        	{   waiting_time=waiting_time+burst_time1[i-1];
        	    t_time=waiting_time+burst_time1[i];
        		System.out.println(proc_no1[i]+"\t"+burst_time1[i]+"\t"+"\t"+waiting_time+"\t"+"\t"+t_time+"\t"+"\t"+pr1[i]+"\n");
        	}
        	
    	
    }
    static void RR()
{
    	
   Scanner sc=new Scanner(System.in);
   System.out.println("enter Quantum: ");
   int  quantum=sc.nextInt();
   // Make a copy of burst times bt[] to store remaining
   // burst times.
   int rem_bt[] = new int[no_of_process+1];
   int wt[]=new int[no_of_process+1];
   for (int i = 1 ; i <= no_of_process ; i++)
       rem_bt[i] =  burst_time[i];
 
   int t = 0; // Current time
  int t_time;
   // Keep traversing processes in round robin manner
   // until all of them are not done.
   while(true)
   {
       boolean done = true;
 
       // Traverse all processes one by one repeatedly
       for (int i = 1 ; i <= no_of_process; i++)
       {
           // If burst time of a process is greater than 0
           // then only need to process further
           if (rem_bt[i] > 0)
           {
               done = false; // There is a pending process
 
               if (rem_bt[i] > quantum)
               {
                   // Increase the value of t i.e. shows
                   // how much time a process has been processed
                   t += quantum;
 
                   // Decrease the burst_time of current process
                   // by quantum
                   rem_bt[i] -= quantum;
               }
 
               // If burst time is smaller than or equal to
               // quantum. Last cycle for this process
               else
               {
                   // Increase the value of t i.e. shows
                   // how much time a process has been processed
                   t = t + rem_bt[i];
 
                   // Waiting time is current time minus time
                   // used by this process
                   wt[i] = t - burst_time[i];
 
                   // As the process gets fully executed
                   // make its remaining burst time = 0
                   rem_bt[i] = 0;
               }
           }
       }
 
       // If all processes are done
       if (done == true)
         break;
   }
   
   for(int i=1;i<=no_of_process;i++)
	{   
	    t_time=wt[i]+burst_time[i];
    	System.out.println("Process"+"\t"+"Burst time"+"\t"+"waiting time"+"\t"+"turnaround time"+"\t"+"priority"+"\n");
		System.out.println(proc_no[i]+"\t"+burst_time[i]+"\t"+"\t"+wt[i]+"\t"+"\t"+t_time+"\n");
	}
}
	
	public static void main(String args[])
	{   
		int choice,choice1;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of processors"+"\n");
		no_of_process=sc.nextInt();
		
		for (int i=1;i<=no_of_process;i++)
		{
			System.out.println("Enter Process no: ");
			proc_no[i]=sc.nextInt();
			System.out.println("Enter burst time: ");
			burst_time[i]=sc.nextInt();
			
		}
		do{
		System.out.println("   Sheduling Algorithms"+"\n");
		System.out.println("1.FCFS"+"\n"+"2.SJF"+"\n"+"3.Priority"+"\n"+"4.RR"+"\n"+"5.Exit"+"\n");
		System.out.println("enter your choice: ");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:fcfs();
				break;
		case 2:SJF();
		       break;
		case 3:priority();
		       break;
		case 4:RR();
			   break;
	
		case 5:System.exit(0);
		       break;
		}
		
		}while(choice!=6);
		
	}
}
/*Enter no of processors

5
Enter Process no: 
1
Enter burst time: 
10
Enter Process no: 
2
Enter burst time: 
1
Enter Process no: 
3
Enter burst time: 
2
Enter Process no: 
4
Enter burst time: 
1
Enter Process no: 
5
Enter burst time: 
5
   Sheduling Algorithms

1.FCFS
2.SJF
3.Priority
4.RR
5.Exit

enter your choice: 
1
Process	Burst time	waiting time	turnaround time

1	10		0		10

2	1		10		11

3	2		11		13

4	1		13		14

5	5		14		19

   Sheduling Algorithms

1.FCFS
2.SJF
3.Priority
4.RR
5.Exit

enter your choice: 
2
Process	Burst time	waiting time	turnaround time

2	1		0		1

4	1		1		2

3	2		2		4

5	5		4		9

1	10		9		19

   Sheduling Algorithms

1.FCFS
2.SJF
3.Priority
4.RR
5.Exit

enter your choice: 
3
priority of 1: 3


priority of 2: 1


priority of 3: 3


priority of 4: 4


priority of 5: 2


Process	Burst time	waiting time	turnaround time	priority

2	1		0		1		1

5	5		1		6		2

1	10		6		16		3

3	2		16		18		3

4	1		18		19		4

   Sheduling Algorithms

1.FCFS
2.SJF
3.Priority
4.RR
5.Exit

enter your choice: 
4
enter Quantum: 
3
Process	Burst time	waiting time	turnaround time	priority

1	10		9		19

Process	Burst time	waiting time	turnaround time	priority

2	1		3		4

Process	Burst time	waiting time	turnaround time	priority

3	2		4		6

Process	Burst time	waiting time	turnaround time	priority

4	1		6		7

Process	Burst time	waiting time	turnaround time	priority

5	5		10		15

   Sheduling Algorithms

1.FCFS
2.SJF
3.Priority
4.RR
5.Exit

enter your choice: 
5

*/