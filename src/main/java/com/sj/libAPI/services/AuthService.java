package com.sj.libAPI.services;

import com.sj.libAPI.models.DTO.auth.SignInReq;
import com.sj.libAPI.models.DTO.auth.SignUpReq;
import com.sj.libAPI.models.entities.Library;
import com.sj.libAPI.models.entities.User;
import com.sj.libAPI.models.entities.Worker;
import com.sj.libAPI.repositories.UserRepository;
import com.sj.libAPI.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Locale;

@Service
public class AuthService {

    @Autowired
    private UserRepository _userRepository;

    @Autowired
    private WorkerRepository _workerRepository;

    private PasswordEncoder _encoder = new BCryptPasswordEncoder();

    public boolean signIn(SignInReq data) {

        if(data.getIsWorker()){

            Worker worker = _workerRepository.findByEmail(data.getEmail());

            if(worker == null){
                return false;
            }

            if(!_encoder.matches(data.getPassword(), worker.getPassword())){
                return false;
            }

        }
        else {

            User user = _userRepository.findByEmail(data.getEmail());

            if(user == null){
                return false;
            }

            if(!_encoder.matches(data.getPassword(), user.getPassword())){
                return false;
            }

        }

        return true;

    }

    @Transactional
    public boolean signUp(SignUpReq data) {

        if(data.getIsWorker()){

            Worker worker = _workerRepository.findByEmail(data.getEmail().toLowerCase(Locale.ROOT));

            if(worker != null){
                return false;
            }

            Worker newWorker = new Worker();
            newWorker.setName(data.getName());
            newWorker.setSurname(data.getSurname());
            newWorker.setContactPhone(data.getContactPhone());
            newWorker.setEmail(data.getEmail().toLowerCase(Locale.ROOT));
            newWorker.setPassword(_encoder.encode(data.getPassword()));
            newWorker.setLibrary(new Library(data.getLibrary()));
            _workerRepository.save(newWorker);

        }
        else{
            User user = _userRepository.findByEmail(data.getEmail().toLowerCase(Locale.ROOT));

            if(user != null){
                return false;
            }

            User newUser = new User();
            newUser.setName(data.getName());
            newUser.setSurname(data.getSurname());
            newUser.setContactPhone(data.getContactPhone());
            newUser.setEmail(data.getEmail().toLowerCase(Locale.ROOT));
            newUser.setPassword(_encoder.encode(data.getPassword()));
            newUser.setIsAdmin(false);
            _userRepository.save(newUser);

        }

        return true;

    }


}
