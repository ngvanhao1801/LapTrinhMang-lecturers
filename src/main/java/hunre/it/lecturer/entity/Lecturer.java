package hunre.it.lecturer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lecturer {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int id;

  private String maGv;

  private String hoTen;

  private String tenBoMon;

  private int heSoLuong;

  private String tinhTrang;

}
