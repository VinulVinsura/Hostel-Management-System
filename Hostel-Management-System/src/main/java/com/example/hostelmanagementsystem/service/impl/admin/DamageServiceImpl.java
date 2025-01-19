package com.example.hostelmanagementsystem.service.impl.admin;

import com.example.hostelmanagementsystem.dto.DamageCaseDto;
import com.example.hostelmanagementsystem.dto.DamageMasterDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseDamageCase;
import com.example.hostelmanagementsystem.dto.Response.ResponseDamageMaster;
import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.entity.DamageCase;
import com.example.hostelmanagementsystem.entity.DamageMaster;
import com.example.hostelmanagementsystem.repository.DamageCaseRepo;
import com.example.hostelmanagementsystem.repository.DamageMasterRepo;
import com.example.hostelmanagementsystem.service.DamageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DamageServiceImpl implements DamageService {
    private final DamageMasterRepo damageMasterRepo;
    private final DamageCaseRepo damageCaseRepo;
    private final ModelMapper modelMapper;
    @Override
    public ResponseDto addDamageMaster(DamageMasterDto damageMasterDto) {
        try {
            DamageMaster damageMaster = damageMasterRepo.save(modelMapper.map(damageMasterDto, DamageMaster.class));
            return new ResponseDto(0,damageMaster);
        }catch (Exception ex){
            return new ResponseDto(2,ex.getMessage());
        }
    }

    @Override
    public ResponseDto addDamageCase(DamageCaseDto damageCaseDto) {
        try {
            DamageCase damageCase = damageCaseRepo.save(modelMapper.map(damageCaseDto, DamageCase.class));
            return new ResponseDto(0,damageCase);

        }catch (Exception ex){
            return new ResponseDto(2,ex.getMessage());
        }
    }

    @Override
    public ResponseDto getAllDamageMaster() {

        try {
            List<DamageMaster> damageMasterList = damageMasterRepo.findAll();
            List<ResponseDamageMaster> responseDamageMasters=modelMapper.map(damageMasterList,
                    new TypeToken<List<ResponseDamageMaster>>(){}.getType());
            return new ResponseDto(0,responseDamageMasters);
        }catch (Exception ex){
            return new ResponseDto(2,ex.getMessage());
        }
    }

    @Override
    public ResponseDto getAllDamageCase() {

        try {
            List<DamageCase> damageCaseList = damageCaseRepo.findAll();
            List<ResponseDamageCase> responseDamageCaseList=modelMapper.map(damageCaseList,
                    new TypeToken<List<ResponseDamageCase>>(){}.getType());
            return new ResponseDto(0,responseDamageCaseList);


        }catch (Exception ex){
            return new ResponseDto(2,ex.getMessage());
        }
    }
}
