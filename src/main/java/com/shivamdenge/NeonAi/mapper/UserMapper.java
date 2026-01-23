package com.shivamdenge.NeonAi.mapper;

import com.shivamdenge.NeonAi.dto.auth.SignupRequestDTO;
import com.shivamdenge.NeonAi.dto.auth.UserProfileResponseDTO;
import com.shivamdenge.NeonAi.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    //DTO -> ENTITY
    User toUserEntity(SignupRequestDTO signupRequestDTO);

    //ENTITY -> DTO
    UserProfileResponseDTO toUserProfileResponseDTO(User user);
}
