package sample;

public class Student {
	private String nume;
	private String prenume;
	private double medie;
	Student(String n, String p, double m){
		this.nume=n;
		this.prenume=p;
		this.medie=m;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public double getMedie() {
		return medie;
	}
	public void setMedie(double medie) {
		this.medie = medie;
	}
}
