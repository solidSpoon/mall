package xyz.solidspoon.mall.cmmmon.api;

import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 分页数据封装
 * @author solidSpoon
 * @date 2021/4/26 19:18
 */
@Getter
@Setter
public class CommonPage<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;

    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> result = new CommonPage<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }
}
