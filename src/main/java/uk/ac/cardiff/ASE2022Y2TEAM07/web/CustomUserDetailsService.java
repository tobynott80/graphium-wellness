package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Supervisor;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.SupervisorRepository;

import java.util.Collection;

// adapted from https://stackoverflow.com/questions/49387988/authentication-of-users-from-two-database-tables-in-spring-security


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SupervisorRepository supervisorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // first try loading from User table
        Employee employee = employeeRepository.findByEmail(email);
        if (employee != null) {
            return new CustomUserDetails(employee.getEmail(), employee.getPasswordHash());
        } else {
            // Not found in user table, so check admin
            Supervisor supervisor = supervisorRepository.findByEmail(email);
            if (supervisor != null) {
                return new CustomUserDetails(supervisor.getEmail(), supervisor.getPasswordHash());
            }
        }
        throw new UsernameNotFoundException("User '" + email + "' not found");
    }

    public class CustomUserDetails implements UserDetails {

        private String username;
        private String password;

        public CustomUserDetails() {
            super();
        }

        public CustomUserDetails(String username, String password) {
            this.username = username;
            this.password = password;

        }


        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return false;
        }

        @Override
        public boolean isAccountNonLocked() {
            return false;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return false;
        }

        @Override
        public boolean isEnabled() {
            return false;
        }
    }
}
