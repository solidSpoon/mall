package xyz.solidspoon.mall.service;

import xyz.solidspoon.mall.cmmmon.api.CommonResult;

/**
 * 会员管理 Service
 * @author solidSpoon
 * @date 2021/4/27 20:42
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     * @param telephone 电话号码
     * @return
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     * @param telephone
     * @param authCode
     * @return
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
