package io.spring.mapper;

import io.spring.bean.BriefTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskMapper {
    List<BriefTask> getHomepageTaskInfo();
}
