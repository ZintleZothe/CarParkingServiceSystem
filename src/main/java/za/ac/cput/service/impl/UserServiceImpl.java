package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Role;
import za.ac.cput.entity.User;
import za.ac.cput.repository.IUserRepository;
import za.ac.cput.repository.RoleRepository;

import za.ac.cput.service.RoleService;
import za.ac.cput.service.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private IUserRepository repository;

    public UserServiceImpl(IUserRepository repository){this.repository = repository;}

    @Override
    public User create(User user) {
        return this.repository.save(user);
    }

    @Override
    public User read(String userID) {
        return this.repository.findById(userID).orElse(null);
    }

    @Override
    public User update(User user) {
        if (this.repository.existsById(user.getUserID()))
            return this.repository.save(user);
        return null;
    }

    @Override
    public boolean delete(String userID) {
        this.repository.deleteById(userID);
        if (this.repository.existsById(userID))
            return false;
        else
            return true;
    }

    @Override
    public List<User> getAll(){
        return this.repository.findAll();
    }
}
