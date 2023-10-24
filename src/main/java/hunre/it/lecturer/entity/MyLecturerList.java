package hunre.it.lecturer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="MyEmployees")
public class MyLecturerList {

  @Id
  private int id;

  private String maGv;

  private String hoTen;

  private String tenBoMon;

  private int heSoLuong;

}
