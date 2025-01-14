package org.example.project.entity.general;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.project.entity.other.User;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String city;
    private String street;
    private String flat;
    private String streetNumber;
    private String postalCode;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> users=new HashSet<>();

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", flat='" + flat + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
//    public Address(String city){
//        this.city = city;
//    }
}
