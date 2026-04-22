package com.leisure.note.java_base.tools;

import com.sensorsdata.framework.common.date.DateTimeUtils;

import lombok.SneakyThrows;

/**
 * @author jie.he
 * @version 1.0.0
 * @since 2026/04/21 18:33
 */
public class DatetimeTool {

  @SneakyThrows
  public static void main(String[] args) {
    String str = "2026-04-20";
    System.out.println(DateTimeUtils.dateStringToDayId(str));
  }

}
