package uk.ac.cardiff.ASE2022Y2TEAM07.service;


import org.springframework.stereotype.Service;
import uk.ac.cardiff.ASE2022Y2TEAM07.assembler.OneToOneAssembler;
import uk.ac.cardiff.ASE2022Y2TEAM07.domain.OneToOne;
import uk.ac.cardiff.ASE2022Y2TEAM07.dto.OneToOneDto;
import uk.ac.cardiff.ASE2022Y2TEAM07.repositories.OneToOneRepository;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.OneToOneListRequest;
import uk.ac.cardiff.ASE2022Y2TEAM07.service.message.OneToOneListResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OneToOneServiceImpl implements OneToOneService {
    //TODO: Implement this service

    @Override
    public List<OneToOneDto> findAll() {
        return null;
    }



    //working on this

    private final OneToOneRepository oneToOneRepository;

    public OneToOneServiceImpl(OneToOneRepository otoRepo) {
        this.oneToOneRepository = otoRepo;
    }

    public OneToOneListResponse getOneToOnes(OneToOneListRequest oneToOneListRequest) {
        List<OneToOneDto> oneToOnes;
        if (oneToOneListRequest.hasSearchTerm()) {
            oneToOnes = getOneToOnesBySearch(OneToOneListRequest.getSearchTerm());
        } else {
            oneToOnes = getOneToOnes();
        }
        
        return OneToOneListResponse
                .of()
                .request(oneToOneListRequest)
                .onetoone(oneToOnes)
                .build();
    }

    private List<OneToOneDto> getOneToOnes() {
        List<OneToOne> oneToOnes = oneToOneRepository.getOneToOnes();

        return oneToOnes.stream().map(oto -> OneToOneAssembler.toDto(oto)).collect(Collectors.toList());
    }








//    private final JdbcTemplate jdbc;
//    private RowMapper<OneToOne> oneToOneMapper;
//
//    public OneToOneServiceImpl(JdbcTemplate jdbcTemplate) {
//        jdbc = jdbcTemplate;
//        setOneToOneMapper();
//    }
//
//    private void setOneToOneMapper() {
//        oneToOneMapper = (rs, i) -> new OneToOne(
//                rs.getInt("OneToOneID"),
//                rs.getInt("EmployeeID"),
//                rs.getInt("SupervisorID"),
//                rs.getString("Date")
//        );
//    }
//
//    public List<OneToOne> getOneToOnes() {
//
//        String allOneToOnesSQL = "select * from OneToOne";
//        return jdbc.query(allOneToOnesSQL, oneToOneMapper);
//
//    }


//    @Override
//    public OneToOneListResponse getOneToOnes(OneToOneListRequest onetooneRequest) {
//        return null;
//    }


//    public OneToOneListResponse getOneToOnes(OneToOneListRequest onetooneListRequest) {
//       List<OneToOneDto> onetoone;
//       if (onetooneListRequest.hasSearchTerm()) {
//           onetoone = getOneToOnes(onetooneListRequest.getSearchTerm());
//       } else {
//           onetoone = getOneToOnes();
//       }
//
//        return OneToOneListResponse
//                .of()
//                .request(onetooneListRequest)
//                .onetoone(onetoone)
//                .build();
//    }

//    private List<Object> getOneToOnes() {
//        List<OneToOne> onetoones = OneToOneRepository.getOneToOnes();
//        return onetoones.stream().map(c -> OneToOneAssembler.toDto(c)).collect(Collectors.toList());
//    }

}
