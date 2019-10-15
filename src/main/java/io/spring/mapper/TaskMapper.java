package io.spring.mapper;

import io.spring.bean.BriefTask;
import io.spring.bean.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TaskMapper {
    List<BriefTask> getHomepageTaskInfo();
    void publishTask(Task task);
    void updateState(Map map);
    List<Task> getAllByState(Integer state);
}
