package com.hisistant.auth.repository;

import com.hisistant.auth.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query("SELECT m FROM Menu m WHERE m.user_id = :user_id AND m.menu_type = :category_id")
    List<Menu> findByUserIdAndCategoryId(Long user_id, Long category_id);
}
