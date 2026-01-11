package com.example.demo.beans;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventBean {
  private Long id;
  private String titre;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate date;

  private String lieu;
}