package com.sprint.sprintr;


import com.sprint.sprintr.models.Todos;
import com.sprint.sprintr.models.Users;
import com.sprint.sprintr.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    UserServices userService;

    @Transactional
    @Override
    // public Users(String username, String primaryemail, String password,)

    public void run(String[] args) throws Exception
    {
        Users u1 = new Users("admin",
                "password",
                "admin@lambdaschool.local");
        u1.getTodos()
                .add(new Todos(u1,
                        "Give Joe access rights"));
        u1.getTodos()
                .add(new Todos(u1,
                        "Change the color of the home page"));

     userService.save(u1);

        Users u2 = new Users("cinnamon",
                "1234567",
                "cinnamon@lambdaschool.local");
        u2.getTodos()
                .add(new Todos(u2,
                        "Take a nap"));
        u2.getTodos()
                .add(new Todos(u2,
                        "Rearrange my hutch"));
        u2.getTodos()
                .add(new Todos(u2,
                        "Groom my fur"));
        userService.save(u2);

        Users u3 = new Users("barnbarn",
                "ILuvM4th!",
                "barnbarn@lambdaschool.local");
        u3.getTodos()
                .add(new Todos(u3,
                        "Rearrange my hutch"));
        userService.save(u3);

        Users u4 = new Users("puttat",
                "password",
                "puttat@school.lambda");
        userService.save(u4);

        Users u5 = new Users("misskitty",
                "password",
                "misskitty@school.lambda");
        userService.save(u5);
    }
}