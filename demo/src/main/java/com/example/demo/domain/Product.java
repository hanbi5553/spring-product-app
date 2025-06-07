package com.example.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*; // ← 이거 꼭 필요!
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "상품 이름은 필수입니다.")
    private String name;

    @NotBlank(message = "브랜드는 필수입니다.")
    private String brand;

    @NotBlank(message = "제조국은 필수입니다.")
    private String madeIn;
    
    @Min(value = 1, message = "가격은 1 이상이어야 합니다.")
    private Integer price;

}
