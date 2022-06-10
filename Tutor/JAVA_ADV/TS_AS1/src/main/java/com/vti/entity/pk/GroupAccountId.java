package com.vti.entity.pk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class GroupAccountId implements Serializable {
    @Column(name = "group_id")
    private Short groupId;

    @Column(name = "account_id")
    private Integer accountId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        GroupAccountId that = (GroupAccountId) o;
        return Objects.equals(groupId, that.groupId) &&
                Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, accountId);
    }
}
