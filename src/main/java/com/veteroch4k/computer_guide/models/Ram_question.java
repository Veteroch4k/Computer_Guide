package com.veteroch4k.computer_guide.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.json.simple.JSONObject;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ram_questions", schema = "computer_guide")
public class Ram_question {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int id;

  @Column(name = "question")
  private String question;

  @Column(name = "type")
  private String type;

  @Column(name = "answer")
  private String answer;

  @Column(name = "variants")
  @JdbcTypeCode(SqlTypes.JSON)
  private JSONObject  variants;

  @Column(name = "description")
  private String description;

}
