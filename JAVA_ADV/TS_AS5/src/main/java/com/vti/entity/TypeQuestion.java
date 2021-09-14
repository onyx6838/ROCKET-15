package com.vti.entity;

import com.vti.entity.enumerate.TypeName;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "typequestion")
public class TypeQuestion {
    @Id
    @Column(name = "TypeID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte typeId;

    @Column(name = "TypeName", nullable = false, unique = true)
    @Enumerated(EnumType.ORDINAL)
    private TypeName typeName;
}
