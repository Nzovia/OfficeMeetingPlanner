package com.nicholas.officemanager;

import com.nicholas.officemanager.entitities.Roles;
import com.nicholas.officemanager.entitities.Users;
import com.nicholas.officemanager.repositories.RolesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RoleRepositoryTest {
    @Autowired
    public RolesRepository rolesRepository;
    @Test
    public void testCreateRole(){
        Roles user = new Roles("Users");
        Roles admin = new Roles("Admin");
        Roles customer = new Roles("Customer");

        rolesRepository.saveAll(List.of(user,admin,customer));
        List<Roles> listRoles = rolesRepository.findAll();
        assertThat(listRoles.size()).isEqualTo(3);
        
    }
}
