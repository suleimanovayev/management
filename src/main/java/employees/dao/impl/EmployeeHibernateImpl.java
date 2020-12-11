package employees.dao.impl;

import employees.dao.EmployeeDao;
import employees.entity.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class EmployeeHibernateImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Employee create(Employee employee) {
        return (Employee) sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = sessionFactory
                .getCurrentSession()
                .createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> getEmployeeByFirstName(String firstName) {
        TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                .createQuery("from employees where first_name = :fistName", Employee.class);
        query.setParameter("fistName", firstName);
        return query.getResultList();
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = sessionFactory.getCurrentSession().get(Employee.class, id);
        sessionFactory.getCurrentSession().delete(employee);
    }
}
