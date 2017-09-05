import java.util.Scanner;

public class ReallyNewPattern {
	public static String[] pattern;
	public static String symbols;
	public static int[][]mat;
	public static int patLength = 0;
	public static int symLength = 0;
	public static boolean ans = true;

	public static void main(String[] Args) {
		Scanner scan = new Scanner(System.in);
		String n=scan.nextLine();
		int whitespace=n.indexOf(" ");
		symbols=(n.substring(0, whitespace));
		String s=(n.substring(whitespace+1,n.length()));
		s=s.trim();
		pattern=s.split("\\*");
		for(int i=0;i<pattern.length;i++)
		{
			//			
			if(pattern[i].length()>0&&pattern[i]!=" ") {
			//System.out.println(pattern[i]);
			if(search(pattern[i],0)==-1) {ans=false;break;}
			symbols=symbols.substring(search(pattern[i],0)+pattern[i].length(), symbols.length());
			//System.out.println(symbols);
			}
		}
		System.out.println(ans);
	}
	public static int search(String s, int start)
	{
		for(int j=start;j<symbols.length()-s.length()+1;j++)
		{
			int flag=0;
			for(int i=0;i<s.length();i++)
			{
				//System.out.println(i);
				if(s.charAt(i)==symbols.charAt(i+j)||s.charAt(i)=='?');
				else {flag=1;break;}
			}
			//System.out.println("J:"+j +" flag:"+flag);
			if(flag==0)return j;
		}
		return -1;
	}
}