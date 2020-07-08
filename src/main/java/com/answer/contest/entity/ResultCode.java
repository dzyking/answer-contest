package com.answer.contest.entity;

/**
 * 响应码枚举，参考HTTP状态码的语义
 *
 * Created by jiangp on 2019/3/11 0011
 */
public enum ResultCode {
  /**
   * 成功
   */
  SUCCESS(0,"操作成功"),
  /**
   * 系统错误
   */
  SYSTEM_ERROR(10001,"系统错误"),
  /**
   * 对象已存在
   */
  OBJECT_ALREADY_EXISTS(10002,"对象已存在"),
  /**
   * 参数错误
   */
  PARAMS_ERROR(10003,"参数错误"),
  /**
   * 参数长度错误
   */
  PARAMS_LENGTH_ERROR(10004,"参数长度错误"),
  /**
   * 对象不存在
   */
  OBJECT_NOT_EXISTS(10005,"对象不存在"),
  /**
   * 操作数据时，部分成功，部分失败
   */
  PART_FAIL(10006, "部分操作失败"),
  /**
   * 没有数据权限
   */
  NOT_DATA_AUTHORIZED(10007, "没有数据权限"),
  /**
   * 添加数据达到上限
   */
  UPPER_LIMIT(10008, "数据达到上限"),
  /**
   * 文件大小超过限制
   */
  FILE_SIZE_LIMIT(1009, "文件大小超过限制"),
  /**
   * 文件格式错误
   */
  FILE_FORMAT_ERROR(1010, "文件格式错误");
  public Integer code;
  public String message;

  ResultCode(Integer code, String message) {
    this.code = code;
    this.message = message;
  }
}