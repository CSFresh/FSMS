package com.amanda.fsms.dao.mapper;

import com.amanda.fsms.data.AuditDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author jingji
 * @Date: 2023/4/28 19:09
 */
@Repository
@Mapper
public interface AuditMapper {
    @Insert("INSERT INTO audit (auditId, auditName, dataKey, userId) VALUES (#{auditDTO.auditId}," +
            " #{auditDTO.auditName}, " +
            "#{auditDTO.dataKey}, #{auditDTO.userId})")
    int insert(AuditDTO auditDTO);
}
