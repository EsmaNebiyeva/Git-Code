package org.example.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String receiptNo;
    private String imageUrl;
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    private Long stock;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private Long tax;
    private Long discount;


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", receiptNo='" + receiptNo + '\'' +
                ", price=" + price +
//                ", stock=" + stock +
//                ",imageUrl='" +imageUrl + '\'' +
//                ", user=" + user +
                ", tax=" + tax +
                ", discount=" + discount +
                '}';
    }

    public Product( String name) {
        this.name = name;
    }
}
