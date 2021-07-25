package com.app.backend;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private Gender gender;
    private Address address;
    private List<String> favouriteFoods;
    private BigDecimal totalSpentInFood;
    private LocalDateTime created;

    public Student(String firstName, String lastName, String email, Gender gender, Address address,
                   List<String> favouriteFoods, BigDecimal totalSpentInFood, LocalDateTime created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favouriteFoods = favouriteFoods;
        this.totalSpentInFood = totalSpentInFood;
        this.created = created;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getFavouriteFoods() {
        return favouriteFoods;
    }

    public void setFavouriteFoods(List<String> favouriteFoods) {
        this.favouriteFoods = favouriteFoods;
    }

    public BigDecimal getTotalSpentInFood() {
        return totalSpentInFood;
    }

    public void setTotalSpentInFood(BigDecimal totalSpentInFood) {
        this.totalSpentInFood = totalSpentInFood;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Boolean emailCheck() {
        if (this.email.contains("@")) {
            return true;
        } else {
            return false;
        }
    }
}
