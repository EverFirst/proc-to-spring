package com.proc.claim.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.proc.claim.model.entity.CommonCode;
import java.util.List;

@Mapper
public interface CommonMapper {
    
    List<CommonCode> selectCommonCodeList(String groupCode);
    
    CommonCode selectCommonCode(String code);
    
    int insertCommonCode(CommonCode commonCode);
    
    int updateCommonCode(CommonCode commonCode);
    
    int deleteCommonCode(String code);
}