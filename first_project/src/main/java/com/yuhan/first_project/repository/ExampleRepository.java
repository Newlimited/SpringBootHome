package com.yuhan.first_project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yuhan.first_project.entity.ExampleEntity;

@Repository
public interface ExampleRepository extends JpaRepository<ExampleEntity, Integer> {
    public ExampleEntity findByPk(int pk);
    public List<ExampleEntity> 
    findByExampleColumn3AndExampleColumn2(boolean exampleColumn3,String exampleColumn2);

    public boolean existsByExampleColumn3(boolean exampleColumn3);
    // 해당 레코드가 존재하는지 않하는지 반환
    @Transactional
    public void deleteByExampleColumn2(String exampleColumn2);

   

    

}
