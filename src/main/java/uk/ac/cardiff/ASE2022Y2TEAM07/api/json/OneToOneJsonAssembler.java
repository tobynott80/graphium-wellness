package uk.ac.cardiff.ASE2022Y2TEAM07.api.json;

import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;

import java.util.List;
import java.util.stream.Collectors;

public class OneToOneJsonAssembler {

  public static OneToOneJson toOneToOneJson(OneToOneDto oneToOneDto) {
      return OneToOneJson
              .of()
              .oneToOneID(oneToOneDto.getOneToOneID())
              .employeeID(oneToOneDto.getEmployeeID())
              .supervisorID(oneToOneDto.getSupervisorID())
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
