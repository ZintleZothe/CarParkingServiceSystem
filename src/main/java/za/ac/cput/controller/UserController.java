package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Role;
import za.ac.cput.entity.User;
import za.ac.cput.factory.RoleFactory;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.service.impl.RoleServiceImpl;
import za.ac.cput.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/carparkingservice/user")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    //C-> Create
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        User newUser = UserFactory.build(user.getFirstName(), user.getLastName(), user.getAddress(), user.getCellNumber(), user.getEmailAddress());
        return userService.create(newUser);
    }

    //R-> Read
    @GetMapping("/read/{id}")
    public User read(@PathVariable String id) {
        return userService.read(id);
    }

    //U->Update
    @PostMapping("/update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    //D-> delete
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return userService.delete(id);
    }

    @GetMapping("/getall")
    public List<User> getAll() {
        return userService.getAll();
    }
}
