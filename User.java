
package telefondefteri;

///ERGUN MERT ÇAKIR
///20140855041(İ.Ö)
public class User {//isim soy isim ve no alma ( get set)
    
	private String name;
	private String surname;
	private String number;
	
	public void Setname(String name)
	{
		this.name = name;
	}
	
	public String Getname()
	{
		return this.name;
	}
	
	public void Setsurname(String surname)
	{
		this.surname = surname;
	}
	
	public String Getsurname()
	{
		return this.surname;
	}
	
	public void Setnumber(String number)
	{
		this.number = number;
	}
	
	public String Getnumber()
	{
		return this.number;
	}
}
