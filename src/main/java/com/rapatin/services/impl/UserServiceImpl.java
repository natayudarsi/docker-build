package com.rapatin.services.impl;

import com.rapatin.entities.User;
import com.rapatin.repositories.UserRepository;
import com.rapatin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service(value = "userService")
public class UserServiceImpl implements  UserService {
    @Autowired
    UserRepository repo;

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public User findById(Integer id) {
        return repo.findByid(id);
    }

    @Override
    public User create(User newUSer) {
        newUSer.setPassword(hash(newUSer.getPassword()));
        return repo.save(newUSer);
    }

    @Override
    public User update(User newUser) {
        return repo.save(newUser);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public String hash(String password){

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] messageDiggest = md.digest(password.getBytes());

            BigInteger no = new BigInteger(1, messageDiggest);
            String hashTest = no.toString(16);

            while (hashTest.length() < 32){
                hashTest = "0" + hashTest;
            }

            return hashTest;
        } catch (NoSuchAlgorithmException e) {
            throw  new RuntimeException(e);
        }
    }

//    @Override
//    public UserDetails loadUserByUsername(String nama) throws UsernameNotFoundException {
//        User user = repo.findByName(nama);
//        System.out.println(user.toString());
//        if(user == null){
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), getAuthority());
//    }
//
//    public List getAuthority() {
//        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//    }
}
