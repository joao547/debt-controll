package com.roctiv.debtcontroll.api.dao;

import com.roctiv.debtcontroll.api.entity.User;
import com.roctiv.debtcontroll.api.utils.PasswordUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    private static String senha = PasswordUtils.gerarByCrypt("86521248");

    @BeforeEach
    public void setUp() throws Exception{
        User user = new User();
        user.setNome("João Victor do Nascimento Bezerra");
        user.setUsername("joao547");
        user.setPass(senha);
        this.userDAO.save(user);
    }

    @AfterEach
    public final void tearDown(){
        this.userDAO.deleteById(1);
    }

    @Test
    public void testListarUsuarios(){
        List<User> users = this.userDAO.listUser();

        assertEquals(senha, users.get(0).getPass());

    }

}