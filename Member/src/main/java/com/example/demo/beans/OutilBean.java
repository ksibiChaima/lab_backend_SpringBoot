package com.example.demo.beans;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OutilBean {
  private Long id;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate date;

  private String source;

  @JsonProperty("sourceUrl")
  @JsonAlias({ "source_url", "url", "lien" })
  private String sourceUrl;
}