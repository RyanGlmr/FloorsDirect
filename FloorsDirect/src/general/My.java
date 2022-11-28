package general;

public class My {

	public static void p (String s)
	{
		System.out.printf(s);
	}
	public static void pln (String s)
	{
		System.out.println(s);
	}
	public static void clear()
	{
		My.p("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	public static void titleBar()
	{
	My.p("\n==========================================================================");
	}
}
