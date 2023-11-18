import java.io.*;

class Process
{
	String Pname;
	float ArrivalT;
	float BurstT;
	float WaitingT;
	float StartT;
	float FinishT;
	float TurnAroundT;
	public Process(String string, int i, int j) {
		Pname=string;
		ArrivalT=i;
		BurstT=j;
	}
	
}

public class FCFScode
{
	public static void main(String[] args)throws Exception {
		Process P[]=new Process[15];
		Process temp;
		int index=0;
		P[index]=new Process("T1",4,6);
		index++;
		P[index]=new Process("T2",0,2);
		index++;
		P[index]=new Process("T3",1,3);
		index++;
		P[index]=new Process("T4",3,4);
		index++;
		P[index]=new Process("T5",2,5);
		index++;
		
		System.out.println("Entered processes are ");
		for(int a=0;a<index;a++)
		{
			System.out.print(P[a].Pname+"	");
			System.out.print(P[a].ArrivalT+"	");
			System.out.println(P[a].BurstT);
		}
		
		for(int s=0;s<(index-1);s++)
		{
			for(int t=0;t<(index-s-1);t++)
			if(P[t].ArrivalT>P[t+1].ArrivalT)
			{
				temp=P[t];
				P[t]=P[t+1];
				P[t+1]=temp;
			}
		}
		System.out.println("\nSorted Processes are: ");
		for(int a=0;a<index;a++)
		{
			System.out.print(P[a].Pname+"	");
			System.out.print(P[a].ArrivalT+"	");
			System.out.println(P[a].BurstT);
		}
		System.out.println("\nName"+"	"+"AT"+"	"+"BT"+"	"+"WT"+"	"+"ST"+"	"+"FT"+"	"+"TAT");
		P[0].StartT=P[0].ArrivalT;
		for(int k=0;k<index;k++)
		{
			P[k].WaitingT=P[k].StartT-P[k].ArrivalT;
			P[k].FinishT=P[k].StartT+P[k].BurstT;
			P[k].TurnAroundT=P[k].WaitingT+P[k].BurstT;
			if(k+1<index)
			{
			P[k+1].StartT=P[k].FinishT;
			}
System.out.println(P[k].Pname+"	"+P[k].ArrivalT+"	"+P[k].BurstT+"	"+P[k].WaitingT+"	"+P[k].StartT+"	"+P[k].FinishT+"	"+P[k].TurnAroundT);
			
		}
		
		
			
			
	}
	
}
/*output:

Entered processes are
T1    4.0    6.0
T2    0.0    2.0
T3    1.0    3.0
T4    3.0    4.0
T5    2.0    5.0

Sorted Processes are:
T2    0.0    2.0
T3    1.0    3.0
T5    2.0    5.0
T4    3.0    4.0
T1    4.0    6.0

Name    AT    BT    WT    ST    FT    TAT
T2    0.0    2.0    0.0    0.0    2.0    2.0
T3    1.0    3.0    1.0    2.0    5.0    4.0
T5    2.0    5.0    3.0    5.0    10.0    8.0
T4    3.0    4.0    7.0    10.0    14.0    11.0
T1    4.0    6.0    10.0    14.0    20.0    16.0*/
