package uk.ac.cardiff.ASE2022Y2TEAM07.repositories;

import org.springframework.stereotype.Repository;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;


@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private EmployeeRepositorySpringDataJdbc repoJdbc;

    public EmployeeRepositoryImpl(EmployeeRepositorySpringDataJdbc aRepo) {
        repoJdbc = aRepo;
    }

    @Override
    public Employee findByEmail(String email) {
        return repoJdbc.findByEmail(email);
    }

}
