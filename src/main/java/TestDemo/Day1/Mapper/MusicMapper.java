package TestDemo.Day1.Mapper;

import TestDemo.Day1.Json.CreateInputUserJson;
import TestDemo.Day1.Json.GetOutputUserJson;
import TestDemo.Day1.dtos.CreateInputAdapterDto;
import TestDemo.Day1.dtos.CreateInputUserDto;
import TestDemo.Day1.dtos.CreateOutputUserDto;
import TestDemo.Day1.dtos.GetAdapterOutputDtos;
import TestDemo.Day1.entity.UserTblEntity;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;


//@Mapper
public interface MusicMapper {
//
//    MusicMapper INSTANCE = Mappers.getMapper(MusicMapper.class);

    //Post_User_Details
     CreateInputUserDto InputJsonToInputDto(CreateInputUserJson createInputUserJson);
     CreateInputAdapterDto InputDtoToInputAdapterDto(CreateInputUserDto createInputUserDto);
     UserTblEntity InputAdapterToUserEntity(CreateInputAdapterDto createInputAdapterDto);
     CreateOutputUserDto UserEntityToOutputDto(UserTblEntity userTblEntity);

     //Get_User_Details_All
    GetAdapterOutputDtos entityToAdapterOutputDto(UserTblEntity userTblEntity);
    GetOutputUserJson adapterDtoToOutputJson (GetAdapterOutputDtos getAdapterOutputDtos);

}
