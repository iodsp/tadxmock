package org.iodsp.tadxmock.resource.exceptions;

import lombok.Getter;

@Getter
public enum BaseExceptionEnums implements ExceptionEnums {

    // 10010 - 10099
    ADD_EXCEPTION(10010, "添加失败"),
    UPDATE_EXCEPTION(10011, "更新失败"),
    NO_SUCH_EXCEPTION(10012, "不存在记录"),
    PARAM_EXCEPTION(10013, "参数错误"),

    // 100 - 199
    SYSTEM_EXCEPTION(100, "系统错误，请稍后再试"),
    AUTH_FAIL_EXCEPTION(101, "错误的 DSP ID 或 token;DSP ID,Token 验证失败"),
    PARAMS_EXCEPTION(102, "参数错误"),

    // 300 - 399
    REQUIRED_PARAMS_EXCEPTION(300, "必须的参数没有传入"),
    AT_LEAST_PARAMS_EXCEPTION(301, "至少必须传入此组参数中的一个"),
    MUST_INTEGER_PARAMS_EXCEPTION(302, "参数必须为整数"),
    FORMAT_PARAMS_EXCEPTION(303, "参数格式错误"),
    NO_RANGE_PARAMS_EXCEPTION(304, "参数不在允许的值的范围内"),
    NO_POSITIVE_INTEGER_EXCEPTION(305, "参数不是正数"),
    NO_VALID_URL_EXCEPTION(306, "参数不是合法的 URL"),
    PARAMS_TOO_LOOG_EXCEPTION(307, "参数太长，超出了允许的长度范围"),
    NO_VALID_DATE_EXCEPTION(308, "参数不是合法的 YYYY-MM-DD 的日期"),
    NO_VALID_JSON_EXCEPTION(309, "不是合法的 JSON 数据，无法被解析"),
    EMPTY_JSON_DATA_EXCEPTION(310, "可以被解析但是是空的 JSON 数据"),
    PARAMS_TOO_SHORT_EXCEPTION(311, "参数太短，小于允许的长度范围"),
    NO_REQUIRED_FORMAT_JSON_EXCEPTION(312, "可以被解析的 JSON 数据，但不是 API 要求的 JSON 格式"),
    NO_ZERO_OR_POSITIVE_EXCEPTION(313, "参数不是 0 或正数"),
    VALUE_TOO_LARGEST_EXCEPTION(314, "参数的值太大，超过了允许的最大值"),
    PARAMS_NO_ALLOW_MODIFY_EXCEPTION(315, "参数的值不允许被修改"),

    // 400 - 499
    CLIENT_NOT_EXISTS(400, "客户 ID 不存在/没有匹配的客户信息"),

    // 500 - 599
    CLIENT_NAME_REPEAT(500, "客户名称重复"),
    CLIENT_NAME_NO_ALLOW_MODIFY(503, "客户不能被修改"),
    CLIENT_INVALID_VOCATION(504, "客户行业不合法"),
    CLIENT_INVALID_URL(505, "客户 URL 为空或者是 URL 不合法"),
    CLIENT_EMPTY_VOCATION(506, "客户 vocation 为空或者是 vocation 不合法"),
    CLIENT_EMPTY_AREA(507, "客户 area 为空"),
    CLIENT_QUALIFICATION_CLASS_INVALID(508, "客户 qualification_class 不合法"),
    INNER_ERROR(509, "内部错误，更新 DB 的过程中发生了错误"),
    CLIENT_QUALIFICATION_FILES_INVALID(510, "客户 qualification_files 不合法"),
    CLIENT_FILE_NAME_INVALID(511, "客户 file_name 不合法"),
    CLIENT_FILE_URL_INVALID(512, "客户 file_url 不合法"),
    NO_SUPPORT_QUALIFICATION_FILE_TYPE(513, "不支持的客户资质文件的格式，目前支持的文件格式:jpg,jpeg,gif,png"),
    INNER_ERROR_FILE_MOVE_FAIL(514, "内部错误，文件移动失败，可能是文件过大"),
    CLIENT_NAME_EMPTY(515, "客户 name 为空"),
    CLIENT_MEMO_EMPTY(516, "客户 memo 为空"),

    // 600 - 699
    FILE_LOAD_FAIL(601, "文件加载失败"),
    UNKNOWN_FILE_TYPE(602, "未知的文件格式，文件的格式无法识别"),
    NO_SUPPORT_TYPE_FILE(603, "不支持的文件格式,目前支持的文件格式:jpg,gif,png,swf,flv"),
    FLV_NO_GET_TIME_LINE(604, "Flv 素材获取不到时长信息"),
    URL_MAPPING_CHANGE(605, "URL 对应的素材发生了变化，请换一个 URL"),
    INSERT_ERROR(606, "执行插入过程中发生了错误，请关注是否是同时上传"),
    FILE_TOO_LOOG(607, "文件过大"),
    URL_NO_EMPTY(609, "素材 URL 为空或者是地址不合法"),
    TARGET_URL_NO_EMPTY(610, "目标地址为空或者是地址不合法"),
    CLIENT_NAME_EMPTY_SIX(611, "客户名称为空"),
    MONITOR_CHECK_ADDRESS_ERROR(612, "第三方曝光监测地址错误"),
    MATERIAL_TOO_LARGER(613, "素材过大，超过素材的大小限制"),
    FILE_INFO_FORMAT_ERROR(614, "传入的 file_info 格式错误"),
    URL_MAPPING_CLIENT_CHANGE(615, "URL 对应的客户发生变化，不能上传"),
    MATERIAL_URL_INVALID(616, "同一次请求中，一个素材 URL 出现了多次"),

    // 800 - 899
    END_TIME_MORE_THAN_START_TIME(801, "传入的结束时间大于开始时间"),
    NO_LIMIT_RANGE_DATE(802, "超过开始和结束时间限制，目前只支持一次查询少于 7 天的数据，如果时间段 过长，请分开查询");

    private Integer code;

    private String message;

    BaseExceptionEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}


