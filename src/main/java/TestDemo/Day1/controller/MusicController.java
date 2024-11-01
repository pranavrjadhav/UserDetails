package TestDemo.Day1.controller;

import TestDemo.Day1.Common.CommonResponse;
import TestDemo.Day1.Json.CreateInputUserJson;
import TestDemo.Day1.Mapper.MusicMapper;
import TestDemo.Day1.dtos.CreateInputUserDto;
import TestDemo.Day1.dtos.GetInputDtos;
import TestDemo.Day1.service.MusicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/music/data")
public class MusicController {

    private final MusicService musicService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/add")
    public CommonResponse createdata(@RequestBody CreateInputUserJson createInputUserJson){

        return Optional.ofNullable(createInputUserJson)
                .map(data -> modelMapper.map(data, CreateInputUserDto.class))
                .map(data -> musicService.musicservice(data))
                .orElseThrow(() -> new IllegalArgumentException("User Controller creation failed "));
    }

    @GetMapping("/all")
    public CommonResponse getAllData(@RequestParam("X-status") String status){

        return Optional.of(GetInputDtos.builder().status(status).build())
                .map(dat -> musicService.getMusicServiceAll(dat))
                .orElseThrow(() -> new IllegalArgumentException("User Controller fetching data  failed "));



    }

}
