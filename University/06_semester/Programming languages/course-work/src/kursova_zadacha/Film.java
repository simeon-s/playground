package kursova_zadacha;

public class Film {
	String invertarenNomer;
	String zaglavie;
	String rezhisior;
	String janr;
	int godinaNaIzlizane;
	public void setData(String iN, String z, String r, String j, int g)
	 {
		 invertarenNomer = iN;
		 zaglavie = z;
		 rezhisior = r;
		 janr = j;
		 godinaNaIzlizane = g;
     }
	 public void showData()
	 {
        System.out.println(invertarenNomer  + " " + zaglavie + " " + rezhisior + " " + janr + " " + godinaNaIzlizane);
        
     }
	 

}
