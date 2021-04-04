package sample;

import java.util.Comparator;

public class StudentiComparatorMedie implements Comparator<Student> {

	boolean Crescator;
	StudentiComparatorMedie(boolean Comparare) {
		Crescator = Comparare;
	}
	@Override
	public int compare(Student o1, Student o2) {
		if(Crescator)
		{
			return Double.compare(o1.getMedie(), o2.getMedie());
		}
		else
		{
			return -Double.compare(o1.getMedie(), o2.getMedie());
		}
	}

}
