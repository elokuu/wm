package io.spring.mapper;

import io.spring.bean.BriefGoods;
import io.spring.bean.Goods;
import io.spring.bean.SecGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsMapper {
    List<BriefGoods> getHomepageGoodsInfo();
    List<SecGoods> getGoodsByType(String type);
    List<SecGoods> getSpecGoods();
    void updateState(Map map);
    List<Goods> getAllByState(Integer state);
}
