package com.vti.entity;

import com.vti.entity.enumerate.PositionType;
import com.vti.entity.enumerate.PositionTypeConverter;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private short id;

    @Column(name = "position_name")
    @Convert(converter = PositionTypeConverter.class)
    private PositionType positionType;

    @OneToMany(mappedBy = "position")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Account> accounts;
}
