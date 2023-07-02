package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class NhanVien {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    @NotBlank(message = "Không được để trống mã!")
    private String ma;

    @Column(name = "Ho")
    @NotBlank(message = "Không được để trống họ!")
    private String ho;

    @Column(name = "TenDem")
    @NotBlank(message = "Không được để trống tên đệm!")
    private String tenDen;

    @Column(name = "Ten")
    @NotBlank(message = "Không được để trống tên!")
    private String ten;

    @Column(name = "GioiTinh")
    @NotBlank(message = "Giới tính chưa chọn!")
    private String gioiTinh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCV")
    private ChucVu id_chucVu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCH")
    private CuaHang id_cuaHang;

    @Column(name = "NgaySinh")
    @NotNull(message = "Ngày sinh chưa xác định!")
    private Date namSinh;

    public int getAge(){
        return new java.util.Date().getYear() - namSinh.getYear();
    }

    public String getFullName(){
        return this.ho + " " + this.tenDen + " " + this.ten;
    }

}
