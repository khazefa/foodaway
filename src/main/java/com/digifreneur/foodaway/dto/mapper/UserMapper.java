package com.digifreneur.foodaway.dto.mapper;

import java.util.HashSet;

import com.digifreneur.foodaway.dto.model.user.RoleDto;
import com.digifreneur.foodaway.dto.model.user.UserDto;
import com.digifreneur.foodaway.model.user.Users;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    
    public static UserDto toUserDto(Users user) {
        return new UserDto().builder()
                .email(user.getEmail())
                .firstName(user.getFirstname())
                .lastName(user.getLastname())
                .mobileNumber(user.getPhone())
                .roles(new HashSet<RoleDto>(user))
    }

}