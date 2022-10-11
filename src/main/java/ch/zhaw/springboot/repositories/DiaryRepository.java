package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Diary;

public interface DiaryRepository extends JpaRepository<Diary, Long> {

}
