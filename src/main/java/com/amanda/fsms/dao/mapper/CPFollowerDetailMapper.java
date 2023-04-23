package com.amanda.fsms.dao.mapper;

import com.amanda.fsms.data.CPFollowerDetailDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author jingji
 * @Date: 2023/4/23 14:58
 */
@Repository
@Mapper
public interface CPFollowerDetailMapper {
    @Insert("INSERT INTO CPFollowerDetail (problemId, CP, No, area, riskLevel, follower, " +
            "timestamp) VALUES (#{cpFollowerDetailDTO.problemId}, #{cpFollowerDetailDTO.CP}, " +
            "#{cpFollowerDetailDTO.No}, #{cpFollowerDetailDTO.area}, #{cpFollowerDetailDTO" +
            ".riskLevel}, #{cpFollowerDetailDTO.follower}, #{cpFollowerDetailDTO.timestamp})")
    int insertProblemDetail(@Param("cpFollowerDetailDTO")CPFollowerDetailDTO cpFollowerDetailDTO);

}
