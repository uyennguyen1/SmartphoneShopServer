package com.smartphoneshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "products")
public class Product implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`title`",length = 255,nullable = false)
    private String title;

    @Column(name = "`descriptions`",length = 1000,nullable = false)
    private String descriptions;

    @Column(name = "original_Price",nullable = false)
    private int originalPrice;

    @Column(name = "promotion_Price",nullable = false)
    private int promotionPrice;

    @Column(name = "`created_Date`")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "amount",nullable = false)
    private short amount;

    @Column(name = "`status`")
    private short status = 1;

    public Product(String title, String descriptions, int originalPrice, int promotionPrice, short amount) {
        this.title = title;
        this.descriptions = descriptions;
        this.originalPrice = originalPrice;
        this.promotionPrice = promotionPrice;
        this.amount = amount;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cate_Id",nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product")
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<ProductRates> productRatesList;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<CartItem> cartItemList;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<OrderItem> orderItems;


}
