package com.vti.entity.primarykey;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class GroupAccountPK implements Serializable {
    @Column(name = "GroupID")
    private byte groupId;

    @Column(name = "AccountID")
    private byte accountId;
}
