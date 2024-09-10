package com.hisistant.auth.service;

import com.hisistant.auth.domain.DailySales;
import com.hisistant.auth.domain.MonthlySales;
import com.hisistant.auth.domain.TimeSales;
import com.hisistant.auth.dto.DailySalesDTO;
import com.hisistant.auth.dto.MonthlySalesDTO;
import com.hisistant.auth.dto.TimeSalesDTO;
import com.hisistant.auth.repository.DailySalesRepository;
import com.hisistant.auth.repository.MonthlySalesRepository;
import com.hisistant.auth.repository.TimeSalesRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesService {
    private final DailySalesRepository dailySalesRepository;
    private final TimeSalesRepository timeSalesRepository;
    private final MonthlySalesRepository monthlySalesRepository;
    private final ModelMapper modelMapper;

    public List<DailySalesDTO> getDailySales(Long user_id) {
        List<DailySales> dailySales = dailySalesRepository.findByUserId(user_id);
        List<DailySalesDTO> dailySalesDTOList = new ArrayList<>();
        for (DailySales dailySale : dailySales) {
            dailySalesDTOList.add(modelMapper.map(dailySale, DailySalesDTO.class));
        }
        return dailySalesDTOList;
    }

    public TimeSalesDTO getTimeSales(Long user_id) {
        TimeSales timeSales = timeSalesRepository.findFirstByUserIdOrderByDateDesc(user_id);
        TimeSalesDTO timeSalesDTO = modelMapper.map(timeSales, TimeSalesDTO.class);
        return timeSalesDTO;
    }

    public MonthlySalesDTO getMontlySales(Long user_id) {
        MonthlySales monthlySales = monthlySalesRepository.findFirstByUserIdOrderByMonthDesc(user_id);
        MonthlySalesDTO monthlySalesDTO = modelMapper.map(monthlySales, MonthlySalesDTO.class);
        return monthlySalesDTO;
    }
}
