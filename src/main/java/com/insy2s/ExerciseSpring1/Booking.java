package com.insy2s.ExerciseSpring1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    private String room;
    private Date date ;
    private int id;


}
