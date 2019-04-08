package inter;

import java.util.List;

import domain.*;

public interface SalGradeDao {

	public List<SalGrade> returnAllSalGrades();

	public SalGrade getSalGrade(Integer grade);

	public void createSalGrade(SalGrade s);

	public void updateSalGrade(SalGrade s);

	public void deleteSalGrade(SalGrade s);

}
