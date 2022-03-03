package com.ibm.academy.cinema.apirest.userservice.mapper;

import com.ibm.academy.cinema.apirest.userservice.dto.AdminDto;
import com.ibm.academy.cinema.apirest.userservice.dto.CinemaDto;
import com.ibm.academy.cinema.apirest.userservice.dto.SubscriberDto;
import com.ibm.academy.cinema.apirest.userservice.dto.UserDto;
import com.ibm.academy.cinema.apirest.userservice.entity.Admin;
import com.ibm.academy.cinema.apirest.userservice.entity.Cinema;
import com.ibm.academy.cinema.apirest.userservice.entity.Subscriber;
import com.ibm.academy.cinema.apirest.userservice.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    default UserDto toDto(User user) {
        if (user instanceof Subscriber)
            return toDto((Subscriber) user);
        if (user instanceof Cinema)
            return toDto((Cinema) user);
        if (user instanceof Admin)
            return toDto((Admin) user);
        else
            return null;
    }

    default User toEntity(UserDto userDto) {
        if (userDto instanceof SubscriberDto)
            return toEntity((SubscriberDto) userDto);
        if (userDto instanceof CinemaDto)
            return toEntity((CinemaDto) userDto);
        if (userDto instanceof AdminDto)
            return toEntity((AdminDto) userDto);
        else
            return null;
    }

    SubscriberDto toDto(Subscriber subscriber);
    Subscriber toEntity(SubscriberDto subscriberDto);

    CinemaDto toDto(Cinema subscriber);
    Cinema toEntity(CinemaDto subscriberDto);

    AdminDto toDto(Admin subscriber);
    Admin toEntity(AdminDto subscriberDto);
}
