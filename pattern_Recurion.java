import java.util.Scanner;


public class pattern {
	public static char[] symbols;
	public static char[] pattern;
	public static int patLength=0;
	public static int symLength=0;
	public static boolean ans=false;
	
	public static void main(String[] Args)
	{
		Scanner scan = new Scanner(System.in);
		String n=scan.nextLine();
		int whitespace=n.indexOf(" ");
		symbols=(n.substring(0, whitespace)).trim().toCharArray();
		int br=0;
		String s=n.substring(whitespace+1,n.length()).trim();
		patLength=n.length()-whitespace-1;
		if(patLength==0) {System.out.println("true");return ;}
		for(int i=0;i<patLength;i++)
		{
			if(s.charAt(i)=='*')br++;
			else break;
		}
		pattern=(n.substring(whitespace+1+br,n.length())).toCharArray();
		//System.out.println(br);
		symLength=whitespace;
		if(symLength==0){System.out.println("false");return ;}
		boolean flag=true;
		patLength-=br;
		for(int i=0;i<patLength;i++)
		{
			if(pattern[i]!='*')flag=false;
		}
		if(flag==true)
		{
			System.out.println("true");
			scan.close();
			return;
		}
		br=0;
		for(int i=patLength-1;i>=0;i--)
		{
			if(pattern[i]=='*')br++;
			if(pattern[i]!='*')break;
		}
		patLength-=br;
		for(int i=0;i<symLength;i++)
		{
			rec(i , 0);
		}
		
		if(ans==true)System.out.println("true");
		if(ans==false)System.out.println("false");
		scan.close();
	}
	
	public static void rec(int start, int patindex)//now is the char we are looking for and patindex is his index in pattern; start is where we start the search
	{
		char now=pattern[patindex];
		if(start>symLength-1)return;
		if(now=='*')
		{
			if(patindex+1==patLength) {ans=true;return;}
			if(pattern[patindex+1]=='*')rec(start,patindex+1);
			else 
			{
				char next=pattern[patindex+1];
				if(next=='?')
				for(int i=start;i<symLength;i++)
				{
						if(patindex==patLength-1) {ans=true;return;}//if we found now and its the last element we found an answer
						rec(i,patindex+1);		
				}
				else
				for(int i=start;i<symLength;i++)
				{
					if(symbols[i]==next)
					{
						//debug(i);
						if(patindex==patLength-1) {ans=true;return;}//if we found now and its the last element we found an answer
						rec(i,patindex+1);		
					}
				}
			}
		}else
		if(now=='?')
		{
			if(patindex==patLength-1) {ans=true;return;}
			if(start==symLength-1)return;
			rec(start+1, patindex + 1);
		}else
		if(patindex<patLength)
		{	
			//System.out.println(patindex);
			//System.out.println(now+" "+symbols[start]);
			if(now==symbols[start])
			{
				if(patindex==patLength-1) {ans=true;return;}
				rec(start+1, patindex + 1);
			}
		}
		return ;
	}
}