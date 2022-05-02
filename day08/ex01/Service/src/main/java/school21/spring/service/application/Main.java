package school21.spring.service.application;

import school21.spring.service.repositories.UsersRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        UsersRepository usersRepository = context.getBean("userRepoJdbc", UsersRepository.class);
        System.out.println(usersRepository.findAll () );
        usersRepository = context.getBean("userRepoJdbcTemplate", UsersRepository.class);
        System.out.println(usersRepository.findAll () );
    }
}
