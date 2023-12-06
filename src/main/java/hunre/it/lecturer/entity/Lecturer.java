package hunre.it.lecturer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
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
  private int maGv;

  @NotNull
  private String hoTen;

  @NotNull
  private String tenBoMon;

  @NotNull
  private int heSoLuong;

}
