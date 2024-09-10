package com.hisistant.auth.service;

import com.hisistant.auth.domain.Menu;
import com.hisistant.auth.domain.MenuCategory;
import com.hisistant.auth.domain.User;
import com.hisistant.auth.dto.CategoryDTO;
import com.hisistant.auth.dto.MenuDTO;
import com.hisistant.auth.repository.MenuCategoryRepository;
import com.hisistant.auth.repository.MenuRepository;
import com.hisistant.auth.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final MenuCategoryRepository menuCategoryRepository;
    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    public List<CategoryDTO> getCategories(Long user_id){
        List<MenuCategory> categories = menuCategoryRepository.findByUserId(user_id);
        List<CategoryDTO> categoriesDTO = new ArrayList<>();
        for(MenuCategory category : categories){
            categoriesDTO.add(CategoryDTO.builder()
                    .id(category.id)
                    .name(category.name)
                    .build());
        }
        return categoriesDTO;
    }

    public List<MenuDTO> getCategoryMenu(Long user_id, Long category_id) {
        List<Menu> menus = menuRepository.findByUserIdAndCategoryId(user_id, category_id);
        List<MenuDTO> menuDTOList = new ArrayList<>();
        for(Menu menu : menus){
            menuDTOList.add(modelMapper.map(menu, MenuDTO.class));
        }
        return menuDTOList;
    }
}
