import java.util.Scanner;


class Process2{
	int pname;
	int pri;
	int bt;
	float wt;
	float st;
	float ft;
	float tat;
	
	public Process2(int a,int b){
		pri=a;
		bt=b;
	}
}
	
public class Priority
 {
	int n;
	float awt=0,atat=0;
	void work()
	{
		int a,b;
		System.out.println("Enter no of processes.");
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		Process2 P[]=new Process2[n];
		for(int i=0;i<n;i++){
			System.out.println("enter the priority and burst time for process " +(i+1));
			a=sc.nextInt();
			b=sc.nextInt();
			P[i]=new Process2(a,b);
			P[i].pname=(i+1);
		}
		
		for(int i=0;i<n-1;i++)
		   {
		     for(int j=i+1;j<n;j++)
		     {
		       if(P[i].pri<P[j].pri)
		       {
		    int x=P[i].pri;
		     P[i].pri=P[j].pri;
		     P[j].pri=x;
		     x=P[i].bt;
		     P[i].bt=P[j].bt;
		     P[j].bt=x;
		     x=P[i].pname;
		     P[i].pname=P[j].pname;
		     P[j].pname=x;
		      }
		   }
		}
		for(int i=0;i<n;i++){
			
			P[i].ft=P[i].st+P[i].bt;
			P[i].wt=P[i].st;	
			P[i].tat=P[i].wt+P[i].bt;
			if(i<(n-1))
			P[i+1].st=P[i].ft;
			awt=awt+P[i].wt;
			atat=atat+P[i].tat;
		}
		
		
		awt=awt/n;
		atat=atat/n;
		
		System.out.println("Proc\tPrior\tburstT\tWaitT\tTAT\tStart\tFinish");
		for(int i=0;i<n;i++){
			System.out.println("P"+i+"\t"+P[i].pri+"\t"+P[i].bt+"\t"+P[i].wt+"\t"+P[i].tat+"\t"+P[i].st+"\t"+P[i].ft);
		}
		System.out.println("Tha average waiting time is "+awt);
		System.out.println("Tha average turn around time is "+atat);
	}
	
	public static void main(String[] args) {
		Priority ob=new Priority();
		ob.work();

	}

}
/*
Enter no of processes.
5
enter the priority and burst time for process 1
3 10
enter the priority and burst time for process 2
1 1
enter the priority and burst time for process 3
4 2
enter the priority and burst time for process 4
5 1
enter the priority and burst time for process 5
2 5
Proc	Prior	burstT	WaitT	TAT	Start	Finish
P0	5	1	0.0	1.0	0.0	1.0
P1	4	2	1.0	3.0	1.0	3.0
P2	3	10	3.0	13.0	3.0	13.0
P3	2	5	13.0	18.0	13.0	18.0
P4	1	1	18.0	19.0	18.0	19.0
Tha average waiting time is 7.0
Tha average turn around time is 10.8
*/
