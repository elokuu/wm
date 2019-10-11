package io.spring.mapper;

import io.spring.bean.BriefGoods;
import io.spring.bean.SecGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<BriefGoods> getHomepageGoodsInfo();
    List<SecGoods> getGoodsByType(String type);
    List<SecGoods> getSpecGoods();
}
