package inter;

import java.util.List;
import domain.*;

/**
 * 
 * @author omer
 *
 */
public interface EmpDao {

	public Emp getEmployee(Integer empNo);

	public List<Emp> listAllEmployees();

	public List<Emp> listAllEmployeesByEmpNo(Integer empNo);

	public List<Emp> listAllEmployeesByEName(String eName);

	public List<Emp> listAllEmployeesByJob(String job);

	public List<Emp> listAllEmployeesByMgr(Integer mgr);

	public List<Emp> listAllEmployeesByHireDate(String hireDate);

	public List<Emp> listAllEmployeesBySal(Integer sal);

	public List<Emp> listAllEmployeesByComm(Integer comm);

	public List<Emp> listAllEmployeesByDeptNo(Integer deptNo);

	public List<Emp> listAllEmployeesByDept(Dept d);

	public List<Emp> listAllEmployeesByDeptNoWhenSalaryLessThan(Integer deptNo, Integer salLevel);

	public void updateEmployee(Emp e);

	public void deleteEmployee(Emp e);

	public void createEmployee(Emp e);

}
