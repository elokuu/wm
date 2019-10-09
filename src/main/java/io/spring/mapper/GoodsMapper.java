package io.spring.mapper;

import io.spring.bean.BriefGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<BriefGoods> getHomepageGoodsInfo();
}
