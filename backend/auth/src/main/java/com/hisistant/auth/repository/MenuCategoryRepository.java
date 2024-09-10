package com.hisistant.auth.repository;

import com.hisistant.auth.domain.MenuCategory;
import com.hisistant.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory,Long> {
    List<MenuCategory> findByUserId(Long user_id);
}
