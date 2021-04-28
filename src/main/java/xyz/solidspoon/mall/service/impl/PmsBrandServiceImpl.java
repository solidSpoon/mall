package xyz.solidspoon.mall.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.solidspoon.mall.mbg.mapper.PmsBrandMapper;
import xyz.solidspoon.mall.mbg.model.PmsBrand;
import xyz.solidspoon.mall.mbg.model.PmsBrandExample;
import xyz.solidspoon.mall.service.PmsBrandService;

import java.util.List;

/**
 * PmsBrandService 实现类
 * @author solidSpoon
 * @date 2021/4/26 20:16
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
