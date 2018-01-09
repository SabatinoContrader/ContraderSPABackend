package it.contrader.sprint4.controller;

import it.contrader.sprint4.GenericResponse;
import it.contrader.sprint4.converter.UserConverter;
import it.contrader.sprint4.dto.UserDTO;
import it.contrader.sprint4.model.GommaEntity;
import it.contrader.sprint4.model.UserEntity;
import it.contrader.sprint4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.reflect.generics.repository.GenericDeclRepository;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(value="*")
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private UserConverter userConverter;

    @Autowired
    public UserController(UserService userService, UserConverter userConverter)
    {
        this.userService = userService;
        this.userConverter = userConverter;
    }



    @RequestMapping(value="/getUsers", method = RequestMethod.GET)
    public GenericResponse<List<UserDTO>> users () {
        List<UserDTO> users = new ArrayList<>();
        for (UserEntity userEntity: userService.findByRole("user"))
        {
            users.add(userConverter.convertToDTO(userEntity));
        }
        return new GenericResponse<>(0,users);
    }


    @RequestMapping(value="/newUser", method =RequestMethod.POST)
    public GenericResponse<UserDTO> newUser(@RequestBody UserDTO userDTO){
        UserEntity userEntity = userService.insert(userConverter.convertToEntity(userDTO));
        if (userEntity != null)
        {
            return new GenericResponse<>(0, userDTO);
        }
        else return new GenericResponse<>(1, null);
    }



}
