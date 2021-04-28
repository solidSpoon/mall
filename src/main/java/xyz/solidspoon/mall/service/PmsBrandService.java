package xyz.solidspoon.mall.service;

import xyz.solidspoon.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * PmsBrandService
 * @author solidSpoon
 * @date 2021/4/26 19:14
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
