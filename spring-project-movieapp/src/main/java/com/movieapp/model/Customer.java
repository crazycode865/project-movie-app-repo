/**
 * @Author:Awadhesh
 * Date:14-05-2022
 * Time:19:07
 * Project Name:project-movie-application
 */
package com.movieapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(generator = "customer_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "customer_gen",sequenceName = "customer_seq",initialValue = 1,allocationSize = 1)
    private Integer customerId;
    @Column(length = 20)
    private String customerName;
    private String emailId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "customer")
    private Set<Booking> booking;

    public Customer(String customerName, String emailId, Address address, Set<Booking> booking) {
        this.customerName = customerName;
        this.emailId = emailId;
        this.address = address;
        this.booking = booking;
    }
}

