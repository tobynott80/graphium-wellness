package uk.ac.cardiff.ASE2022Y2TEAM07.api.json;

import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;

import java.util.List;
import java.util.stream.Collectors;

public class OneToOneJsonAssembler {

  public static OneToOneJson toOneToOneJson(OneToOneDto onetooneDto) {
      return OneToOneJson
              .of()
              .One_To_One_ID(onetooneDto.getOne_To_One_ID())
              .Employee_ID(onetooneDto.getEmployee_ID())
              .Supervisor_ID(onetooneDto.getSupervisor_ID())
              .Date(onetooneDto.getDate())
              .build();
  }

  public static List<OneToOneJson> toOneToOneJsonList(List<OneToOneDto> onetooneDtoList) {
      return onetooneDtoList
              .stream()
              .map(c -> OneToOneJsonAssembler.toOneToOneJson(c))
              .collect(Collectors.toList());
  }

}
