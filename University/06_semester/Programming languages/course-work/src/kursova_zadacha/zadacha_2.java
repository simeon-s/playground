package kursova_zadacha;
import kursova_zadacha.Film;


public class zadacha_2 {

	public static Film[] obj = new Film[5] ;  
	public static int filmCounter = 0;
	public static void testFunc()
	{
		System.out.println(obj.length);

	}
	public static void addFilm(String iN, String z, String r, String j, int g)
	{
		obj[filmCounter] = new Film();
		if(searchForDuplicates(iN) == 0)
		{
			obj[filmCounter++].setData( iN,  z,  r,  j,  g);
		}
		else
		{
			System.out.println("Film with this 'invertarenNomer': "+ iN + " already exist.");
		}
	}
	public static void printAll()
	{
		for(int i=0; i<filmCounter;i++)
		{
			System.out.println(obj[i].godinaNaIzlizane);
		}
	}
	public static int search(String invertarenNomer)
	{
		int flagFound = 0;
		for(int i=0; i<filmCounter;i++)
		{
			if(obj[i].invertarenNomer == invertarenNomer)
			{
				System.out.print("Found: ");
				obj[i].showData();
				flagFound = 1;
				return i;
			}
		}
		if(flagFound == 0)
		{
			System.out.print("ERROR: There is no film with this invertarenNomer: " + invertarenNomer);
			return 0;
		}
		return 0;
			
	}
	public static int searchForDuplicates(String invertarenNomer)
	{
		for(int i=0; i<filmCounter;i++)
		{
			if(obj[i].invertarenNomer == invertarenNomer)
			{
				return 1; // There is a duplicate
			}
		}
		return 0;
			
	}
	public static void main(String[] args) {
		addFilm("0001", "Fast and Furious", "Justin Lin", "Action", 2001);
		addFilm("0001", "Fast and Furious 2", "Justin Lin", "Action", 2003);
		addFilm("0002", "The Shawshank Redemption", "Frank Darabont", "Drama",1994);

		System.out.println("edno");
		System.out.println("filmCoutner" + filmCounter);
		printAll();
		int result = search("0001");
        
	}

}
