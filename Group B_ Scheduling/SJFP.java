import java.io.*;
import java.util.Scanner;
class Pro
{
	String pnm;
	int AT;
	int BT;
	int WT;
	int ST;
	int FT;
	int RT;
	int TAT;
	int flag;
	public Pro(String pnm1,int AT1,int BT1,int flag,int RT1)
	{
		this.pnm=pnm1;
		this.AT=AT1;
		this.BT=BT1;
		this.flag=flag;
		this.RT=RT1;
	}
}
public class SJFP
{
public static void main(String args[])
{
	Pro p[]=new Pro[15];
	int no;
	int att,btt,flag = 0,rtt;
	String pronm;
	Scanner sc=new Scanner(System.in);
	System.out.println("How many task to be entered??");
	no=sc.nextInt();
		for(int i=0;i<no;i++)
		{
			System.out.println("Enter Process_name,Arrival_Time ,Burst_Time");
			pronm=sc.next();
			att=sc.nextInt();
			btt=sc.nextInt();
			flag=sc.nextInt();
			rtt=sc.nextInt();
			p[i]=new  Pro(pronm,att,btt,flag,rtt);
		}
		System.out.println("\nProcess\tArrival_time\tBurst_Time\tFlag\t Remaining Time");
		for(int i=0;i<no;i++)
		{
		System.out.println("\n"+p[i].pnm+"\t\t"+p[i].AT+"\t"+p[i].BT);	
		}
		//void sjf()
		//{
		int CT=0,min,index,i,flag1;	
		int completeP=0;
		while(completeP<no)
		{
			min=9999;
			flag1=0;
			index=-1;
			for(i=0;i<no;i++)
			{
			if((p[i].AT<=CT)&&(p[i].flag==0))
			{
				if(p[i].RT<min)
				{
				min=p[i].RT;
				index=i;
				flag1=1;
				}
			}//if
			}//for
			if(flag1==1)
			{
				if(p[index].RT==p[index].BT)
				{	
				p[index].ST=CT;
				}//if
			p[index].RT--;
			CT++;
			if(p[index].RT==0)
			{
				p[index].FT=CT;
				p[index].WT=p[index].FT-p[index].AT-p[index].BT;
				p[index].TAT=p[index].WT+p[index].BT;
				completeP++;
				p[index].flag=1;
			}
			}//if
			else
			{
			CT++;
			}
		}//while
		System.out.println("\nProcess\tAT\tBT\tRT\tST\tFT\tWT\tTAT");
		for(int j=0;j<no;j++)
		{
		System.out.println("\n"+p[j].pnm+"\t\t"+p[j].AT+"\t"+p[j].BT+"\t"+p[j].RT+"\t"+p[j].ST+"\t"+p[j].FT+"\t"+p[j].WT+"\t"+p[j].TAT);	
		}
		//}//SJF()
}//main()
}
/*Output:
How many task to be entered??
3
Enter Process_name,Arrival_Time ,Burst_Time
P1 0 10 0 10
Enter Process_name,Arrival_Time ,Burst_Time
P2 0 4 0 4
Enter Process_name,Arrival_Time ,Burst_Time
P3 1 2 0 2

Process	Arrival_time	Burst_Time	Flag	 Remaining Time

P1		0	10

P2		0	4

P3		1	2

Process		AT	BT	RT	ST	FT	WT	TAT

P1		0	10	0	6	16	6	16

P2		0	4	0	0	6	2	6

P3		1	2	0	1	3	0	2
/*
 */