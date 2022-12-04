package uk.ac.cardiff.ASE2022Y2TEAM07.api.json;

import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;

import java.util.List;
import java.util.stream.Collectors;

public class OneToOneJsonAssembler {

  public static OneToOneJson toOneToOneJson(OneToOneDto oneToOneDto) {
      return OneToOneJson
              .of()
              .One_To_One_ID(oneToOneDto.getOne_To_One_ID())
              .Employee_ID(oneToOneDto.getEmployee_ID())
              .Supervisor_ID(oneToOneDto.getSupervisor_ID())
              .Date(oneToOneDto.getDate())
              .build();
  }

  public static List<OneToOneJson> toOneToOneJsonList(List<OneToOneDto> oneToOneDtoList) {
      return oneToOneDtoList
              .stream()
              .map(oto -> OneToOneJsonAssembler.toOneToOneJson(oto))
              .collect(Collectors.toList());
  }

}
