package com.itsukaa.realtimebus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Line {
    SingleLine singleLine;
    SingleLine returnSingleLine;
}
