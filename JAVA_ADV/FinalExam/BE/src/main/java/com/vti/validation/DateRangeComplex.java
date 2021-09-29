package com.vti.validation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateRangeComplex { // chua apply
    private Date startOfRange;
    private Date endOfRange;
}
