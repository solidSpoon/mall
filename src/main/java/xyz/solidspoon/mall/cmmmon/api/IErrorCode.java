package xyz.solidspoon.mall.cmmmon.api;

/**
 * 封装 API 的错误码
 * @author solidSpoon
 * @date 2021/4/26 19:31
 */
public interface IErrorCode {
    /**
     * 返回状态码
     * @return
     */
    long getCode();

    /**
     * 返回状态说明
     * @return
     */
    String getMessage();
}
