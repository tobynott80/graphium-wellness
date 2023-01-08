package uk.ac.cardiff.ASE2022Y2TEAM07.web;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Employee;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.Supervisor;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.EmployeeRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.SupervisorRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// adapted from https://stackoverflow.com/questions/49387988/authentication-of-users-from-two-database-tables-in-spring-security


@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SupervisorRepository supervisorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // first try loading from User table
        log.info("Trying to login as " + email);
        Employee employee = employeeRepository.findByEmail(email);
        if (employee != null) {
            log.info("Found user " + employee.getEmail());
            log.info("Attempting to login as employee");
            return new CustomUserDetails(employee.getEmail(), employee.getPasswordHash(), "ROLE_EMPLOYEE");
        } else {
            // Not found in user table, so check supervisor
            Supervisor supervisor = supervisorRepository.findByEmail(email);
            if (supervisor != null) {
                log.info("Found user " + supervisor.getEmail());
                log.info("Attempting to login as supervisor");
                return new CustomUserDetails(supervisor.getEmail(), supervisor.getPasswordHash(), "ROLE_SUPERVISOR");
            }
        }
        log.warn("User not found");
        throw new UsernameNotFoundException("User '" + email + "' not found");
    }

    public class CustomUserDetails implements UserDetails {

        private String username;
        private String password;
        private String role;

        public CustomUserDetails() {
            super();
        }

        public CustomUserDetails(String username, String password, String role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }


        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
            list.add(new SimpleGrantedAuthority(role));
            return list;
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
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
