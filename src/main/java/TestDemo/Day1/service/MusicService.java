package TestDemo.Day1.service;

import TestDemo.Day1.Common.CommonResponse;
import TestDemo.Day1.Json.GetOutputUserJson;
import TestDemo.Day1.Mapper.MusicMapper;
import TestDemo.Day1.adapter.MusicAdapter;
import TestDemo.Day1.dtos.CreateInputAdapterDto;
import TestDemo.Day1.dtos.CreateInputUserDto;
import TestDemo.Day1.dtos.GetInputDtos;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicAdapter musicAdapter;

    @Autowired
    private ModelMapper modelMapper;

    public CommonResponse musicservice (CreateInputUserDto createInputUserDto){

        return Optional.of(createInputUserDto)
                .map(data -> modelMapper.map(data, CreateInputAdapterDto.class))
                .map(data -> musicAdapter.musicadapter(data))
                .map(response -> CommonResponse.builder().messageId(0).message("User Succesfully Register").data(response).status(HttpStatusCode.valueOf(201)).build())
                .orElseThrow(() -> new IllegalArgumentException("User Service registration failed"));
    }

    public CommonResponse getMusicServiceAll(GetInputDtos getInputDtos){

        return Optional.of(getInputDtos)
                .map(data -> musicAdapter.getAllAdpaterMusicn(data))
                .map(dataList -> dataList.stream()
                        .map(data -> modelMapper.map(data,GetOutputUserJson.class))
                        .collect(Collectors.toList()))
                .map(userJsonList -> CommonResponse.<List<GetOutputUserJson>>builder()
                        .messageId(0)
                        .message("Data Is Successfully Fetched")
                        .data(userJsonList)
                        .status(HttpStatus.OK)
                        .build())
                .orElseThrow(() -> new IllegalArgumentException("User Service registration failed to Fetch"));

    }


}
