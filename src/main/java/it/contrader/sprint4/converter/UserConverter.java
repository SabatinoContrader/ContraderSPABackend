package it.contrader.sprint4.converter;

import it.contrader.sprint4.dto.UserDTO;
import it.contrader.sprint4.model.UserEntity;
import org.springframework.stereotype.Component;


@Component
public class UserConverter implements Converter<UserEntity, UserDTO>{


    @Override
    public UserEntity convertToEntity(UserDTO userDTO) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setFirstname(userDTO.getFirstname());
        userEntity.setLastname(userDTO.getLastname());
        userEntity.setDateofbirth(userDTO.getDateofbirth());
        userEntity.setFiscalcode(userDTO.getFiscalcode());
        userEntity.setBusinessname(userDTO.getBusinessname());
        userEntity.setVat(userDTO.getVat());
        userEntity.setMunicipality(userDTO.getMunicipality());
        userEntity.setPost(userDTO.getPost());
        userEntity.setCity(userDTO.getCity());
        userEntity.setAddress(userDTO.getAddress());
        userEntity.setTelephone(userDTO.getTelephone());
        userEntity.setRole("user");
        return userEntity;
    }


    @Override
    public UserDTO convertToDTO(UserEntity userEntity) {
        return new UserDTO(userEntity.getUsername(), userEntity.getPassword(),userEntity.getFirstname(),
                userEntity.getLastname(),userEntity.getDateofbirth(), userEntity.getFiscalcode(),
                userEntity.getBusinessname(), userEntity.getVat(), userEntity.getMunicipality(),
                userEntity.getPost(), userEntity.getCity(), userEntity.getAddress(),userEntity.getTelephone(),
                userEntity.getRole());
    }
}
