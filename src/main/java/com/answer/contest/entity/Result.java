package com.answer.contest.entity;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

/**
 * 统一API响应结果封装
 *
 * Created by jiangp on 2019/3/11 0011
 */
public class Result<T> {
  private int resultCode;
  private String message;
  private T data;

  public int getResultCode() {
    return resultCode;
  }

  public void setResultCode(int resultCode) {
    this.resultCode = resultCode;
  }


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public String toString() {
    return JSON.toJSONString(this);
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Result genSuccessResult() {
    this.setResultCode(ResultCode.SUCCESS.code);
    this.setMessage(ResultCode.SUCCESS.message);
    return this;
  }

  public Result genSuccessResult(String message) {
    this.setResultCode(ResultCode.SUCCESS.code);
    this.setMessage(message);
    return this;
  }

  public Result<T> genSuccessResult(T data){
    this.setResultCode(ResultCode.SUCCESS.code);
    this.setMessage(ResultCode.SUCCESS.message);
    this.setData(data);
    return this;
  }

  public Result<T> genFailResult(ResultCode resultCode, String message) {
    this.setResultCode(resultCode.code);
    if (StringUtils.isEmpty(message)){
      this.setMessage(resultCode.message);
    }else {
      this.setMessage(message);
    }
    return this;
  }

  public Result<T> saveSuccessResult(T data){
    this.setResultCode(ResultCode.SUCCESS.code);
    this.setMessage("添加成功");
    this.setData(data);
    return this;
  }

  public Result<T> saveFailResult(String reason){
    this.setResultCode(ResultCode.SYSTEM_ERROR.code);
    String message = "添加失败";
    if(!StringUtils.isEmpty(reason)){
      message += "，"+reason;
    }
    this.setMessage(message);
    return this;
  }
  public Result<T> addFailResult(String reason){
    this.setResultCode(ResultCode.SYSTEM_ERROR.code);
    String message = "保存失败";
    if(!StringUtils.isEmpty(reason)){
      message += "，"+reason;
    }
    this.setMessage(message);
    return this;
  }

  public Result<T> updateSuccessResult(T data){
    this.setResultCode(ResultCode.SUCCESS.code);
    this.setMessage("修改成功");
    this.setData(data);
    return this;
  }

  public Result<T> updateFailResult(String reason){
    this.setResultCode(ResultCode.SYSTEM_ERROR.code);
    String message = "修改失败";
    if(!StringUtils.isEmpty(reason)){
      message += "，"+reason;
    }
    this.setMessage(message);
    return this;
  }


  public Result<T> deleteSuccessResult(T data){
    this.setResultCode(ResultCode.SUCCESS.code);
    this.setMessage("删除成功");
    this.setData(data);
    return this;
  }

  public Result<T> deleteFailResult(String reason){
    this.setResultCode(ResultCode.SYSTEM_ERROR.code);
    String message = "删除失败";
    if(!StringUtils.isEmpty(reason)){
      message += "，"+reason;
    }
    this.setMessage(message);
    return this;
  }


}
