import java.util.*;
class Process3{
	int pname;
	int bt;
	float wt;
	float st;
	float ft;
	float tat;
	int rt;
	int at;
	
	public Process3(int a,int b){
		at=a;
		bt=b;
	}
}
public class RRWP {

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
		Process3 P[]=new Process3[n];
		for(int i=0;i<n;i++){
			System.out.println("enter the arrival time and burst time for process " +(i+1));
			a=sc.nextInt();
			b=sc.nextInt();
			P[i]=new Process3(a,b);
			P[i].pname=(i+1);
			P[i].rt=P[i].bt;
		}
		while(completeProcess<n)
		{
			for(int i=0;i<n;i++)
			{
				if(P[i].rt>0)
				{
					if(P[i].rt<quantum)
					{
						ct=ct+P[i].rt;
						P[i].ft=ct;
						P[i].wt=P[i].ft-P[i].at-P[i].bt;
						P[i].tat=P[i].wt+P[i].bt;
						P[i].rt=0;
						completeProcess++;
					}
					else
					{

						P[i].rt-=quantum;
						ct+=quantum;
					}
				}
			}
		}
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
		RRWP ob=new RRWP();
		ob.work();
	}

}
