package com.jac.mvc.relationships.one_to_one;

import com.jac.mvc.relationships.one_to_one.entity.User;
import com.jac.mvc.relationships.one_to_one.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication1 implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public DemoApplication1(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication1.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("I am running alone !!!");

        UserProfile userProfile = UserProfile.builder().address("Montreal").phoneNumber("9999").build();
        User userToSave = User.builder()
                .firstName("pepa")
                .lastName("PEPPPA")
                .email("peppa.pig@gmail.com")
                .passWord("123445")
//                .age(-2)// gives constraint error
                .age(12)
                .userProfile(userProfile)
                .build();

        userRepository.save(userToSave);
        System.out.println("user saved in db");


        Optional<User> byId = userRepository.findById(1L);
        if(byId.isPresent()){
            System.out.println("the object is" + byId.get());
            User userToModify = byId.get();
            userToModify.setFirstName("Suzy sheep");
            userRepository.save(userToModify);
            System.out.println("user updated in db");

        }




        List<User> all = userRepository.findAll();
        for(User user: all){
            userRepository.delete(user);
        }


    }
}
