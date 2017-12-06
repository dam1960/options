/*
 * Copyright (c) 2017. David A. Miranda
 */

package com.dam.options.database.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Chart {

  private String symbol;
  private java.sql.Date date;
  private double high;
  private double low;

  @JsonProperty("close")
  private double cloze;

  private long volume;
  private long unadjustedVolume;
  private double change;
  private double changePercent;
  private double vwap;
  private String label;
  private BigDecimal changeOverTime;


  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }


  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }


  public double getHigh() {
    return high;
  }

  public void setHigh(double high) {
    this.high = high;
  }


  public double getLow() {
    return low;
  }

  public void setLow(double low) {
    this.low = low;
  }


  public double getCloze() {
    return cloze;
  }

  public void setCloze(double cloze) {
    this.cloze = cloze;
  }


  public long getVolume() {
    return volume;
  }

  public void setVolume(long volume) {
    this.volume = volume;
  }


  public long getUnadjustedVolume() {
    return unadjustedVolume;
  }

  public void setUnadjustedVolume(long unadjustedVolume) {
    this.unadjustedVolume = unadjustedVolume;
  }


  public double getChange() {
    return change;
  }

  public void setChange(double change) {
    this.change = change;
  }


  public double getChangePercent() {
    return changePercent;
  }

  public void setChangePercent(double changePercent) {
    this.changePercent = changePercent;
  }


  public double getVwap() {
    return vwap;
  }

  public void setVwap(double vwap) {
    this.vwap = vwap;
  }


  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }


  public BigDecimal getChangeOverTime() {
    return changeOverTime;
  }

  public void setChangeOverTime(BigDecimal changeOverTime) {
    this.changeOverTime = changeOverTime;
    ;
  }

}
