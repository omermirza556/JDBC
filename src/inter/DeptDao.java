package inter;

import java.util.List;
import domain.*;

/**
 * 
 * @author omer
 *
 */
public interface DeptDao {
	public Dept getDept(Integer deptNo);

	public Dept getDeptByName(String dName);

	public Dept getDeptByLoc(String Loc);
	
	public List<Dept> getAllDepts();

	public void updateDept(Dept d);

	public void deleteDept(Dept d);

	public void createDept(Dept d);

}
