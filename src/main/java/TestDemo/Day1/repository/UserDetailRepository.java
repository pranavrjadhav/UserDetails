package TestDemo.Day1.repository;

import TestDemo.Day1.dtos.GetAdapterOutputDtos;
import TestDemo.Day1.entity.UserTblEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailRepository extends JpaRepository<UserTblEntity,Integer> {

    @Query("SELECT u FROM UserTblEntity  u WHERE  u.status = :statusA")
    List<UserTblEntity> getAllData(@Param("statusA") String statusA);

}
