package com.hisistant.auth.service;

import com.hisistant.auth.domain.DailySales;
import com.hisistant.auth.dto.DailySalesDTO;
import com.hisistant.auth.repository.DailySalesRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesService {
    private final DailySalesRepository dailySalesRepository;
    private final ModelMapper modelMapper;

    public List<DailySalesDTO> getDailySales(Long user_id) {
        List<DailySales> dailySales = dailySalesRepository.findByUserId(user_id);
        List<DailySalesDTO> dailySalesDTOList = new ArrayList<>();
        for (DailySales dailySale : dailySales) {
            dailySalesDTOList.add(modelMapper.map(dailySale, DailySalesDTO.class));
        }
        return dailySalesDTOList;
    }
}
