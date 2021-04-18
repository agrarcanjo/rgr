package com.example.rgr.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class ListComplexNumber {

    private List<ComplexNumber> complexNumbers;

}
