package uk.ac.cardiff.ASE2022Y2TEAM07.api.json;

import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;

import java.util.List;
import java.util.stream.Collectors;

public class OneToOneJsonAssembler {

  public static OneToOneJson toOneToOneJson(OneToOneDto oneToOneDto) {
      return OneToOneJson
              .of()
              .oneToOneId(oneToOneDto.getOneToOneId())
              .employeeId(oneToOneDto.getEmployeeId())
              .supervisorId(oneToOneDto.getSupervisorId())
              .date(oneToOneDto.getDate())
              .build();
  }

  public static List<OneToOneJson> toOneToOneJsonList(List<OneToOneDto> oneToOneDtoList) {
      return oneToOneDtoList
              .stream()
              .map(oto -> OneToOneJsonAssembler.toOneToOneJson(oto))
              .collect(Collectors.toList());
  }

}
