package ru.itmo.models;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cat")
@EqualsAndHashCode
public class Cat {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "birthdate")
    private LocalDate birthdate;
    @Column(name = "breed")
    private String breed;
    @Enumerated(EnumType.STRING)
    private Colors color;
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "cat_friend",
            joinColumns = @JoinColumn(name = "cat_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<Cat> friends = new ArrayList<>();

    public Cat(String name, LocalDate birthdate, String breed, Colors color, Owner owner) {
        this.name = name;
        this.birthdate = birthdate;
        this.breed = breed;
        this.color = color;
        this.owner = owner;
    }

    public void addFriend(Cat friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public void removeFriend(Cat friend) {
        friends.remove(friend);
        friend.getFriends().remove(this);
    }

    @Override
    public String toString() {
        return "name: " + name + "; bread: " + breed + "; color: " + color.toString();
    }
}