
import java.util.*;
class Process1{
	int pname;
	int bt;
	float wt;
	float st;
	float ft;
	float tat;
	int rt;
	int at;
	
	public Process1(int a,int b){
		at=a;
		bt=b;
	}
}
public class RoundRobin {
	int n;
	int quantum;
	float awt=0,atat=0;
	int completeProcess=0,ct=0;
	void work()
	{
		int a,b;
		
		System.out.println("Enter no of processes.");
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		System.out.println("Enter the time quantum");
		quantum=sc.nextInt();
		Process1 P[]=new Process1[n];
		for(int i=0;i<n;i++){
			System.out.println("enter the arrival time and burst time for process " +(i+1));
			a=sc.nextInt();
			b=sc.nextInt();
			P[i]=new Process1(a,b);
			P[i].pname=(i+1);
			P[i].rt=P[i].bt;
		}
		
		for(int i=0;i<n-1;i++)
		   {
		     for(int j=i+1;j<n;j++)
		     {
		       if(P[i].at<P[j].at)
		       {
		    int x=P[i].at;
		     P[i].at=P[j].at;
		     P[j].at=x;
		     x=P[i].bt;
		     P[i].bt=P[j].bt;
		     P[j].bt=x;
		     x=P[i].pname;
		     P[i].pname=P[j].pname;
		     P[j].pname=x;
		      }
		   }
		}
		
		
		while(completeProcess<n)
		{
			
			int min=9999,flag1=0,ind=-1;
			for(int i=0;i<n;i++)
			{
				if(P[i].at<=ct && P[i].rt<0)
				{
					if(P[i].rt<min)
					{
					ind=i;
					min=P[i].rt;
					flag1=1;
					}
				}
				
				
			}
			if(flag1==1)
			{
				if(P[ind].rt==P[ind].bt)
				{
					P[ind].st=ct;
					P[ind].rt-=quantum;
					ct+=quantum;
				}
				
				if(P[ind].rt<quantum)
				{
					ct=ct+P[ind].rt;
					P[ind].ft=ct;
					P[ind].wt=P[ind].ft-P[ind].at-P[ind].bt;
					P[ind].tat=P[ind].wt+P[ind].bt;
					P[ind].rt=0;
					completeProcess++;
				}
				else
				{
					P[ind].rt-=quantum;
					ct+=quantum;
				}
			}
			else
				ct++;
			
		}//end of while
		
		
	
		
		System.out.println("Proc\tArrT\tburstT\tWaitT\tTAT\tStart\tFinish");
		for(int i=0;i<n;i++){
			System.out.println("P"+i+"\t"+P[i].at+"\t"+P[i].bt+"\t"+P[i].wt+"\t"+P[i].tat+"\t"+P[i].st+"\t"+P[i].ft);
			awt=awt+P[i].wt;
			atat=atat+P[i].tat;
		}
		awt=awt/n;
		atat=atat/n;
		System.out.println("Tha average waiting time is "+awt);
		System.out.println("Tha average turn around time is "+atat);
	}
	
	public static void main(String[] args) {
		RoundRobin obj1=new RoundRobin();
		obj1.work();
	}

}
