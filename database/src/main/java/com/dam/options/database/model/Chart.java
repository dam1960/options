/*
 * Copyright (c) 2017. David A. Miranda
 */

package com.dam.options.database.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Calendar;

public class Chart {

  private String symbol;

  @JsonProperty("date")
  private String datee;

  @JsonProperty("open")
  private double openn;

  private double high;
  private double low;

  @JsonProperty("close")
  private double cloze;

  private long volume;
  private long unadjustedVolume;

  @JsonProperty("change")
  private double changee;

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


  public String getDatee() {
    return datee;
  }

  public void setDatee(String datee) {
    this.datee = datee;
  }

  public double getOpenn() {
    return openn;
  }

  public void setOpenn(double openn) {
    this.openn = openn;
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


  public double getChangee() {
    return changee;
  }

  public void setChangee(double changee) {
    this.changee = changee;
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
