package TestDemo.Day1.adapter;

import TestDemo.Day1.Mapper.MusicMapper;
import TestDemo.Day1.dtos.*;
import TestDemo.Day1.entity.UserTblEntity;
import TestDemo.Day1.repository.UserDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MusicAdapter {

    private final UserDetailRepository userDetailRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CreateOutputUserDto  musicadapter(CreateInputAdapterDto createInputAdapterDto){

        return Optional.of(createInputAdapterDto)
                .map(data -> modelMapper.map(data,UserTblEntity.class))
                .map(data ->UserTblEntity.builder().userId(UUID.randomUUID())
                        .username(data.getUsername())
                        .email(data.getEmail())
                        .status("A")
                        .phone(data.getPhone()).build())
                .map(userDetailRepository::save)
                .map(data -> modelMapper.map(data,CreateOutputUserDto.class))
                .orElseThrow(() -> new IllegalArgumentException("User Adapter creation failed"));
    }

    public List<GetAdapterOutputDtos>  getAllAdpaterMusicn(GetInputDtos getInputDtos){

        return Optional.of(getInputDtos)
                .map(data -> userDetailRepository.getAllData(data.getStatus()))
                .map(userEntities -> userEntities.stream()
                .map(data -> modelMapper.map(data,GetAdapterOutputDtos.class))
                .toList())
                .orElse(List.of());

    }

}
